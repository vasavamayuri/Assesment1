package comm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.sDAO;
import com.entity.Student;
@WebServlet("/delete")
public class deletes extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		sDAO dao=new sDAO(DBConnect.getConn());
		boolean f=dao.deleteStudent(id);
		
		HttpSession session =req.getSession();
		if(f)
		{
			session.setAttribute("succMsg", "student detail delete successfully...");
			resp.sendRedirect("index.jsp");
			//System.out.println("student detail successfully...");
		}
		
		else {
			session.setAttribute("errorMsg", "wrong");
			resp.sendRedirect("index.jsp");
		}
	
	}

	
}
