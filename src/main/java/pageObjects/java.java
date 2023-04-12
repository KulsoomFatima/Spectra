package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class java {

	public int counters() {
	int Ticket_Served_counter_final = 0  ; 
	

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
		resultSet = statement.executeQuery("declare \r\n" + "@branchdate datetime, \r\n"
				+ "@startdate datetime, \r\n" + "@ticket_issuet int,  \r\n" + "@ticket_served int, \r\n"
				+ "@OpenTime datetime, \r\n" + "@Closetime datetime, \r\n" + "@CounterId int,\r\n"
				+ "@branchid int = 80\r\n"
				+ "select @branchdate = eqreport.dbo.[Fnc_GetBranchDateTime](@branchid)\r\n" + "\r\n"
				+ "select \r\n" + "db.TicketIssued TotalIssuedTickets,\r\n"
				+ "db.TicketServed TotalServedTickets,\r\n"
				+ "(cast((sUM(DATEDIFF (MINUTE, cast(OpenTime as time), cast(CloseTime as time)))/60.0) "
				+ "as decimal(5,2))) AS TotalLoginTime,\r\n"
				+ "drbc.TotalCounter,\r\n"
				+ "DATEDIFF (HOUR, cast(STARTTIME as time), cast(@branchdate as time)) AS branchworkinghrtillnow\r\n"
				+ "from eqreport.dbo.DFLTBranchShift df\r\n"
				+ "inner join eqreport.dbo.DashboardBranchChart db on db.BranchID = df.BRANCHID\r\n"
				+ "inner join eqreport.dbo.PSRCounter psr on psr.BranchID = df.BRANCHID \r\n"
				+ "inner join eqreport.dbo.DashboardRegionBranchDashBoard drbc on drbc.BranchID = db.BranchID\r\n"
				+ "where db.BranchID = @branchid and db.TicketIssued != 0 and psr.CloseTime is not null\r\n"
				+ "group by STARTTIME, TotalCounter, db.TicketIssued, db.TicketServed");

		// branch working hour till now
		while (resultSet.next()) {
			String branchworkinghrtillnow = resultSet.getString(5);
			Double i = Double.parseDouble(branchworkinghrtillnow);
			System.out.println("branchworkinghrtillnow : i" + i);
			// Ticket_Served_counter_final = i ;

			// sum of logged in time counter
			String loggedintime = resultSet.getString(3);
			Double j = Double.parseDouble(loggedintime);

			System.out.println(j);

			// count of total counter
			String Totalcounter = resultSet.getString(4);
			Double k = Double.parseDouble(Totalcounter);
			System.out.println("Totalcounter : k"+ k);

			// TICKET(S) ISSUED PER HOUR
			String Totalticket_issued = resultSet.getString(1);
			Double t = Double.parseDouble(Totalticket_issued);
			System.out.println("Total ticket: " + Totalticket_issued);
			Double Ticket_issue_per_hour_Cal = (t / i);
			DecimalFormat df = new DecimalFormat("#.##");
			Ticket_issue_per_hour_Cal = Double.valueOf(df.format(Ticket_issue_per_hour_Cal));
			System.out.println("Ticket issued per hour Cal  " + Ticket_issue_per_hour_Cal);

			// TICKET(S) SERVED PER HOUR
			String Totalticket_served = resultSet.getString(2);
			Double h = Double.parseDouble(Totalticket_served);
			System.out.println("Total ticket: " + Totalticket_served);
			Double Ticket_served_per_hour_Cal = (h / i);
			System.out.println(Ticket_served_per_hour_Cal);
			DecimalFormat df1 = new DecimalFormat("#.##");
			Ticket_served_per_hour_Cal = Double.valueOf(df1.format(Ticket_served_per_hour_Cal));
			System.out.println("Ticket served per hour Cal  " + Ticket_served_per_hour_Cal);

			// for %
			// For % = (sum of logged in time of counters/branch working hours up till now *
			// count of total counters) * 100

			System.out.println("j" + j);
			Double Guageper = (j) / (i * k) * 100;
			@SuppressWarnings("removal")
			Double newData = new Double(Guageper);

			// convert into int
			int value = newData.intValue();
			System.out.println("Complaince % from db= " + value + "%");
			Ticket_Served_counter_final = value;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Ticket_Served_counter_final;

}

}
