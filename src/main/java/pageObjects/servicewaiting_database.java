package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class servicewaiting_database {

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

		System.out.println("Record from database open counters: ");

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
			resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
				//int i=1;
				//System.out.println(resultSet.getString(i));
				
				//i++;
				String open = resultSet.getString(12);
			
			
			
			System.out.println("Open Counters: " + open);
			
			open_counters = open;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return open_counters;

	}

	@Test
	public String ticket_transffered() {

		System.out.println("SQL Connected to ticket_transffered: ");

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
			resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
					+ "");
			
			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ticket_trans = resultSet.getString(16);
			System.out.println("Ticket transferred: " + ticket_trans);
			//int i = Integer.parseInt(TicketServedWithinWT);
			
			ticket_transferred = ticket_trans;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket_transferred;

	
	}
	
	
	@Test
	public String ticket_in_serving() {

		
		System.out.println("SQL Connected to ticket_in_serving: ");

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
			resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
					+ "");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ticket_in_serving = resultSet.getString(17);
			System.out.println("ticket_in_serving: " + ticket_in_serving);
			
			ticket_issue = ticket_in_serving;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket_issue;

	
	}

	public String ticket_issued() {
		
		System.out.println("Record from database ticket_issued: ");

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
			resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
					+ "");
			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ticket_issued = resultSet.getString(18);
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

		System.out.println("SQL Connected to ticket_served: ");

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
			resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
					+ "");

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

		System.out.println("SQL Connected avg service time: ");

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
			resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
					+ "");

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

	System.out.println("SQL Connected avg wait time: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

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

	System.out.println("SQL Connected max service time: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

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

	System.out.println("SQL Connected ticket no show: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String ticketnoshow = resultSet.getString(21);
		System.out.println("Ticket no show: " + ticketnoshow);
		
		ticnoshow = ticketnoshow;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ticnoshow;

}

public String servicecomplaince() {

	System.out.println("SQL Connected service complaince: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String servicecomplaince = resultSet.getString(3);
		System.out.println("Service compliance: " + servicecomplaince+"%");
		
		servicecomplainc = servicecomplaince;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return servicecomplainc;

}

public String waitingcomplaince() {

	System.out.println("SQL Connected to waiting complaince: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String waitingcomplaince = resultSet.getString(6);
		System.out.println("Waiting compliance: " + waitingcomplaince+"%");
		
		waitingcomplainc = waitingcomplaince;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return waitingcomplainc;


}

public String queuesize() {

	System.out.println("SQL Connected to queue size: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String queue = resultSet.getString(22);
		System.out.println("Queue Size: " + queue);
		
		queuesize = queue;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return queuesize;


}

public String maxwaittime() {

	System.out.println("SQL Connected to max wait time: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String maxwaittime = resultSet.getString(19);
		System.out.println("max wait time: " + maxwaittime);
		
		max_waittime = maxwaittime;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return max_waittime;

}

public String STE() {

	System.out.println("SQL Connected to STE: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String ste = resultSet.getString(24);
		System.out.println("Service time exception: " + ste);
		
		STE = ste;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return STE;

}

public String WTE() {

	System.out.println("SQL Connected to WTE: ");

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
		resultSet = statement.executeQuery("execute eqreport.dbo.cd_getServiceWaitingCounter '231','true','2023-03-13','2023-03-13','ECL-Examenes COVID Latam |EMO-EMOS'\r\n"
				+ "");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String wte = resultSet.getString(23);
		System.out.println("Wait time exception: " + wte);
		
		WTE = wte;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return WTE;

}

}


