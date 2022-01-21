package doctor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.Storage;
import pack.Doc;

public class SortDoc extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			String field = (String)req.getParameter("field");
			Integer id = Integer.parseInt(req.getParameter("id"));
			Collection<Doc> docList = (Collection<Doc>)Storage.SortDoc(id,field);
			req.setAttribute("docList", docList);
			req.setAttribute("id", id);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/indexDoc.jsp")
					.forward(req, resp);

		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}
}