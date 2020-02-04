package testdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	
	public static void main(String[] args) {
	
	Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    
    try {
    	
    	   try {
			connection = DataTest.createConnectionToMySQL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE emp_no=?");
           preparedStatement.setInt(1, 19);               
           boolean b=preparedStatement.execute();
           if(b==true)
                 System.out.println("");
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