package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import DataBase.AddDataBase;
import Entity.EmployeeDetails;

@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int id=Integer.parseInt(request.getParameter("id")) ;
		String name=request.getParameter("name");
		String role=request.getParameter("role");
		double salary=Integer.parseInt(request.getParameter("salary"));
		String fresher=request.getParameter("fresher"); 
		
		EmployeeDetails employeeDetails=new EmployeeDetails();
		employeeDetails.setId(id);
		employeeDetails.setName(name);
		employeeDetails.setRole(role);
		employeeDetails.setSalary(salary);
		boolean result=fresher.equals("fresher")?true:false;
		employeeDetails.setFreshers(result);
		
		
		AddDataBase addDataBase=new AddDataBase();
		try {
			Boolean saveResult=addDataBase.SaveEmployee(employeeDetails);
			if(saveResult.equals(false)){
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("AddSuccessFully.jsp");
				 requestDispatcher.forward(request, response);
			}else {
				response.sendRedirect("AddFailure.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
	}

}
