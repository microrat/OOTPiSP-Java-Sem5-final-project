package doctor;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.*;

public class DeleteDoc extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id_spec = req.getParameter("id");
		String[] ids = req.getParameterValues("ids");
		if (ids == null) {
			resp.sendRedirect(req.getContextPath() + "/indexDoc.html?id=" + id_spec);
		} else {
			for (String id : ids) {
				try {
					Storage.deleteDoc(Integer.parseInt(id));
				} catch (NumberFormatException e) {

				} catch (SQLException e) {
					throw new ServletException(e);

				}
			}
			resp.sendRedirect(req.getContextPath() + "/indexDoc.html?id=" + id_spec);
		}
	}
	}
