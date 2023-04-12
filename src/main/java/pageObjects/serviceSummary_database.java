package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class serviceSummary_database {

	public String summarytable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String summarytable() throws SQLException {

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
			resultSet = statement.executeQuery("select CategoryName as Category\r\n"
					+ "\r\n"
					+ ", SUM(D.IssuedTickets) ticketIssue#, ((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.IssuedTickets)) / CONVERT(DECIMAL(18,2), SUM(IssuedTickets)) as decimal(18,4)) * 100 as decimal(18,0)))) as TicketsIssuedP,\r\n"
					+ "\r\n"
					+ "--- PercentageServedTickets\r\n"
					+ " SUM(D.ServedTickets) Ticketserved#, ((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.ServedTickets)) / CONVERT(DECIMAL(18,2),SUM(D.ServedTickets) ) as decimal(18,4)) * 100 as decimal(18,0))))  as PercentageServedTickets \r\n"
					+ "\r\n"
					+ "---AvgWaitTime --- WaitingSLACount -- WaitingSLAPercentage\r\n"
					+ ",CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) + SUM(NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalWaitTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets) + SUM(NoShowTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgWaitTime\r\n"
					+ ",(SUM(D.TicketCalledWithInWT)) as WaitingSLACount\r\n"
					+ "\r\n"
					+ ",((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketCalledWithInWT)) / CONVERT(DECIMAL(18,2), isnull(SUM(D.IssuedTickets),0)) as decimal(18,4)) * 100 as decimal(18,0)))) as WaitingSLAPercentage\r\n"
					+ "\r\n"
					+ "\r\n"
					+ ",CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgServiceTime,\r\n"
					+ "		isnull(SUM(D.TicketServedWithInST),0) as ServiceSLACount,\r\n"
					+ "		case SUM(D.ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketServedWithInST)) / CONVERT(DECIMAL(18,2), isnull(SUM(ServedTickets),0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end as ServiceSLAPercentage,\r\n"
					+ "		SUM(D.NoShowTickets) as NoShowTickets,\r\n"
					+ "		case SUM(D.NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.NoShowTickets)) / CONVERT(DECIMAL(18,2), isnull(SUM(IssuedTickets), 0)) as decimal(18,4)) * 100 as decimal(18,0))), 0) end as PercentageNoShowTickets,\r\n"
					+ "	    SUM(D.IssuedTickets) - SUM(D.ServedTickets) - SUM(D.NoShowTickets) as UnqualifiedTickets, \r\n"
					+ "		isnull(CONVERT(varchar, DATEADD(ss, sum(D.ProcessingTime), 0), 108), '-') ProcessingTime\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "from eqreport..DashboardBranchCategoryStatus D \r\n"
					+ "		left join eqportal..eQPortal_StaticTranslation St WITH(NOLOCK)\r\n"
					+ "								on REPLACE(D.CategoryName,' ','')=St.[Key] \r\n"
					+ "			where BranchID=80 and CategoryID = 'EMO'\r\n"
					+ "\r\n"
					+ "group by CategoryName, D.IssuedTickets, D.ServedTickets, AvgWaitTime, St.Value \r\n"
					+ "");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				String Category = resultSet.getString(1);
				System.out.println("Category: " +Category);
				
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
				
				String WaitingSLACount = resultSet.getString(7);
				System.out.println("Waiting SLA Count: " +WaitingSLACount);
				
				String WaitingSLAPercentage = resultSet.getString(8);
				System.out.println("Waiting SLA %: " +WaitingSLAPercentage);
				
				String AvgServiceTime = resultSet.getString(9);
				System.out.println("AvgServiceTime: " +AvgServiceTime);
				
				String ServiceSLACount = resultSet.getString(10);
				System.out.println("ServiceSLACount: " +ServiceSLACount);
				
				String ServiceSLAPercentage = resultSet.getString(11);
				System.out.println("ServiceSLAPercentage: " +ServiceSLAPercentage);
				
				String NoShowTickets = resultSet.getString(12);
				System.out.println("NoShowTickets: " +NoShowTickets);
				
				String PercentageNoShowTickets = resultSet.getString(13);
				System.out.println("Percentage No Show Tickets: " +PercentageNoShowTickets);
				
				String UnqualifiedTickets = resultSet.getString(14);
				System.out.println("UnqualifiedTickets: " +UnqualifiedTickets);
				
				String ProcessingTime = resultSet.getString(15);
				System.out.println("Processing Time: " +ProcessingTime);
				
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summarytable;

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


