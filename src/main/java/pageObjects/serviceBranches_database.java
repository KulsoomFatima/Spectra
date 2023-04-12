package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class serviceBranches_database {

	public String branchestable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String branchestable() throws SQLException {

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
					+ "\r\n"
					+ "select BranchName, IssuedTickets,\r\n"
					+ " SUM(D.ServedTickets) Ticketserved#, ((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.ServedTickets)) / CONVERT(DECIMAL(18,2),SUM(D.ServedTickets) ) as decimal(18,4)) * 100 as decimal(18,0))))  as PercentageServedTickets ,\r\n"
					+ " CAST(CONVERT(varchar, DATEADD(ss, case SUM(cast(ServedTickets as bigint)) + SUM(cast(NoShowTickets as bigint)) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(cast(TotalWaitTime as bigint))) / CONVERT(DECIMAL(18,2),SUM(cast(ServedTickets as bigint)) + SUM(cast(NoShowTickets as bigint))) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgWaitTime,\r\n"
					+ "			\r\n"
					+ "			case SUM(IssuedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(cast(TicketCalledWithInWT as bigint))) / CONVERT(DECIMAL(18,2), isnull(SUM(cast(IssuedTickets as bigint)),0)) as decimal(18,4)) * 100 as decimal(18,0))), 0) end as WaitingSLAPercentage,\r\n"
					+ "			isnull(SUM(cast(TicketCalledWithinWT as bigint)),0) as WaitingSLACount,\r\n"
					+ "			\r\n"
					+ "CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgServiceTime,\r\n"
					+ "case SUM(D.ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketServedWithInST)) / CONVERT(DECIMAL(18,2), isnull(SUM(ServedTickets),0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end as ServiceSLAPercentage,\r\n"
					+ "		isnull(SUM(D.TicketServedWithInST),0) as ServiceSLACount\r\n"
					+ "from eqreport..DashboardBranchCategoryStatus D \r\n"
					+ "		left join eqportal..eQPortal_StaticTranslation St WITH(NOLOCK) on REPLACE(D.CategoryName,' ','')=St.[Key] \r\n"
					+ "			where BranchID=231 and CategoryID = 'EMO'\r\n"
					+ "group by BranchName, D.IssuedTickets, D.ServedTickets, AvgWaitTime, St.Value ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				String Branch = resultSet.getString(1);
				System.out.println("Branch: " +Branch);

				String issueticket = resultSet.getString(2);
				System.out.println("issueticket: " +issueticket);
				
				String ticketserved = resultSet.getString(3);
				System.out.println("ticket Served: " +ticketserved);
				
				String Pticketserved = resultSet.getString(4);
				System.out.println("ticket Served %: " +Pticketserved);
				
				String AvgWaitTime = resultSet.getString(5);
				System.out.println("Wait Time Avg: " +AvgWaitTime);
				
				String WaitingSLAPercentage = resultSet.getString(6);
				System.out.println("Waiting SLA %: " +WaitingSLAPercentage);
				
				String slacount = resultSet.getString(7);
				System.out.println("slacount: " +slacount);
				
				String waitSLA = resultSet.getString(8);
				System.out.println("AvgServiceTime: " +waitSLA);
				
				String slaper = resultSet.getString(9);
				System.out.println("slaper: " +slaper);

				String servicesla = resultSet.getString(10);
				System.out.println("servicesla: " +servicesla);
				
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branchestable;

	}
	
	
	

	@Test
	public String branchrecord() throws SQLException {

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
			resultSet = statement.executeQuery("----- summary \r\n"
					+ "select  ServedTickets, IssuedTickets ,(cast((cast (ServedTickets as decimal(18,0) )/IssuedTickets)as decimal(18,2)) * 100) servedissue\r\n"
					+ ",CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) + SUM(NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalWaitTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets) + SUM(NoShowTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgWaitTime\r\n"
					+ ",CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgServiceTime\r\n"
					+ ",	case SUM(D.ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.TicketServedWithInST)) / CONVERT(DECIMAL(18,2), isnull(SUM(ServedTickets),0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end as ServiceSLAPercentage\r\n"
					+ ",SUM(D.NoShowTickets) as NoShowTickets,\r\n"
					+ "case SUM(D.NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.NoShowTickets)) / CONVERT(DECIMAL(18,2), isnull(SUM(IssuedTickets), 0)) as decimal(18,4)) * 100 as decimal(18,0))), 2) end as PercentageNoShowTickets\r\n"
					+ "from eqreport..DashboardBranchCategoryStatus D where BranchID=231 and CategoryID = 'EMO'\r\n"
					+ "group by ServedTickets,IssuedTickets");

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


