package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class TellerSummary_database {

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
			resultSet = statement.executeQuery("select o.BranchName, OperatorName, TicketServed, \r\n"
					+ "-- day woked , logged timr, service time\r\n"
					+ "CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgServiceTime,\r\n"
					+ "case SUM(ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TicketServedWithInST)) / CONVERT(DECIMAL(18,2), isnull(SUM(ServedTickets),0)) as decimal(18,4)) * 100 as decimal(18,0))), 0) end as ServiceSLAPercentage,\r\n"
					+ "    ( case when TotalLoginTime > 0 then 1 else 0 end) \r\n"
					+ "		as DaysWorked,\r\n"
					+ "		eqreport.dbo.getTotalTimeFromSecs((TotalLoginTime), '') LoggedTime,\r\n"
					+ "\r\n"
					+ "		cast(isnull(CASE WHEN SUM(TotalLoginTime) > 0 THEN (cast(SUM(TotalServingTime) as decimal(18,2))/SUM(TotalLoginTime))*100  ELSE 0 END,0.00) as decimal(18,2)) ServingPercentage, \r\n"
					+ "		cast(isnull(CASE WHEN SUM(TotalLoginTime) > 0 THEN (cast(SUM(TotalBackendTime) as decimal(18,2))/SUM(TotalLoginTime))*100 ELSE 0 END,0.00) as decimal(18,0)) BackendPercentage, \r\n"
					+ "\r\n"
					+ "IdlePercentage,isnull(CONVERT(varchar, DATEADD(ss, sum(o.ProcessingTime), 0), 108), '-') ProcessingTime\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "from  eqreport_Archival..DashboardBranchOperatorStatus o\r\n"
					+ "inner join eqreport..DashboardBranchCategoryStatus b on b.BranchID = o.BranchID\r\n"
					+ " where o.BranchID=232 \r\n"
					+ " group by o.BranchName,OperatorName, TicketServed, IdlePercentage, o.ProcessingTime,TotalLoginTime");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
				System.out.println("");
				System.out.println(resultSet.getString(1) + "  "
						+ resultSet.getString(2)+ "  "+ resultSet.getString(3) + "  "+ resultSet.getString(4)  +"  "+ 
						 resultSet.getString(5)+ "  "+ resultSet.getString(6) + "  "+ resultSet.getString(7)  + "  "+
						 resultSet.getString(8)+ "  "+ resultSet.getString(9) + "  "+ resultSet.getString(10)  + "  "+
						 resultSet.getString(11));
		
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
			resultSet = statement.executeQuery("select  ServedTickets, IssuedTickets ,(cast((cast (ServedTickets as decimal(18,0) )/IssuedTickets)as decimal(18,2)) * 100) servedissue\r\n"
					+ ",CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) + SUM(NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalWaitTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets) + SUM(NoShowTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgWaitTime\r\n"
					+ ",((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketCalledWithInWT)) / CONVERT(DECIMAL(18,2), isnull(SUM(D.IssuedTickets),0)) as decimal(18,4)) * 100 as decimal(18,0)))) as SLA\r\n"
					+ ",CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgServiceTime\r\n"
					+ ",	case SUM(D.ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketServedWithInST)) / CONVERT(DECIMAL(18,2), isnull(SUM(ServedTickets),0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end as ServiceSLAPercentage\r\n"
					+ ",SUM(D.NoShowTickets) as NoShowTickets,\r\n"
					+ "case SUM(D.NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.NoShowTickets)) / CONVERT(DECIMAL(18,2), isnull(SUM(IssuedTickets), 0)) as decimal(18,4)) * 100 as decimal(18,0))), 2) end as PercentageNoShowTickets\r\n"
					+ "from eqreport..DashboardBranchCategoryStatus D where BranchID=231 and CategoryID = 'EMO'\r\n"
					+ "group by ServedTickets,IssuedTickets\r\n"
					+ "");

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


