package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class serviceQuality_database {

	public String qualitytable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String qualitytable() throws SQLException {

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
			resultSet = statement.executeQuery("select CategoryName as Category,\r\n"
					+ " SUM(D.ServedTickets) Ticketserved#, ((cast(cast(CONVERT(DECIMAL(18,2), SUM(D.ServedTickets)) / CONVERT(DECIMAL(18,2),SUM(D.ServedTickets) ) as decimal(18,4)) * 100 as decimal(18,0))))  as PercentageServedTickets ,\r\n"
					+ " CAST(CONVERT(varchar, DATEADD(ss, case SUM(cast(ServedTickets as bigint)) + SUM(cast(NoShowTickets as bigint)) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(cast(TotalWaitTime as bigint))) / CONVERT(DECIMAL(18,2),SUM(cast(ServedTickets as bigint)) + SUM(cast(NoShowTickets as bigint))) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgWaitTime,\r\n"
					+ "			CONVERT(varchar, DATEADD(ms, isnull(MAX(MaxWaitTime),0) * 1000, 0), 108) as MaxWaitTime,\r\n"
					+ "			isnull(SUM(cast(TicketCalledWithinWT as bigint)),0) as WaitingSLACount,\r\n"
					+ "			case SUM(IssuedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(cast(TicketCalledWithInWT as bigint))) / CONVERT(DECIMAL(18,2), isnull(SUM(cast(IssuedTickets as bigint)),0)) as decimal(18,4)) * 100 as decimal(18,0))), 0) end as WaitingSLAPercentage,\r\n"
					+ "		isnull(CONVERT(varchar, DATEADD(ss, sum(D.ProcessingTime), 0), 108), '-') ProcessingTime\r\n"
					+ "from eqreport..DashboardBranchCategoryStatus D \r\n"
					+ "		left join eqportal..eQPortal_StaticTranslation St WITH(NOLOCK) on REPLACE(D.CategoryName,' ','')=St.[Key] \r\n"
					+ "			where BranchID=231 and CategoryID = 'EMO'\r\n"
					+ "group by CategoryName, D.IssuedTickets, D.ServedTickets, AvgWaitTime, St.Value ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				String Category = resultSet.getString(1);
				System.out.println("Category: " +Category);

				String ticketserved = resultSet.getString(2);
				System.out.println("ticket Served: " +ticketserved);
				
				String PercentageServedTickets = resultSet.getString(3);
				System.out.println("Served Tickets %: " +PercentageServedTickets);
				
				String AvgWaitTime = resultSet.getString(4);
				System.out.println("Wait Time Avg: " +AvgWaitTime);
				
				String Maxwaittime = resultSet.getString(5);
				System.out.println("Maxwaittime: " +Maxwaittime);
				
				String waitSLA = resultSet.getString(6);
				System.out.println("AvgServiceTime: " +waitSLA);
				
				String WaitingSLAPercentage = resultSet.getString(7);
				System.out.println("Waiting SLA %: " +WaitingSLAPercentage);
				
				String ProcessingTime = resultSet.getString(8);
				System.out.println("Processing Time: " +ProcessingTime);
				
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qualitytable;

	}
	
	
	

	@Test
	public String qualityrecord() throws SQLException {

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
					+ ",CAST(CONVERT(varchar, DATEADD(ss, case SUM(ServedTickets) + SUM(NoShowTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalWaitTime)) / CONVERT(DECIMAL(18,2),SUM(ServedTickets) + SUM(NoShowTickets)) as decimal(18,2)) as decimal(18,2))), 0) end, 0), 108) AS VARCHAR) as AvgWaitTime,\r\n"
					+ "			CONVERT(varchar, DATEADD(ms, isnull(MAX(MaxWaitTime),0) * 1000, 0), 108) as MaxWaitTime,\r\n"
					+ "				case SUM(IssuedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,2), SUM(cast(TicketCalledWithInWT as bigint))) / CONVERT(DECIMAL(18,2), isnull(SUM(cast(IssuedTickets as bigint)),0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end as WaitingSLAPercentage,\r\n"
					+ "							isnull(SUM(cast(TicketCalledWithinWT as bigint)),0) as WaitingSLACount\r\n"
					+ "from eqreport..DashboardBranchCategoryStatus D where BranchID=231 and CategoryID = 'EMO'\r\n"
					+ "group by ServedTickets,IssuedTickets\r\n"
					+ "			");

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
				
				String Max = resultSet.getString(5);
				System.out.println("Max: " +Max);
				

				String SLA = resultSet.getString(6);
				System.out.println("SLA: " +SLA);
				
				String count = resultSet.getString(7);
				System.out.println("Count: " +count);
				
				System.out.println("---------------------------------");
				System.out.println("");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summaryrecord;

	}



}


