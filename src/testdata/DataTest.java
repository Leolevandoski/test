package testdata;

import java.sql.Connection;
import testdata.DataTest;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataTest {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/employees?useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
		
		
		while(resultSet.next()) {
		      System.out.println(resultSet.getString("first_name"));
		      System.out.println(resultSet.getString("last_name"));
		}
		
		return connection;
	}

	public static void main(String[] args) throws Exception {

		Connection conexao = createConnectionToMySQL();

		if (conexao != null) {
			System.out.println("Conexão obtida com sucesso!" + conexao);
			conexao.close();
		}

	}
}
