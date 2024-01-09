package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.EmployeeDetails;

public class ModifiedDataBase {
	Boolean result=false;
	Connection connection;
	public Boolean modifiedUser(EmployeeDetails employee) throws SQLException {
		
		String name=employee.getName();
		int id=employee.getId();
		String role=employee.getRole();
		boolean fresher=employee.isFreshers();
		double salary=employee.getSalary();
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/creativemind","root","admin");
		PreparedStatement pr= connection.prepareStatement("update Employee_Detailes set id=?,role=?,salary=?,fresher=? where name=?" );
		pr.setInt(1, id);
		pr.setNString(2, role);
		pr.setDouble(3, salary);
		pr.setBoolean(4, fresher);
		pr.setNString(5, name);
		int i=pr.executeUpdate();
		
		if(i>0) {
			result=true;
		}
		return result;
		
	}

}
