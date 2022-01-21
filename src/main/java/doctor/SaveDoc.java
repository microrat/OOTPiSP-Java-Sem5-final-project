package doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import pack.*;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.SQLException;





public class SaveDoc extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id_spec"));
        Spec spec;
		try {
			spec = Storage.readByIdSpec(id);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		String now="16.11.2021";
		Date bday;
		
		
		Doc doctor=new Doc();
		doctor.setFio(req.getParameter("fio"));
		try {
			bday = format.parse(req.getParameter("bday"));
			
			Date nowDate=format.parse(now);
			long difference = nowDate.getTime() - bday.getTime();
			int years=(int) (difference / (365.25 *24 * 60 * 60 * 1000));
			if(years<20) {
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/ageErr.jsp")
				.forward(req, resp);
			}
			else {
				doctor.setBday(req.getParameter("bday"));
				doctor.setHiring(req.getParameter("hiring"));			
				doctor.setSpecId(id);
				System.out.println(spec.getUzk());
				if(spec.getUzk().equals("y")) {
					
					doctor.setNumber(0);
				}
				else {
					doctor.setNumber(Integer.parseInt(req.getParameter("number")));
				}
				try {
					doctor.setId(Integer.parseInt(req.getParameter("id")));
					
					
				} catch (NumberFormatException e) {
				}
				try {

					if (doctor.getId() == null) {
						Storage.createDoc(doctor);
					} else {
						Storage.updateDoc(doctor);
					}
				} catch (SQLException e) {
					throw new ServletException(e);
				}
				resp.sendRedirect(req.getContextPath()
						+ "/indexDoc.html?id=" + id);//id это id_spec
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		

}}