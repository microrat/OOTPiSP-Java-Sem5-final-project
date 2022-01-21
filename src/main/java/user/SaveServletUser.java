package user;


import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.*;
//Закончен
public class SaveServletUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
//(`id`, `FIO`, `post`, `gender`,`dateOfBirth`,`koursesNumber`)
        req.setCharacterEncoding("UTF-8");
        User usr = new User();
        usr.setRole(req.getParameter("role"));
        usr.setLogin(req.getParameter("login"));
        usr.setPassword(req.getParameter("password"));


        try {
            usr.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}

        try {
            System.out.println(req.getParameter("id") +"-------"+ usr.id);
            if(usr.id == null) {
                Storage.createUsers(usr);
            } else {
                Storage.updateUsers(usr);
            }

        } catch(SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}