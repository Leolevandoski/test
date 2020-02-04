package testdata;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class UpdateName {
	private static Connection connection;

	public static void main(String[] args) {
	
	connection = null;
    PreparedStatement preparedStatement = null;
	
	try {
		
		try {
			connection = DataTest.createConnectionToMySQL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		preparedStatement = connection.prepareStatement("UPDATE employees SET last_name = ? WHERE emp_no=?");
		preparedStatement.setString(1, "LEVANDOSKI");
		preparedStatement.setInt(2, 1);
		boolean b = preparedStatement.execute();
		if (b == true)
			System.out.println("Last Name for id= " + 1);
	} catch (SQLException sqlEx) {
		sqlEx.printStackTrace();
		System.exit(1);
	
	} finally {
		try {
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.exit(1);
			}
}
}
}