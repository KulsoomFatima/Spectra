package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class servicehourly_database {

	public String hourlytable;
	public String ticket_transferred;
	public String hourlyrecord;
	public String ticket_serve;
	

	@Test
	public String hourlytable() throws SQLException {

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
			resultSet = statement.executeQuery("select substring(CONVERT(varchar, DATEADD(hh, DBC.Inhour, 0), 108),1,5) as Inhour,\r\n"
					+ " SUM(DBC.TicketIssued) as IssuedTickets,\r\n"
					+ " case SUM(DBC.TicketIssued) when 0 then 0 \r\n"
					+ "else\r\n"
					+ " cast((CAST(SUM(DBC.TicketIssued) AS float) / CAST(TicketIssued AS float))*100 as numeric(36,0))end as PercentageIssuedTickets,\r\n"
					+ "  SUM(DBC.TicketServed) as ServedTickets,\r\n"
					+ "case SUM(TicketServed) when 0 then 0 else\r\n"
					+ "cast((CAST(SUM(DBC.TicketServed) AS float) / CAST(sum(TicketServed) AS float))*100 as numeric(36,0))end as PercentageServedTickets,\r\n"
					+ "CONVERT(varchar, DATEADD(ms,ISNULL(AVG(NULLIF(AvgWaitTime, 0)), 0)* 1000, 0), 108)AvgWaitTime,\r\n"
					+ "case SUM(DBC.TicketIssued) when 0 then 0 \r\n"
					+ "else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(DBC.TicketServedWithinWT)) / CONVERT(DECIMAL(18,2), isnull(SUM(DBC.TicketIssued),0)) \r\n"
					+ "as decimal(18,4)) * 100 as decimal(18,2))), 0) end as WaitingSLAPercentage,\r\n"
					+ "isnull(SUM(DBC.TicketServedWithinWT),0)as WaitingSLACount,\r\n"
					+ "CONVERT(varchar, DATEADD(ms,ISNULL(AVG(NULLIF(AvgServiceTime, 0)), 0)* 1000, 0), 108)AvgServiceTime,\r\n"
					+ "\r\n"
					+ "case SUM(DBC.TicketServed) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(DBC.TicketServedWithInST)) / CONVERT(DECIMAL(18,2), isnull(SUM(DBC.TicketServed),0)) as decimal(18,4)) * 100 as decimal(18,0))), 0) end as ServiceSLAPercentage,\r\n"
					+ "\r\n"
					+ "isnull(SUM(DBC.TicketServedWithInST),0) as ServiceSLACount\r\n"
					+ "\r\n"
					+ "from eqreport..DashboardBranchChart  as DBC \r\n"
					+ "where BranchID=231 and CategoryID = 'EMO'  and TicketIssued != 0\r\n"
					+ "\r\n"
					+ "group by DBC.Inhour , TicketIssued\r\n"
					+ "order by Inhour ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				String Hour = resultSet.getString(1);
				System.out.println("Hour: " +Hour);
				
				String ticketIssue = resultSet.getString(2);
				System.out.println("ticket Issue: " +ticketIssue);
			
				
				String TicketsIssuedP = resultSet.getString(3);
				System.out.println("TicketsIssued %: " +TicketsIssuedP);
				
				String ticketserved = resultSet.getString(4);
				System.out.println("ticket Issue: " +ticketserved);
				
				String PercentageServedTickets = resultSet.getString(5);
				System.out.println("Served Tickets %: " +PercentageServedTickets);
				
				String AvgWaitTime = resultSet.getString(6);
				System.out.println("AvgWaitTime: " +AvgWaitTime);
				
				String WaitingSLAPercentage = resultSet.getString(7);
				System.out.println("Waiting SLA %: " +WaitingSLAPercentage);
				
				String WaitingSLACount = resultSet.getString(8);
				System.out.println("Waiting SLA Count: " +WaitingSLACount);
				
				String AvgServiceTime = resultSet.getString(9);
				System.out.println("AvgServiceTime: " +AvgServiceTime);
				
				String ServiceSLAPercentage = resultSet.getString(10);
				System.out.println("ServiceSLAPercentage: " +ServiceSLAPercentage);
				
				String ServiceSLACount = resultSet.getString(1);
				System.out.println("ServiceSLACount: " +ServiceSLACount);
				
	
				
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hourlytable;

	}
	
	
	

	@Test
	public String hourlyrecord() throws SQLException {

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
			resultSet = statement.executeQuery("\r\n"
					+ "select  ServedTickets, IssuedTickets ,(cast((cast (ServedTickets as decimal(18,0) )/IssuedTickets)as decimal(18,2)) * 100) servedissue\r\n"
					+ "					,CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) + SUM(NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalWaitTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets) + SUM(NoShowTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgWaitTime\r\n"
					+ "					,((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketCalledWithInWT)) / CONVERT(DECIMAL(18,2), isnull(SUM(D.IssuedTickets),0)) as decimal(18,4)) * 100 as decimal(18,2)))) as SLA\r\n"
					+ "					,CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgServiceTime\r\n"
					+ "				  ,	case SUM(D.ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketServedWithInST)) / CONVERT(DECIMAL(18,2), isnull(SUM(ServedTickets),0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end as ServiceSLAPercentage\r\n"
					+ "					,SUM(D.NoShowTickets) as NoShowTickets,\r\n"
					+ "					case SUM(D.NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.NoShowTickets)) / CONVERT(DECIMAL(18,2), isnull(SUM(IssuedTickets), 0)) as decimal(18,4)) * 100 as decimal(18,2))), 2) end as PercentageNoShowTickets\r\n"
					+ "					from eqreport..DashboardBranchCategoryStatus D where BranchID=231 and CategoryID = 'EMO'\r\n"
					+ "					group by ServedTickets,IssuedTickets"
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
		return hourlyrecord;

	}



}


