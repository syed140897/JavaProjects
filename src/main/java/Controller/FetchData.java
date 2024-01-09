package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import DataBase.FetchDataBase;
import Entity.EmployeeDetails;

public class FetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FetchDataBase fetchDataBase=new FetchDataBase();
		EmployeeDetails employee=new EmployeeDetails();
		ResultSet rs = null;
		try {
			rs= fetchDataBase.FetchEmployeeData();
			while(rs.next()) {
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getNString("name"));
				employee.setRole(rs.getNString("role"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setFreshers(rs.getBoolean("fresher"));
				System.out.println(employee.toString());
	           
			}		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("FetchEmployee.jsp");
			requestDispatcher.forward(request, response);
	
}
}
