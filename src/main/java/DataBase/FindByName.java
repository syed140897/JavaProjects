package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FindByName {

	Connection connection;
	public ResultSet FindData(String name) throws SQLException {
		String Empname=name;
	
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/creativemind","root","admin");
		PreparedStatement pr= connection.prepareStatement("select * from Employee_Detailes where name=?");
		pr.setString(1, Empname);
		
		ResultSet rs=pr.executeQuery();
		
		return rs;
		
	}

}
