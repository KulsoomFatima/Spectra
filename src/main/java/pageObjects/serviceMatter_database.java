package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class serviceMatter_database {

	public String mattercodetable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String mattercodetable() throws SQLException {

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
			resultSet = statement.executeQuery("declare  @TotalNoShowTickets int=0;\r\n"
					+ "	declare @TotalWaitingTickets varchar(255)=0;\r\n"
					+ "\r\n"
					+ "	select \r\n"
					+ "		 @TotalNoShowTickets = SUM(NoShowTickets) \r\n"
					+ "	from  eqreport..DashboardBranchCategoryStatus  DBCS \r\n"
					+ "\r\n"
					+ "  select  CategoryName,\r\n"
					+ "			Convert(varchar, DATEADD(s,(Convert(decimal(18,2),AvgWaitTime)), 0),108) as AvgWaitTime,\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "		isnull(SUM(TicketCalledWithInWT),0) as WaitingSLACount,\r\n"
					+ "		Convert(nvarchar(max),case (SUM(IssuedTickets)) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,4), SUM(TicketCalledWithInWT)) / CONVERT(DECIMAL(18,4), SUM(IssuedTickets)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end) as WaitingSLAPercentage,\r\n"
					+ "		case SUM(TotalTransactions) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,4), SUM(TotalServiceTime)) / CONVERT(DECIMAL(18,4),SUM(TotalTransactions)) as decimal(18,4)) as decimal(18,2))), 0) end as AvgServiceTime,\r\n"
					+ "		isnull(SUM(TransactionWithinST),0) as ServiceSLACount,\r\n"
					+ "		Convert(nvarchar(max),case SUM(TotalTransactions) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,4), SUM(TransactionWithinST)) / CONVERT(DECIMAL(18,4), isnull(SUM(TotalTransactions),0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end) as ServiceSLAPercentage,\r\n"
					+ "		SUM(NoShowTickets) as NoShowTickets,\r\n"
					+ "		Convert(nvarchar(max),case @TotalNoShowTickets when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(18,4), SUM(NoShowTickets)) / CONVERT(DECIMAL(18,4), isnull(@TotalNoShowTickets, 0)) as decimal(18,4)) * 100 as decimal(18,2))), 0) end) as PercentageNoShowTickets,\r\n"
					+ "		isnull(CONVERT(varchar, DATEADD(ss, sum(ProcessingTime), 0), 108), '-') ProcessingTime\r\n"
					+ "		from  eqreport..DashboardBranchCategoryStatus  DBCS \r\n"
					+ "		 where BranchID=229\r\n"
					+ "			 GROUP BY DBCS.CategoryID, CategoryName , AvgWaitTime");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				System.out.println("");
				System.out.println(resultSet.getString(1) + "  "
						+ resultSet.getString(2)+ "  "+ resultSet.getString(3) + "  "+ resultSet.getString(4)  +"  "+ 
						 resultSet.getString(5)+ "  "+ resultSet.getString(6) + "  "+ resultSet.getString(7)  + "  "+
						 resultSet.getString(8)+ "  "+ resultSet.getString(9) + "  "+ resultSet.getString(10));
				
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mattercodetable;

	}
	
	
}


