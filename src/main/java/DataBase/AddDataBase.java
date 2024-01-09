package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import Entity.EmployeeDetails;

public class AddDataBase {
	static Boolean output=true;
	Connection connection;
	public Boolean SaveEmployee(EmployeeDetails employeeDetails) throws ClassNotFoundException, SQLException {
		
		
		int id=employeeDetails.getId();
		String name=employeeDetails.getName();
		String role=employeeDetails.getRole();
		double salary=employeeDetails.getSalary();
		boolean fresher=employeeDetails.isFreshers();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/creativemind","root","admin");
		
		PreparedStatement statement=connection.prepareStatement("insert into Employee_Detailes (id,name,role,salary,fresher)values(?,?,?,?,?)");
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setString(3, role);
		statement.setDouble(4, salary);
		statement.setBoolean(5, fresher);
		output=statement.execute();
		
		if(output) {
			output=true;
		}
		connection.close();
		return output;
		
	}

	
}
