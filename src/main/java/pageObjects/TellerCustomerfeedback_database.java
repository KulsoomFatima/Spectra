package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class TellerCustomerfeedback_database {

	public String tellersummarytable;
	public String tellercustomersummary;

	

	@Test
	public String tellercustomertable() throws SQLException {

		System.out.println("Record from database teller daily table: ");

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
					+ "b.BranchCode,\r\n"
					+ "s.BranchName, \r\n"
					+ "s.RegionName,\r\n"
					+ "s.CategoryName as ServiceType, \r\n"
					+ "TicketNumber, \r\n"
					+ "CONVERT(VARCHAR,CAST(IssueTime AS DATE), 101)TransactionDate,\r\n"
					+ "CONVERT(VARCHAR,CAST(IssueTime AS TIME), 120) TransactionTime, \r\n"
					+ "CONVERT(varchar, DATEADD(ms, isnull(CalcServiceTime,0) * 1000, 0), 108) as TransactionServingTime, \r\n"
					+ "CONVERT(varchar, DATEADD(ms, isnull(CalcWaitTime,0) * 1000, 0), 108) as TransactionWaitingTime,\r\n"
					+ "CONVERT(VARCHAR, CAST(ServiceEndTime AS TIME), 120) TransactionEndTime,\r\n"
					+ "ps.description as TicketStatus ,\r\n"
					+ "p.CounterId as TerminalID, \r\n"
					+ "p.OperatorId as TellerID,\r\n"
					+ "isnull(s.OperatorName,'-') as TellerName \r\n"
					+ "from  eqreport_archival..PSRTicket p\r\n"
					+ "left join eqreport_Archival..DashboardBranchOperatorCategoryStatus s on s.BranchID = p.BranchId and s.OperatorID = p.OperatorId and s.CategoryID = p.CategoryID \r\n"
					+ "inner join eqreport_Archival..PSRState ps on ps.StateId = p.StateId \r\n"
					+ "inner join eqreport_Archival..DFLTBranches b on b.BranchID = p.BranchId\r\n"
					+ "where p.BranchId= 232 ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			

				System.out.println("");
				System.out.println(resultSet.getString(1) + "  "
						+ resultSet.getString(2)+ "  "+ resultSet.getString(3) + "  "+ resultSet.getString(4)  +"  "+ 
						 resultSet.getString(5)+ "  "+ resultSet.getString(6) + "  "+ resultSet.getString(7)  + "  "+
						 resultSet.getString(8)+ "  "+ resultSet.getString(9) + "  "+ resultSet.getString(10)  + "  "+
						 resultSet.getString(11)+ "  "+ resultSet.getString(12)+ "  "+
						 resultSet.getString(13)+ "  "+ resultSet.getString(14));
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tellersummarytable;

	}
	
	@Test
	public String tellercustomersummary() throws SQLException {

		System.out.println("Record from database teller customer summary: ");

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
			resultSet = statement.executeQuery("	select CAST(SUM(TicketIssued) AS VARCHAR) + '/' + CAST(SUM(TicketServed) AS VARCHAR) AS [Ticket Issued/Served], \r\n"
					+ "	'Avg ' + CAST(CONVERT(varchar, DATEADD(ss, case SUM(TicketServed) + SUM(TicketsNoShow) when 0 then 0 else (cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalWaitTime)) / CONVERT(DECIMAL(18,2),SUM(TicketServed) + SUM(TicketsNoShow)) as decimal(18,2)) as decimal(18,2))) end, 0), 108) AS VARCHAR) [Avg. Waiting Time],\r\n"
					+ "	'Avg ' + CAST(CONVERT(varchar, DATEADD(ss, case SUM(TicketServed) when 0 then 0 else (cast(cast(CONVERT(DECIMAL(18,2), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,2),SUM(TicketServed)) as decimal(18,2)) as decimal(18,2))) end, 0), 108) AS VARCHAR) [Avg. Service Time]\r\n"
					+ "	from eqreport_archival..DashboardRegionBranchDashBoard  where BranchId= 232");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				String TicketIssued_Served = resultSet.getString(1);
				System.out.println("Ticket Issued/Served: " +TicketIssued_Served);
				
				String AvgWaitingTime = resultSet.getString(2);
				System.out.println("Avg Waiting Time: " +AvgWaitingTime);
				
				String AvgServiceTime = resultSet.getString(3);
				System.out.println("Avg. Service Time: " +AvgServiceTime);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tellercustomersummary;

	}
	
	
	

	

}


