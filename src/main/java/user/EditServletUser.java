package user;

import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.*;

public class EditServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            User usr = Storage.readByIdUsers(id);
            req.setAttribute("usr", usr);
        } catch(NumberFormatException e) {

        } catch(SQLException e) {
            throw new ServletException(e);

        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editUser.jsp")
                                                      .forward(req, resp);
    }
}