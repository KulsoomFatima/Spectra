package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.testng.annotations.Test;

public class AllCom_database {

	public String open_counters;
	public String ticket_transferred;
	public String ticket_issue;
	public String ticket_serve;
	public String aservicetime;
	public String awaittime;
	public String mservicetime;
	public String ticnoshow;
	public String servicecomplainc;
	public String waitingcomplainc;
	public String queuesize;
	public String max_waittime;
	public String STE;
	public String WTE;
	public List<String> Brancheva;

	@Test
	public String opencounters() throws SQLException {

		System.out.println("Record from database: ");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Load the SQL Server JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Establish a connection to the database
			connection = DriverManager
					.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

			// Create a statement to execute the query
			statement = connection.createStatement();
			DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
			// Execute the query
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | ECL-Examenes COVID Latam |EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String open = resultSet.getString(12);
			System.out.println("Open Counters: " + open);
			//int i = Integer.parseInt(TicketServedWithinWT);
			
			open_counters = open;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the result set, statement, and connection
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return open_counters;

	}

	@Test
	public String ticket_transffered() {

		System.out.println("SQL Connected to Waiting: ");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Load the SQL Server JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Establish a connection to the database
			connection = DriverManager
					.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

			// Create a statement to execute the query
			statement = connection.createStatement();
			DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
			// Execute the query
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | ECL-Examenes COVID Latam |EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");
			
			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ticket_trans = resultSet.getString(15);
			System.out.println("Ticket transferred: " + ticket_trans);
			//int i = Integer.parseInt(TicketServedWithinWT);
			
			ticket_transferred = ticket_trans;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the result set, statement, and connection
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ticket_transferred;

	
	}
	
	
	@Test
	public String ticket_in_serving() {

		
		System.out.println("SQL Connected to Waiting: ");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Load the SQL Server JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Establish a connection to the database
			connection = DriverManager
					.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

			// Create a statement to execute the query
			statement = connection.createStatement();
			DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
			// Execute the query
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | ECL-Examenes COVID Latam |EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ticket_issued = resultSet.getString(0);
			System.out.println("Ticket issued: " + ticket_issued);
			
			ticket_issue = ticket_issued;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the result set, statement, and connection
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ticket_issue;

	
	}

	public String ticket_issued() {
		
		System.out.println("Record from database: ");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Load the SQL Server JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Establish a connection to the database
			connection = DriverManager
					.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

			// Create a statement to execute the query
			statement = connection.createStatement();
			DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
			// Execute the query
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | ECL-Examenes COVID Latam |EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");
			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ticket_issued = resultSet.getString(17);
			System.out.println("Ticket issued: " + ticket_issued);
			ticket_issue = ticket_issued;

			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return ticket_issue;

	}
	@Test
	public String ticket_served() {

		System.out.println("SQL Connected to Waiting: ");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Load the SQL Server JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Establish a connection to the database
			connection = DriverManager
					.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

			// Create a statement to execute the query
			statement = connection.createStatement();
			DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
			// Execute the query
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | ECL-Examenes COVID Latam |EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ticket_served = resultSet.getString(1);
			System.out.println("Ticket served: " + ticket_served);
			
			ticket_serve = ticket_served;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket_serve;

	}
	
	@Test
	public String avgservicetime() {

		System.out.println("SQL Connected to Waiting: ");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Load the SQL Server JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Establish a connection to the database
			connection = DriverManager
					.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

			// Create a statement to execute the query
			statement = connection.createStatement();
			DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
			// Execute the query
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String avgservicetime = resultSet.getString(2);
			System.out.println("avg service time: " + avgservicetime);
			
			aservicetime = avgservicetime;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aservicetime;

	}


public String avgwaittime() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String avgwaittime = resultSet.getString(5);
		System.out.println("avg wait time: " + avgwaittime);
		
		awaittime = avgwaittime;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return awaittime;

}

public String maxservicetime() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String maxservicetime = resultSet.getString(19);
		System.out.println("Max service time: " + maxservicetime);
		
		mservicetime = maxservicetime;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return mservicetime;

}

public String ticketnoshow() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String ticketnoshow = resultSet.getString(20);
		System.out.println("Ticket no show: " + ticketnoshow);
		
		ticnoshow = ticketnoshow;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ticnoshow;

}

public String servicecomplaince() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String servicecomplaince = resultSet.getString(3);
		System.out.println("Service compliance: " + servicecomplaince);
		
		servicecomplainc = servicecomplaince;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return servicecomplainc;

}

public String waitingcomplaince() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String waitingcomplaince = resultSet.getString(6);
		System.out.println("Waiting compliance: " + waitingcomplaince);
		
		waitingcomplainc = waitingcomplaince;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return waitingcomplainc;


}

public String queuesize() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String queue = resultSet.getString(21);
		System.out.println("Queue Size: " + queue);
		
		queuesize = queue;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return queuesize;


}

public String maxwaittime() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String maxwaittime = resultSet.getString(18);
		System.out.println("max wait time: " + maxwaittime);
		
		max_waittime = maxwaittime;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return max_waittime;

}

public String STE() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String ste = resultSet.getString(23);
		System.out.println("Service time exception: " + ste);
		
		STE = ste;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return STE;

}

public String WTE() {

	System.out.println("SQL Connected to Waiting: ");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
		// Load the SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Establish a connection to the database
		connection = DriverManager
				.getConnection("jdbc:sqlserver://10.10.10.31\\SQLEXPRESS:1433;user=sa;password=wavetec");

		// Create a statement to execute the query
		statement = connection.createStatement();
		DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		// Execute the query
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-01-22','2023-02-20','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String wte = resultSet.getString(22);
		System.out.println("Service time exception: " + wte);
		
		WTE = wte;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return WTE;

}

}


