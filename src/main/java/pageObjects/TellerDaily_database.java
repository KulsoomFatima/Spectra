package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class TellerDaily_database {

	public String tellersummarytable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String tellerdailytable() throws SQLException {

		System.out.println("Record from database teller daily: ");

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
					+ " case o.TicketServed when 0 then 0 else \r\n"
					+ "				 isnull(cast (cast( (sum(ticketServedWS)) as DECIMAL(18,2)) * 100 \r\n"
					+ "								/(select sum(ticketServed)) as  DECIMAL(18,2)),0) end as SLA,  \r\n"
					+ "eqreport.dbo.getTotalTimeFromSecs((TotalLoginTime), '') LoggedTime,	\r\n"
					+ "	CONVERT(varchar, DATEADD(s, isnull(TotalServingTime,0), 0), 108) ServiceTime,\r\n"
					+ "				CONVERT(varchar, DATEADD(s, isnull(TotalBackendTime,0), 0), 108) BackOfficeTime,\r\n"
					+ "				CONVERT(varchar, DATEADD(s, isnull(TotalIdleTime,0), 0), 108) IdleTime,\r\n"
					+ "IssuedTickets,\r\n"
					+ "isnull(CONVERT(varchar, DATEADD(ss, sum(o.ProcessingTime), 0), 108), '-') ProcessingTime\r\n"
					+ "\r\n"
					+ "from  eqreport_Archival..DashboardBranchOperatorStatus o\r\n"
					+ "inner join eqreport_Archival..PSRCounter c on c.BranchId = o.BranchID and c.OperatorId = o.OperatorID\r\n"
					+ " where o.BranchID=232 \r\n"
					+ " group by o.BranchName,OperatorName, TicketServed, IdlePercentage, TotalServingTime, TotalBackendTime,TotalIdleTime\r\n"
					+ " ,TotalIdleTime,o.ProcessingTime,TotalLoginTime,OpenTime,CloseTime,c.OperatorId,c.BranchId,o.CurrentDate,IssuedTickets");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
				
				System.out.println("");
				System.out.println(resultSet.getString(1) + "  "
						+ resultSet.getString(2)+ "  "+ resultSet.getString(3) + "  "+ resultSet.getString(4)  +"  "+ 
						 resultSet.getString(5)+ "  "+ resultSet.getString(6) + "  "+ resultSet.getString(7)  + "  "+
						 resultSet.getString(8)+ "  "+ resultSet.getString(9) + "  "+ resultSet.getString(10)  + "  "+
						 resultSet.getString(11)+ "  "+ resultSet.getString(12));
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tellersummarytable;

	}
	
	
	

}


