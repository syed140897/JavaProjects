package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.FindByName;
import Entity.EmployeeDetails;


public class FetchByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		EmployeeDetails employee=new EmployeeDetails();
		FindByName findByName=new FindByName();
		try {
			ResultSet rs= findByName.FindData(name);
			while(rs.next()) {
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getNString("name"));
				employee.setRole(rs.getNString("role"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setFreshers(rs.getBoolean("fresher"));
				System.out.println(employee.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
