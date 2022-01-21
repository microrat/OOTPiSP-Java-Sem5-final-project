package specialization;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.Storage;

public class DeleteSpec extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] ids = req.getParameterValues("id");
		if (ids == null) {
			resp.sendRedirect(req.getContextPath() + "/index.html");
		} else {
			for (String id : ids) {
				try {
					Storage.deleteSpec(Integer.parseInt(id));
				} catch (NumberFormatException e) {

				} catch (SQLException e) {
					throw new ServletException(e);

				}
			}
			resp.sendRedirect(req.getContextPath() + "/index.html");
		}
	}
}