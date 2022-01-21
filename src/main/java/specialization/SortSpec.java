package specialization;

import pack.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SortSpec extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			String field = (String)req.getParameter("field");
			Collection<Spec> specList = Storage.sortSpec(field);
			req.setAttribute("specList", specList);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp")
					.forward(req, resp);

		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}
}


