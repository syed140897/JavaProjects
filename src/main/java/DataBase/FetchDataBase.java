package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FetchDataBase {
   
	Connection connection;
	
	public ResultSet FetchEmployeeData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/creativemind","root","admin");
		Statement st= connection.createStatement();
		ResultSet rs=st.executeQuery("select * from Employee_Detailes");
		return rs;
	}

	
	
}
