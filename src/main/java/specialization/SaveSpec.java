package specialization;

import pack.Spec;
import pack.Storage;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.SQLException;





public class SaveSpec extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
       
        Spec object = new Spec();
        object.setName(req.getParameter("name"));
        object.setUzk(req.getParameter("uzk"));
        object.setAmount(Integer.parseInt(req.getParameter("amount")));
        object.setSalary(Integer.parseInt(req.getParameter("salary")));
		
        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}

        try {

            if(object.getId() == null) {
                Storage.createSpec(object);
            } else {
                Storage.updateSpec(object);
            }

        } catch(SQLException e) {
            throw new ServletException(e);
        }


        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}
