package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class TellerCategory_database {

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
			resultSet = statement.executeQuery("select *\r\n"
					+ "into #DashboardBranchOperatorCategoryStatus \r\n"
					+ "from eqreport_Archival..DashboardBranchOperatorCategoryStatus b with(nolock) where b.BranchID= 232  and b.CurrentDate='2023-03-15 00:00:00.000'\r\n"
					+ "\r\n"
					+ "declare @TotalServedTickets int = 0;\r\n"
					+ "select @TotalServedTickets = SUM(ServedTickets) from #DashboardBranchOperatorCategoryStatus\r\n"
					+ "\r\n"
					+ "select distinct \r\n"
					+ "b.BranchName as branch, \r\n"
					+ "b.OperatorName as Teller,\r\n"
					+ "CategoryName, \r\n"
					+ "ServedTickets as TicketsServed,\r\n"
					+ "case (b.ServedTickets) \r\n"
					+ "	when 0 then 0 \r\n"
					+ "	else cast((cast((b.ServedTickets * 100) as DECIMAL(10,4)) / @TotalServedTickets) as DECIMAL(10,2)) \r\n"
					+ "end as TicketsServedPercent,\r\n"
					+ "case SUM(b.ServedTickets) \r\n"
					+ "	when 0 then '00:00:00' \r\n"
					+ "	else CONVERT(varchar, DATEADD(s, isnull(SUM(b.TotalServiceTime)/CAST(sum(b.servedtickets) AS DECIMAL(10,2)),0), 0), 108) \r\n"
					+ "end as AvgServiceTime,\r\n"
					+ "case SUM(b.ServedTickets) \r\n"
					+ "	when 0 then 0 \r\n"
					+ "	else isnull(cast ( (cast( sum(TicketServedWithinST) as DECIMAL(10,2))/sum(b.servedtickets)) * 100  as  DECIMAL(10,2)),0) \r\n"
					+ "end as SLAService, \r\n"
					+ "b.ProcessingTime\r\n"
					+ "from #DashboardBranchOperatorCategoryStatus b \r\n"
					+ "where b.BranchID= 232  and b.CurrentDate='2023-03-15 00:00:00.000'\r\n"
					+ "group by b.BranchName,b.CategoryName,b.ServedTickets,b.OperatorName, b.ProcessingTime\r\n"
					+ "order by b.OperatorName asc\r\n"
					+ "\r\n"
					+ "drop table #DashboardBranchOperatorCategoryStatus");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			

				System.out.println("");
				System.out.println(resultSet.getString(1) + "  "
						+ resultSet.getString(2)+ "  "+ resultSet.getString(3) + "  "+ resultSet.getString(4)  +"  "+ 
						 resultSet.getString(5)+ "  "+ resultSet.getString(6) + "  "+ resultSet.getString(7)  + "  "+
						 resultSet.getString(8));
		
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


