package pageObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class dbjava {

	 // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	
    	System.out.println("SQL Connected to Table: eqreport");
        
    	Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;

      try {
        // Load the SQL Server JDBC driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Establish a connection to the database
        connection = DriverManager.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

        // Create a statement to execute the query
        statement = connection.createStatement();
        DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
        // Execute the query
        resultSet = statement.executeQuery("select CategoryID, CategoryName, TicketServed, ServiceTimeException from eqreport..DashboardBranchChart  where BranchName= 'testbranch5' and CategoryID= 'CCH' and TicketServed != 0;\r\n"
        		+ "" );
        System.out.println("Driver name: " + dm.getDriverName());
        System.out.println("Driver version: " + dm.getDriverVersion());
        System.out.println("Product name: " + dm.getDatabaseProductName());
        System.out.println("Product version: " + dm.getDatabaseProductVersion());
        System.out.println("CategoryID \t\t"+"||" +"\t CategoryName \t\t"+ "||" + "TicketServed"+ "||" + " \t ServiceTimeException" );
        // Iterate over the result set and print the data
        while (resultSet.next()) {
          System.out.println(resultSet.getString(1) + "\t||\t" + resultSet.getString(2)+ "\t||\t\t" + resultSet.getString(3) + "\t||\t\t" + resultSet.getString(4)  + "\t||\t\t");
          String TicketServed = resultSet.getString(3);
          System.out.println("Ticket_Served: " +TicketServed);
          int i=Integer.parseInt(TicketServed);  
          
          
          String ServiceTimeException = resultSet.getString(4);
          System.out.println("Service_Time_Exception: " +ServiceTimeException);
          int j=Integer.parseInt(ServiceTimeException);  

          
          
          int Ticket_Served_WithinServiceTime = (i - j);
          System.out.println("No of Ticket Served Within Service Time: " + Ticket_Served_WithinServiceTime);
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        // Close the result set, statement, and connection
        try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
        try { if (statement != null) statement.close(); } catch (Exception e) {};
        try { if (connection != null) connection.close(); } catch (Exception e) {};
      }
    	
    }    	
    }
