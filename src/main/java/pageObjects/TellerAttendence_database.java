package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class TellerAttendence_database {

	public String tellersummarytable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String tellersummarytable() throws SQLException {

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
			resultSet = statement.executeQuery("select distinct\r\n"
					+ "o.BranchName, \r\n"
					+ "OperatorName as teller,\r\n"
					+ "LEFT(CONVERT(VARCHAR,  o.CurrentDate , 103), 10) [Date],   \r\n"
					+ "TicketServed, \r\n"
					+ "isnull(case when SUM(TicketServed) > 0 then CONVERT(varchar, DATEADD(s, isnull(AVG(o.AvgServiceTime),0), 0), 108) end,'00:00:00') as AvgServiceTime,\r\n"
					+ "case SUM(o.TicketServed) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(o.TicketServedWS)) / CONVERT(DECIMAL(18,2), isnull(SUM(TicketServed),2)) as decimal(18,4)) * 100 as decimal(18,0))), 2) end as ServiceSLAPercentage,\r\n"
					+ "\r\n"
					+ "eqreport.dbo.getTotalTimeFromSecs((TotalLoginTime), '') LoggedTime,	\r\n"
					+ "cast(isnull(CASE WHEN SUM(TotalLoginTime) > 0 THEN (cast(SUM(TotalServingTime) as decimal(18,2))/SUM(TotalLoginTime))*100  ELSE 0 END,0.00) as decimal(18,2)) ServingPercentage, \r\n"
					+ "cast(isnull(CASE WHEN SUM(TotalLoginTime) > 0 THEN (cast(SUM(TotalBackendTime) as decimal(18,2))/SUM(TotalLoginTime))*100 ELSE 0 END,0.00) as decimal(18,2)) BackOfficePercentage, \r\n"
					+ "cast(isnull(CASE WHEN SUM(TotalLoginTime) > 0 THEN (cast(SUM(TotalIdleTime) as decimal(18,2))/SUM(TotalLoginTime))*100 ELSE 0 END,0.00) as decimal(18,2)) IdlePercentage,\r\n"
					+ "isnull(CONVERT(VARCHAR, min(c.OpenTime), 108),'00:00:00') ArrivalTime,\r\n"
					+ "isnull(CONVERT(VARCHAR, max(C.CloseTime), 108),'00:00:00') EndTime,\r\n"
					+ "isnull(CONVERT(varchar, DATEADD(ss, sum(o.ProcessingTime), 0), 108), '-') ProcessingTime\r\n"
					+ "\r\n"
					+ "from  eqreport_Archival..DashboardBranchOperatorStatus o\r\n"
					+ "inner join eqreport_Archival..PSRCounter c on c.BranchId = o.BranchID and c.OperatorId = o.OperatorID\r\n"
					+ " where o.BranchID=232   \r\n"
					+ " group by o.BranchName,OperatorName, TicketServed, IdlePercentage, o.ProcessingTime,TotalLoginTime,c.OperatorId,c.BranchId,o.CurrentDate\r\n"
					+ "\r\n"
					+ "");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			

				System.out.println("");
				System.out.println(resultSet.getString(1) + "  "
						+ resultSet.getString(2)+ "  "+ resultSet.getString(3) + "  "+ resultSet.getString(4)  +"  "+ 
						 resultSet.getString(5)+ "  "+ resultSet.getString(6) + "  "+ resultSet.getString(7)  + "  "+
						 resultSet.getString(8)+ "  "+ resultSet.getString(9) + "  "+ resultSet.getString(10)  + "  "+
						 resultSet.getString(11)+ "  "+ resultSet.getString(12) + "  "+ resultSet.getString(13));
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tellersummarytable;

	}
	
	
	

	@Test
	public String summaryrecord() throws SQLException {

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
			resultSet = statement.executeQuery("");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				System.out.println("Summary");
				System.out.println("Ticket(s) Served / Issued");
				String Servedticket = resultSet.getString(1);
				System.out.println("Served ticket: " +Servedticket);
				
				String ticketIssue = resultSet.getString(2);
				System.out.println("ticket Issue: " +ticketIssue);
			
				
				String servedissued = resultSet.getString(3);
				System.out.println("served issued %: " +servedissued);
				System.out.println("---------------------------------");
				System.out.println("");
				
				System.out.println("Waiting Time");
				String AvgWaitTime = resultSet.getString(4);
				System.out.println("Avg: " +AvgWaitTime);
				
				String SLA = resultSet.getString(5);
				System.out.println("SLA: " +SLA + "%");
				System.out.println("---------------------------------");
				System.out.println("");
				
				System.out.println("Service Time");

				String avgS = resultSet.getString(6);
				System.out.println("avg: " +avgS);
				
				String ServiceSLACount = resultSet.getString(7);
				System.out.println("SLA: " +ServiceSLACount);
				
				System.out.println("---------------------------------");
				System.out.println("");
				
				System.out.println("No Show");

				String ServiceSLAPercentage = resultSet.getString(8);
				System.out.println(ServiceSLAPercentage);
				
				String NoShowTickets = resultSet.getString(9);
				System.out.println("NoShowTickets: " +NoShowTickets);
				
				
				
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summaryrecord;

	}



}


