import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pack.*;


public class Login extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if(login != null && password != null && role != null) {
            /* условие выполняется, если сервлету была передана
             * форма авторизации */
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
            try {
                if(Storage.checkUser(user)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    resp.sendRedirect(req.getContextPath());
                } else {
                    String message = "Имя пользователя или пароль неопознанны";
                    String url = req.getContextPath()
                               + "/login.jsp?message="
                               + URLEncoder.encode(message, "UTF-8");
                               System.out.println(req.getContextPath()+ " Login Serv   " + url);
                    resp.sendRedirect(url);
                }
            } catch(SQLException e) {
                System.out.println(e);
                throw new ServletException(e);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            System.out.println("!!!" + req.getContextPath()+ " Login Serv   ");
        }
    }
}