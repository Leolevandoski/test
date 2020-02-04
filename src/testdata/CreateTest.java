package testdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTest {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// criar conexao
		try {
			connection = DataTest.createConnectionToMySQL();

			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Date dateobj = new Date();

			preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES(?,?,?,?,?,?)");
			preparedStatement.setInt(1, 19);
			preparedStatement.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			preparedStatement.setString(3, "Brunooo");
			preparedStatement.setString(4, "Galeski");
			preparedStatement.setString(5, "M");
			preparedStatement.setDate(6, new java.sql.Date(new java.util.Date().getTime()));

			boolean b = preparedStatement.execute();
			if (b == true)
				System.out.println("1 record inserted...");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
				}
			}
	

	
	}
