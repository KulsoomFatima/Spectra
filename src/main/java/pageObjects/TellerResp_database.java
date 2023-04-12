package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class TellerResp_database {

	public String tellersummarytable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String tellerresptable() throws SQLException {

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
					+ "\r\n"
					+ "AL.Name,\r\n"
					+ "\r\n"
					+ "LEFT(CONVERT(VARCHAR,  o.CurrentDate , 103), 10) [Date],   \r\n"
					+ "IssuedTickets, \r\n"
					+ "  isnull(IssuedTicketsPercentage,0) as IssuedTicketsPercentage, \r\n"
					+ "  CONVERT(varchar, DATEADD(s, isnull(TotalBackendTime,0), 0), 108) BackOfficeTime,\r\n"
					+ "\r\n"
					+ "cast(isnull(CASE WHEN SUM(TotalLoginTime) > 0 THEN (cast(SUM(TotalBackendTime) as decimal(18,2))/SUM(TotalLoginTime))*100 ELSE 0 END,0.00) as decimal(18,2)) BackOfficetimePercentage, \r\n"
					+ "cast(isnull(CASE WHEN SUM(TotalLoginTime) > 0 THEN (cast(SUM(TotalIdleTime) as decimal(18,2))/SUM(TotalLoginTime))*100 ELSE 0 END,0.00) as decimal(18,2)) IdlePercentage\r\n"
					+ ",c.CounterId\r\n"
					+ ", ISNULL(CONVERT(VARCHAR, AL.StartTime, 108), '-')  [StartTime],\r\n"
					+ "ISNULL(CONVERT(VARCHAR, AL.EndTime, 108), '-')  [EndTime]\r\n"
					+ "from  eqreport_Archival..DashboardBranchOperatorStatus o\r\n"
					+ "inner join eqreport_Archival..PSRCounter c on c.BranchId = o.BranchID and c.OperatorId = o.OperatorID\r\n"
					+ "left join eqreport_Archival..PSRActivityLog AL on AL.CounterEventId = c.CounterEventId\r\n"
					+ "\r\n"
					+ " where o.BranchID=232 \r\n"
					+ " group by o.BranchName,OperatorName, TicketServed, IdlePercentage ,o.CounterId,IssuedTicketsPercentage, TotalBackendTime,\r\n"
					+ " o.ProcessingTime,TotalLoginTime,OpenTime,CloseTime,c.OperatorId,c.BranchId,o.CurrentDate, IssuedTickets,[StartTime], EndTime,c.CounterId,AL.Name");

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


