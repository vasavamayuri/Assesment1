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
@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String qua=req.getParameter("qua");
		String email=req.getParameter("email");
		
		
		Student student= new Student (name,dob,address,qua,email);
		
		sDAO dao= new sDAO(DBConnect.getConn());
		HttpSession session=req.getSession();// page par msg dispalu karava mate use thy
		boolean f=dao.addStudent(student);
		if(f)
		{
			session.setAttribute("succMsg", "student detail successfully...");
			resp.sendRedirect("add_student.jsp");
			//System.out.println("student detail successfully...");
		}
		
		else {
			session.setAttribute("errorMsg", "wrong");
			resp.sendRedirect("add_student.jsp");
		}
		
	}
	
	
	
	
	
	
	
	

}
