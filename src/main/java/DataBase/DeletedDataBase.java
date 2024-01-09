package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletedDataBase {

	Connection connection;
	public Boolean deletedUser(int id) throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/creativemind","root","admin");
		Statement st= connection.createStatement();
		Boolean result= st.execute("delete from Employee_Detailes where id="+"'"+id+"'");
		return result;	
	}

}
