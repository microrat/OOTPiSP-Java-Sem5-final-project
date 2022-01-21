package doctor;

import java.io.IOException;
import java.util.Collection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.*;


public class EditDoc extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = null;
		
		try {
			id = Integer.parseInt(req.getParameter("id"));
			
			Doc doctor = Storage.readByIdDocSingle(id);
			//Spec spec = Storage.readByIdSpec(idSpec);
			req.setAttribute("doctor", doctor);
			//req.setAttribute("spec", spec);
		
		} catch (NumberFormatException e) {

		} catch (SQLException e) {
			throw new ServletException(e);

		}
		if(id == null){
		id = Integer.parseInt(req.getParameter("idSp"));
		req.setAttribute("idSp", id);
		}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/editDoc.jsp")
				.forward(req, resp);
	}
}