package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.testng.annotations.Test;

public class TellerActivity_database {

	public String tellersummarytable;
	public String ticket_transferred;
	public String summaryrecord;
	public String ticket_serve;
	

	@Test
	public String tellerdailytable() throws SQLException {

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
			resultSet = statement.executeQuery("declare @offlineLabel nvarchar(100), \r\n"
					+ "@isRealTime varchar(1) = 'R',\r\n"
					+ "@language varchar(10)='',\r\n"
					+ "@languageText nvarchar(max) = ''\r\n"
					+ "select \r\n"
					+ "@offlineLabel = [Value] from eqportal..eQPortal_StaticTranslation St3 \r\n"
					+ "where [Key]='Offline' and LanguageName=@languageText\r\n"
					+ " \r\n"
					+ "select top 1 @languageText = CSS + '@' + L.LanguageName from eqportal..eqportal_language L\r\n"
					+ "where L.Code = @language\r\n"
					+ "		\r\n"
					+ "select distinct\r\n"
					+ "o.BranchName, \r\n"
					+ "OperatorName as teller,\r\n"
					+ "o.OperatorID as id,\r\n"
					+ "case t2.isADUser when 0 then '-' else t2.UserID end as [ActiveDirectory], \r\n"
					+ "LEFT(CONVERT(VARCHAR,  o.CurrentDate , 103), 10) [Date],\r\n"
					+ "case @isRealTime when  'R' then (IsNull(OperatorStatus,@offlineLabel)) else @offlineLabel end as Status,\r\n"
					+ "case @isRealTime when  'R' then case C.CounterID when 0 then '-' else 'Counter ' + convert(varchar(10),C.CounterID) end else 'Counter ' + convert(varchar(10),C.CounterID)  end as CounterID,\r\n"
					+ "ISNULL(CONVERT(VARCHAR, C.OpenTime, 108), '-')  [StartTime],\r\n"
					+ "ISNULL(CONVERT(VARCHAR, c.CloseTime, 108), '-')  [EndTime],\r\n"
					+ "CONVERT(varchar, DATEADD(s, isnull(SUM(DATEDIFF(ss,c.OpenTime, c.CloseTime)),0), 0), 108) as EnlapsedTime,\r\n"
					+ "AL.Name,\r\n"
					+ "ISNULL(CONVERT(varchar, AL.StartTime, 108), '-') as ActivityStartTime,\r\n"
					+ "ISNULL(CONVERT(varchar, AL.EndTime, 108), '-') as ActivityEndTime\r\n"
					+ "from  eqreport_Archival..DashboardBranchOperatorStatus o\r\n"
					+ "inner join eqreport_Archival..PSRCounter c on c.BranchId = o.BranchID and c.OperatorId = o.OperatorID\r\n"
					+ "left join eqreport_Archival..PSRActivityLog AL on AL.CounterEventId = C.CounterEventId\r\n"
					+ "inner JOIN eqPortal..eQPortal_Operator t2 with(nolock) ON (o.OperatorID = t2.OperatorId AND o.BranchID = t2.BranchId)  \r\n"
					+ "where o.BranchID=232 \r\n"
					+ "group by o.BranchName,OperatorName, TicketServed, IdlePercentage, o.ProcessingTime,TotalLoginTime,OpenTime,CloseTime,c.OperatorId,c.BranchId,o.CurrentDate,o.OperatorID,AL.Name,OperatorStatus,c.CounterId, t2.UserID,t2.isADUser,  AL.StartTime,  AL.EndTime\r\n"
					+ "order by o.OperatorID asc\r\n"
					+ "");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			
				System.out.println("");
				System.out.println(resultSet.getString(1) + "  "
						+ resultSet.getString(2)+ "  "+ resultSet.getString(3) + "  "+ resultSet.getString(4)  +"  "+ 
						 resultSet.getString(5)+ "  "+ resultSet.getString(6) + "  "+ resultSet.getString(7)  + "  "+
						 resultSet.getString(8)+ "  "+ resultSet.getString(9) + "  "+ resultSet.getString(10)  + "  "+
						 resultSet.getString(11)+ "  "+ resultSet.getString(12)+ "  "+
						 resultSet.getString(13));
		
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tellersummarytable;

	}
	
	
	

}


