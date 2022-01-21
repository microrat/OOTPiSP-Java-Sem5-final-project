package specialization;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.Spec;
import pack.Storage;

public class EditSpec extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Integer id = Integer.parseInt(req.getParameter("id"));
			Spec spec = Storage.readByIdSpec(id);
			req.setAttribute("spec", spec);
		} catch (NumberFormatException e) {

		} catch (SQLException e) {
			throw new ServletException(e);

		}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/editSpec.jsp")
				.forward(req, resp);
	}
}