package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import DataBase.FindByName;
import DataBase.ModifiedDataBase;
import Entity.EmployeeDetails;


public class UpdateByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		String role=request.getParameter("role");
		double salary=Integer.parseInt(request.getParameter("salary"));
	    String emp=(request.getParameter("fresher"));
	    boolean fresher=(emp.equals("fresher"))?true:false;
		
		
		FindByName findByName=new FindByName();
		try {
			ResultSet rs=findByName.FindData(name);
			EmployeeDetails employee=new EmployeeDetails();
			while(rs.next()) {
				employee.setId(id);
				employee.setName(name);
				employee.setRole(role);
				employee.setSalary(salary);
				employee.setFreshers(fresher);
				System.out.println(employee.toString());
			}
			ModifiedDataBase modifieddata=new ModifiedDataBase();;
			Boolean result= modifieddata.modifiedUser(employee);
			if(result) {
			RequestDispatcher rq=request.getRequestDispatcher("ModifiedSuccess.jsp");
			rq.forward(request, response);
			}else {
				response.sendRedirect("AddFailure.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
