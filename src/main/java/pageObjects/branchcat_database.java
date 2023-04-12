package pageObjects;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

public class branchcat_database {
	public String Tellergroup;
	public HashMap<String, String> Tellerstopandbottomavgservice;
	public String ServedTickets;
	public String avgtime;
	public List<String> catgraph;
	//public String Branchestopandbottom;
	public String latest_Servey;
	public String categorydetail;
	public String branchesinfo_onmap;
	public String Feedback_Evolution_By_Hourly_Distribution;
	public String Target_Compliance_Per_Category;
	public String Average_Time_Per_Category;
	public String Client_waiting_Per_Category;
	public String Service_Rate_Per_Category;
	public String Client_Served_Per_Category;
	public String categories;
	public String realtime_monitoring;
	public String counters;
	

	@SuppressWarnings("resource")
	@Test
	public HashMap<String, String> Tellerstopandbottom_avgservicetime() throws SQLException {

		System.out.println("");
		System.out.println("");

		System.out.println("Record from database of Tellers top and bottom avg service time: ");

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
			resultSet = statement.executeQuery("select operatorname, cast(cast(isnull(SUM(AvgServiceTime),0) as float) / cast(60 as float) as numeric(5,1)) as AvgServiceTime  \r\n"
					+ "		from  eqreport..DashboardBranchOperatorStatus\r\n"
					+ "		where BranchId = 231 and OperatorName ='h1'  --and CurrentDate between '2023-02-22 00:00:00' and '2023-02-28 00:00:00'\r\n"
					+ "		group by AvgServiceTime, OperatorId, operatorname\r\n"
					+ "		order by AvgServiceTime asc\r\n"
					+ "");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String operatorname = resultSet.getString(1);
			//System.out.println("Operator name: " + operatorname);
			
			
			String avgservicetime = resultSet.getString(2);
			//System.out.println("avgservicetime: " + avgservicetime + "min");
			

		    HashMap<String, String> avgtime = new HashMap<String, String>();
		    
		    avgtime.put("● Avg. Service Time:", avgservicetime);
		    
		    avgtime.put("",operatorname);
		 
		    System.out.println("Records from database of Top average service time:");
		    System.out.println(avgtime);
		    
		    Tellerstopandbottomavgservice = avgtime;

		    //bottom service time
		    
		    resultSet = statement.executeQuery("select operatorname, cast(cast(isnull(SUM(AvgServiceTime),0) as float) / cast(60 as float) as numeric(5,1)) as AvgServiceTime  \r\n"
		    		+ "		from  eqreport..DashboardBranchOperatorStatus\r\n"
		    		+ "		where BranchId = 231 and OperatorName ='h1' -- and CurrentDate = '2023-02-27 00:00:00'\r\n"
		    		+ "		group by AvgServiceTime, OperatorId, operatorname\r\n"
		    		+ "		order by AvgServiceTime desc");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String Boperatorname = resultSet.getString(1);
			//System.out.println("Bottom Operator name: " + Boperatorname);
			
			
			String Bavgservicetime = resultSet.getString(2);
			//System.out.println("Bottom avgservicetime: " + Bavgservicetime + "min");
			

		    HashMap<String, String> Bavgtime = new HashMap<String, String>();

		    // Add keys and values (Country, City)
		    
		    Bavgtime.put("● Avg. Service Time:", Bavgservicetime);
		    
		    Bavgtime.put("",Boperatorname);
			System.out.println("");
		    System.out.println("Records from database of bottom average service time:");
		    System.out.println(Bavgtime);

		   
			}
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return Tellerstopandbottomavgservice;

	}

	@SuppressWarnings("resource")
	@Test
	public HashMap<String, String> Tellerstopandbottom_ticketsserved() throws SQLException {

		System.out.println("");
		System.out.println("");

		System.out.println("Record from database of Tellers top and bottom avg service time: ");

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
			// Execute the query.
			System.out.println("Bottom ticket served");

			resultSet = statement.executeQuery("select top 5  OperatorName, \r\n"
					+ "		SUM(TicketServed) TicketServed\r\n"
					+ "		from  eqreport..DashboardBranchOperatorStatus\r\n"
					+ "		where BranchId = 231 and OperatorName ='h1'  --and CurrentDate = '2023-02-27 00:00:00'\r\n"
					+ "		group by TicketServed, OperatorId, OperatorName\r\n"
					+ "		order by TicketServed asc ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String operatorname = resultSet.getString(1);
			//System.out.println("Operator name: " + operatorname);
			
			
			String ticketserved = resultSet.getString(2);
			//System.out.println("avgservicetime: " + avgservicetime + "min");
			

		    HashMap<String, String> bottomticket = new HashMap<String, String>();
		    
		    bottomticket.put("● Avg. Service Time:", ticketserved);
		    
		    bottomticket.put("",operatorname);
		 
		    System.out.println("Records from database of Ticket served:");
		    System.out.println(bottomticket);
		    
		    Tellerstopandbottomavgservice = bottomticket;

		    //top ticket
		    System.out.println("Top ticket served");
		    
		    resultSet = statement.executeQuery("select top 5  OperatorName, \r\n"
		    		+ "		SUM(TicketServed) TicketServed\r\n"
		    		+ "		from  eqreport..DashboardBranchOperatorStatus\r\n"
		    		+ "		where BranchId = 231 and OperatorName ='h1'  --and CurrentDate = '2023-02-27 00:00:00'\r\n"
		    		+ "		group by TicketServed, OperatorId, OperatorName\r\n"
		    		+ "		order by TicketServed desc");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String Toperatorname = resultSet.getString(1);
			//System.out.println("Bottom Operator name: " + Boperatorname);
			
			
			String Tticketserved = resultSet.getString(2);
			//System.out.println("Bottom avgservicetime: " + Bavgservicetime + "min");
			

		    HashMap<String, String> Bavgtime = new HashMap<String, String>();

		    // Add keys and values (Country, City)
		    
		    Bavgtime.put("● Avg. Service Time:", Tticketserved);
		    
		    Bavgtime.put("",Toperatorname);
			System.out.println("");
		    System.out.println("Records from database of top ticket served:");
		    System.out.println(Bavgtime);

		   
			}
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return Tellerstopandbottomavgservice;

	}

	
	@SuppressWarnings("resource")
	@Test
	public HashMap<String, String> BranchestopandbottomSVC() {
		System.out.println("");
		System.out.println("");

		System.out.println("Record from database of Branch top and bottom avg service time: ");

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
			// Execute the query.
			System.out.println("Bottom ticket served");

			resultSet = statement.executeQuery("select top 5 branchName, \r\n"
					+ "			cast(cast(isnull(avg(a.AvgServiceTime),0) as float)/ cast(60 as float) as numeric(5,1)) as AvgServiceTimeInMin \r\n"
					+ "from  eqreport..DashboardRegionBranchDashBoard  a\r\n"
					+ "		where BranchId = 231  --and CurrentDate = '2023-02-27 00:00:00'\r\n"
					+ "group by a.branchId, a.branchName\r\n"
					+ "order by AvgServiceTimeInMin desc ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String operatorname = resultSet.getString(1);
			//System.out.println("Operator name: " + operatorname);
			
			
			String ticketserved = resultSet.getString(2);
			//System.out.println("avgservicetime: " + avgservicetime + "min");
			

		    HashMap<String, String> bottomticket = new HashMap<String, String>();
		    
		    bottomticket.put("● Avg. Service Time:", ticketserved);
		    
		    bottomticket.put("",operatorname);
		 
		    System.out.println("Records from database of Ticket served:");
		    System.out.println(bottomticket);
		    
		    Tellerstopandbottomavgservice = bottomticket;

		    //top ticket
		    System.out.println("Top ticket served");
		    
		    resultSet = statement.executeQuery("select top 5 branchName, \r\n"
		    		+ "			cast(cast(isnull(avg(a.AvgServiceTime),0) as float)/ cast(60 as float) as numeric(5,1)) as AvgServiceTimeInMin \r\n"
		    		+ "from  eqreport..DashboardRegionBranchDashBoard  a\r\n"
		    		+ "		where BranchId = 231  --and CurrentDate = '2023-02-27 00:00:00'\r\n"
		    		+ "group by a.branchId, a.branchName\r\n"
		    		+ "order by AvgServiceTimeInMin ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String Toperatorname = resultSet.getString(1);
			//System.out.println("Bottom Operator name: " + Boperatorname);
			
			
			String Tticketserved = resultSet.getString(2);
			//System.out.println("Bottom avgservicetime: " + Bavgservicetime + "min");
			

		    HashMap<String, String> Bavgtime = new HashMap<String, String>();

		    // Add keys and values (Country, City)
		    
		    Bavgtime.put("● Avg. Service Time:", Tticketserved);
		    
		    Bavgtime.put("",Toperatorname);
			System.out.println("");
		    System.out.println("Records from database of top ticket served:");
		    System.out.println(Bavgtime);

		   
			}
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return Tellerstopandbottomavgservice;

	

	
	}
	
	@SuppressWarnings("resource")
	@Test
	public HashMap<String, String> Branchestopandbottomwaittime() {
		System.out.println("");
		System.out.println("");

		System.out.println("Record from database of Branch top and bottom avg service time: ");

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
			// Execute the query.
			System.out.println("Bottom wait time");

			resultSet = statement.executeQuery("select top 5 branchName, \r\n"
					+ "			(round( cast(cast(isnull(avg(AvgWaitTime),0) as float)/ cast(60 as float) as numeric(5,1)),2)) as AvgWaitTimeInMin \r\n"
					+ "from  eqreport..DashboardRegionBranchDashBoard a\r\n"
					+ "		where BranchId = 231  -- and CurrentDate = '2023-02-27 00:00:00'\r\n"
					+ "		group by a.branchId, a.branchName\r\n"
					+ "        order by AvgWaitTimeInMin desc ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String operatorname = resultSet.getString(1);
			//System.out.println("Operator name: " + operatorname);
			
			
			String ticketserved = resultSet.getString(2);
			//System.out.println("avgservicetime: " + avgservicetime + "min");
			

		    HashMap<String, String> bottomticket = new HashMap<String, String>();
		    
		    bottomticket.put("● Avg. Service Time:", ticketserved);
		    
		    bottomticket.put("",operatorname);
		 
		    System.out.println("Records from database of wait time:");
		    System.out.println(bottomticket);
		    
		    Tellerstopandbottomavgservice = bottomticket;

		    //top ticket
		    System.out.println("Top wait time");
		    
		    resultSet = statement.executeQuery("select top 5 branchName, \r\n"
		    		+ "			(round( cast(cast(isnull(avg(AvgWaitTime),0) as float)/ cast(60 as float) as numeric(5,1)),2)) as AvgWaitTimeInMin \r\n"
		    		+ "from  eqreport..DashboardRegionBranchDashBoard a\r\n"
		    		+ "		where BranchId = 231  -- and CurrentDate = '2023-02-27 00:00:00'\r\n"
		    		+ "		group by a.branchId, a.branchName\r\n"
		    		+ "        order by AvgWaitTimeInMin asc ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String Toperatorname = resultSet.getString(1);
			//System.out.println("Bottom Operator name: " + Boperatorname);
			
			
			String Tticketserved = resultSet.getString(2);
			//System.out.println("Bottom avgservicetime: " + Bavgservicetime + "min");
			

		    HashMap<String, String> Bavgtime = new HashMap<String, String>();

		    // Add keys and values (Country, City)
		    
		    Bavgtime.put("● Avg. Service Time:", Tticketserved);
		    
		    Bavgtime.put("",Toperatorname);
			System.out.println("");
		    System.out.println("Records from database of top wait time:");
		    System.out.println(Bavgtime);

		   
			}
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return Tellerstopandbottomavgservice;

	

	
	}
	
	@SuppressWarnings("resource")
	@Test
	public HashMap<String, String> Branchestopandbottomticketserved() {
		System.out.println("");
		System.out.println("");

		System.out.println("Record from database of Branch top and bottom avg service time: ");

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
			// Execute the query.
			System.out.println("Bottom ticket served");

			resultSet = statement.executeQuery("select top 5 branchName, \r\n"
					+ "			 isnull(sum(a.TicketServed),0) as TicketServed \r\n"
					+ "from  eqreport..DashboardRegionBranchDashBoard  a\r\n"
					+ "		where BranchId = 231  --and CurrentDate = '2023-02-27 00:00:00'\r\n"
					+ "group by a.branchId, a.branchName \r\n"
					+ "order by TicketServed asc ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String operatorname = resultSet.getString(1);
			//System.out.println("Operator name: " + operatorname);
			
			
			String ticketserved = resultSet.getString(2);
			//System.out.println("avgservicetime: " + avgservicetime + "min");
			

		    HashMap<String, String> bottomticket = new HashMap<String, String>();
		    
		    bottomticket.put("● Avg. Service Time:", ticketserved);
		    
		    bottomticket.put("",operatorname);
		 
		    System.out.println("Records from database of Ticket served:");
		    System.out.println(bottomticket);
		    
		    Tellerstopandbottomavgservice = bottomticket;

		    //top ticket
		    System.out.println("Top ticket served");
		    
		    resultSet = statement.executeQuery("select top 5 branchName, \r\n"
		    		+ "			 isnull(sum(a.TicketServed),0) as TicketServed \r\n"
		    		+ "from  eqreport..DashboardRegionBranchDashBoard  a\r\n"
		    		+ "		where BranchId = 231  --and CurrentDate = '2023-02-27 00:00:00'\r\n"
		    		+ "group by a.branchId, a.branchName \r\n"
		    		+ "order by TicketServed desc  ");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String Toperatorname = resultSet.getString(1);
			//System.out.println("Bottom Operator name: " + Boperatorname);
			
			
			String Tticketserved = resultSet.getString(2);
			//System.out.println("Bottom avgservicetime: " + Bavgservicetime + "min");
			

		    HashMap<String, String> Bavgtime = new HashMap<String, String>();

		    // Add keys and values (Country, City)
		    
		    Bavgtime.put("● Avg. Service Time:", Tticketserved);
		    
		    Bavgtime.put("",Toperatorname);
			System.out.println("");
		    System.out.println("Records from database of top ticket served:");
		    System.out.println(Bavgtime);

		   
			}
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return Tellerstopandbottomavgservice;

	

	
	}
	
	
	
	@Test
	public String latestServey() {

		
		System.out.println("SQL Connected to Waiting: ");

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
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-03-13','2023-03-13','APS-Appcitas| BSC-Benefits | ECL-Examenes COVID Latam |EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String latestServey = resultSet.getString(0);
			System.out.println("latest Servey: " + latestServey);
			
			latest_Servey = latestServey;

			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return latest_Servey;

	
	}

	public String category_detail() {
		
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
			resultSet = statement.executeQuery("select ServedTickets, WaitingTickets avgservicetime,(targetservicetime/60) targetservicetime,"
					+ " (TargetWaitTime/60)TargetWaitTime, AvgWaitTime  from eqreport.dbo.DashboardBranchCategoryStatus "
					+ " where BranchId = 231 and CategoryID= 'EMO'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String ServedTickets = resultSet.getString(1);
//			System.out.println("Served Tickets: " + ServedTickets);
			
			
			String avgservicetime = resultSet.getString(2);
			//System.out.println("avgservicetime: " + avgservicetime);
			
			String targetservicetime = resultSet.getString(3);
		//	System.out.println("targetservicetime: " + targetservicetime);
			
			String TargetWaitTime = resultSet.getString(4);
//			System.out.println("TargetWaitTime: " + TargetWaitTime);
			
			String AvgWaitTime = resultSet.getString(5);
//			System.out.println("Avg Wait Time: " + AvgWaitTime);
			
			
			//int i = Integer.parseInt(TicketServedWithinWT);

		    HashMap<String, String> capitalCities = new HashMap<String, String>();

		    // Add keys and values (Country, City)
		    capitalCities.put("avgservicetime", avgservicetime);
		    capitalCities.put("targetservicetime", targetservicetime);
		    capitalCities.put("TargetWaitTime", TargetWaitTime);
		    capitalCities.put("AvgWaitTime", AvgWaitTime);
		    System.out.println(capitalCities);

		    
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return categorydetail;

	}
	
	@Test
	public List<String> catgraph() {

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
			resultSet = statement.executeQuery(" select InHour, TicketIssued, TicketServed, cast((((TicketServed-ServiceTimeException)) / cast(TicketIssued as decimal(5,2)) * 100) as decimal(5,2)) as ticketservedwithtarget_service_time, cast((((TicketIssued - WaitTimeException)) / cast(TicketIssued as decimal(5,2)) *100) as decimal(5,2)) as ticketservedwithtarget_waittime \r\n"
					+ "from eqreport.dbo.DashboardBranchChart \r\n"
					+ "where BranchID = 231 AND TicketIssued != 0   order by  InHour");
			

			System.out.println();  
			System.out.println("---------------------------------------------------------------------------------------------");
			
			while (resultSet.next()) {
				String inhour = resultSet.getString(1);
			System.out.println("In hour: " + inhour);
				
			String ticketissue = resultSet.getString(2);
			System.out.println("ticket issue: " + ticketissue);
			
			String ticketserved = resultSet.getString(3);
			System.out.println("ticket served: " + ticketserved);
			
			String ticketservedtST = resultSet.getString(4);
			System.out.println("ticket served ST: " + ticketservedtST);
			
			String ticketservedtWT = resultSet.getString(5);
			System.out.println("ticket served WT: " + ticketservedtWT);
				
				}  
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return catgraph;

	}
	
	@Test
	public String Feedback_Evolution_By_Hourly_Distribution() {

		System.out.println("SQL Connected to Waiting: ");

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
			resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-03-13','2023-03-13','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

			// Iterate over the result set and print the data
			while (resultSet.next()) {
			String Feedback_Evolution_By_Hourly_ = resultSet.getString(2);
			System.out.println("avg service time: " + Feedback_Evolution_By_Hourly_);
			
			Feedback_Evolution_By_Hourly_Distribution = Feedback_Evolution_By_Hourly_;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Feedback_Evolution_By_Hourly_Distribution;

	}


public String Target_Compliance_Per_Category() {

	System.out.println("SQL Connected to Target_Compliance_Per_Category: ");

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
		resultSet = statement.executeQuery("SELECT CategoryName, \r\n"
				+ "	case SUM(a.ServedTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(10,2), SUM(a.ServedTickets)) / CONVERT(DECIMAL(10,2), SUM(a.IssuedTickets)) as decimal(10,2)) * 100 as decimal(10,0))), 0) end as PercentageServedTickets,\r\n"
				+ "	case SUM(a.WaitingTickets) when 0 then 0 else isnull((cast(cast(CONVERT(DECIMAL(10,2), SUM(a.WaitingTickets)) / CONVERT(DECIMAL(10,2), SUM(a.IssuedTickets)) as decimal(10,2)) * 100 as decimal(10,0))), 0) end as PercentageWaitingTickets\r\n"
				+ "	from eqreport..DashboardBranchCategoryStatus a where BranchId = 231 and CategoryID = 'EMO'\r\n"
				+ "	--and CategoryName='Examenes COVID Latam' \r\n"
				+ "--	and CurrentDate='2023-03-03 12:22:10.400'\r\n"
				+ "\r\n"
				+ "	GROUP BY CategoryName, CategoryID");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String Target_Compliance_Per_Cat = resultSet.getString(1);
		System.out.println("Category name: " + Target_Compliance_Per_Cat);
		
		String PercentageServedTickets = resultSet.getString(2);
		System.out.println("Service: " + PercentageServedTickets);
		

		String PercentageWaitingTickets = resultSet.getString(3);
		System.out.println("Waiting: " + PercentageWaitingTickets);
		
		Target_Compliance_Per_Category = Target_Compliance_Per_Cat;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Target_Compliance_Per_Category;

}

public String Average_Time_Per_Category() {

	System.out.println("SQL Connected to Average_Time_Per_Category: ");

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
		resultSet = statement.executeQuery("	select CategoryName,\r\n"
				+ "	convert(decimal(10,1),SUM(a.AvgServiceTime)/ convert(decimal(10,1),60)) as AverageServiceTimePerCategory, \r\n"
				+ "	convert(decimal(10,1),SUM(a.AvgWaitTime)/ convert(decimal(10,1),60)) as AverageWaitingTimePerCategory \r\n"
				+ "	from eqreport..DashboardBranchCategoryStatus a where BranchId = 231 and CategoryID = 'EMO'\r\n"
				+ "	--and CategoryName='Examenes COVID Latam'\r\n"
				+ "	--and CurrentDate='2023-02-27 00:00:00.000'\r\n"
				+ "GROUP BY CategoryName");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String Cat_name = resultSet.getString(1);
		System.out.println("Category name: " + Cat_name);
		
		String service = resultSet.getString(2);
		System.out.println("Service: "+ service);
		

		String waiting = resultSet.getString(3);
		System.out.println("Waiting: "+ waiting);
		
		
		Average_Time_Per_Category = Cat_name;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Average_Time_Per_Category;

}

public String Client_waiting_Per_Category() {

	System.out.println("SQL Connected to Waiting: ");

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
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-03-13','2023-03-13','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String Client_waiting_Per_Cat = resultSet.getString(20);
		System.out.println("Ticket no show: " + Client_waiting_Per_Cat);
		
		Client_waiting_Per_Category = Client_waiting_Per_Cat;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Client_waiting_Per_Category;

}

public String Service_Rate_Per_Category() {

	System.out.println("SQL Connected to Waiting: ");

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
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-03-13','2023-03-13','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String Service_Rate_Per_Cat = resultSet.getString(3);
		System.out.println("Service_Rate_Per_Cat: " + Service_Rate_Per_Cat);
		
		Service_Rate_Per_Category = Service_Rate_Per_Cat;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Service_Rate_Per_Category;

}

public String Client_Served_Per_Category() {

	System.out.println("SQL Connected to Client_Served_Per_Category: ");

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
		resultSet = statement.executeQuery("execute eqreport_Archival.dbo.cd_getServiceWaitingCounter '230| 228 | 229 | 231 | 224','true|','2023-03-13','2023-03-13','APS-Appcitas| BSC-Benefits | EXT-Extra | FEE-Fees | HMS-Health Monitoring | HSC-Health | RAC-Recieve Amount | TAC-Transfer amount | TRF-Transfer |UTL-Utility'");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String Client_Served_Per_Cate = resultSet.getString(6);
		System.out.println("Client_Served_Per_Category : " + Client_Served_Per_Cate);
		
		Client_Served_Per_Category = Client_Served_Per_Cate;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Client_Served_Per_Category;


}

public String categories() {

	System.out.println("SQL Connected to Waiting: ");

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
		resultSet = statement.executeQuery("");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String categorie = resultSet.getString(21);
		System.out.println("Queue Size: " + categorie);
		
		categories = categorie;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return categories;


}

public String realtime_monitoring() {

	System.out.println("SQL Connected to Waiting: ");

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
		resultSet = statement.executeQuery("SELECT\r\n"
				+ "d.RegionID,\r\n"
				+ "d.BranchID,\r\n"
				+ "d.BranchName,\r\n"
				+ "SUM(ISNULL(d.TicketIssued,0))TicketsIssued,\r\n"
				+ "SUM(ISNULL(d.TicketServed,0))TicketsServed,\r\n"
				+ "SUM(ISNULL(d.TicketsWaiting,0))TicketsWaiting,\r\n"
				+ "\r\n"
				+ "AVG(ISNULL(d.TotalCounter,0))TotalCounter,\r\n"
				+ "AVG(ISNULL(d.ActiveCounters,0))ActiveCounters,\r\n"
				+ "--SUM(ISNULL(d.TicketInServing,0))TicketInServing\r\n"
				+ " CONVERT(varchar, DATEADD(ms, AVG(ISNULL(d.AvgServiceTime,0)) * 1000, 0), 108)AvgServiceTime\r\n"
				+ ", CONVERT(varchar, DATEADD(ms,AVG(ISNULL(d.AvgWaitTime,0))* 1000, 0), 108)AvgWaitTime\r\n"
				+ ", CONVERT(varchar, DATEADD(ms,AVG(ISNULL(d.MaxServiceTime,0))* 1000, 0), 108)MaxServiceTime\r\n"
				+ ", CONVERT(varchar, DATEADD(ms,AVG(ISNULL(d.MaxWaitTime,0))* 1000, 0), 108)MaxWaitTime\r\n"
				+ "\r\n"
				+ ", AVG(CAST((CAST((ISNULL(d.TicketWithInWt,0) + ISNULL(d.TicketNoShowWithinWT,0)) AS DECIMAL(18,2)) / CAST((CASE WHEN ISNULL(d.TicketIssued,0) = 0 THEN 1 ELSE ISNULL(d.TicketIssued,0) END) AS DECIMAL(18,2))) * 100 AS DECIMAL(18,2))) AS ServiceLevel\r\n"
				+ "from eqreport..DashboardRegionBranchDashBoard d\r\n"
				+ "left outer join  eQportal.dbo.eQPortal_Branch b  on BranchID =  b.ID\r\n"
				+ "left outer join [eqPortal]..eqPortal_SpectraHeartBeat c on d.BranchID =  c.BranchId\r\n"
				+ "left outer join [eqPortal]..eQPortal_Branch br on br.ID = c.BranchId\r\n"
				+ "where d.BranchID = 231\r\n"
				+ "group by d.RegionID, d.BranchID, d.BranchName,b.HeartBeatInterval, c.HeartBeat");

		// Iterate over the result set and print the data
		while (resultSet.next()) {	
		
		String branchname = resultSet.getString(3);
		System.out.println("branchname: " + branchname);
		
		//String Status = resultSet.getString(18);
		//System.out.println("Status: " + Status);
		
		String ticketissue = resultSet.getString(4);
		System.out.println("ticketissue: " + ticketissue);
		
		String ticketserved = resultSet.getString(5);
		System.out.println("ticketserved: " + ticketserved);
		
		String ticketwaiting = resultSet.getString(6);
		System.out.println("ticketwaiting: " + ticketwaiting);
		
		String totalcounter = resultSet.getString(7);
		System.out.println("totalcounter: " + totalcounter);
		
		String activecounter = resultSet.getString(8);
		System.out.println("activecounter: " + activecounter);
		
		String avgservicetime = resultSet.getString(9);
		System.out.println("avgservicetime: " + avgservicetime);
		
		String avgwaittime = resultSet.getString(10);
		System.out.println("avgwaittime: " + avgwaittime);
		
		String maxservicetime = resultSet.getString(11);
		System.out.println("maxservicetime: " + maxservicetime);
		
		String maxwaittime = resultSet.getString(12);
		System.out.println("maxwaittime: " + maxwaittime);
		
		String servicelevel = resultSet.getString(13);
		System.out.println("servicelevel: " + servicelevel);
		
		//realtime_monitoring = realtime_monitorin;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return realtime_monitoring;

}

public String counters() {

	System.out.println("SQL Connected to counters: ");

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
		resultSet = statement.executeQuery("select t.CounterId as counternumber,b.Name teller,  COUNT(t.TicketId) TicketServed, ISNULL(AVG(t.CalcServiceTime),0) AvgServiceTime , br.Name as branch  from eqreport..PSRTicket t\r\n"
				+ "inner join  eqreport..vu_Counter   psrc on psrc.OperatorId = t.CounterId\r\n"
				+ "inner join eqPortal..eQPortal_Operator b on b.OperatorId = t.OperatorId\r\n"
				+ "inner join eqPortal..eQPortal_Branch br on br.ID = t.BranchId\r\n"
				+ "where t.BranchId=231 and b.Name = 'h1' --and t.IssueTime = '2023-02-20' \r\n"
				+ "Group by  t.CounterId, CONVERT(char(10), isnull(t.IssueTime,'1900-01-01'),126 ), b.Name,t.BranchId, br.Name");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String counterNo = resultSet.getString(1);
		System.out.println("counterNo: " + counterNo);
		
	//	String Status = resultSet.getString(23);
	//	System.out.println("Status: " + Status);

		String teller = resultSet.getString(2);
		System.out.println("teller: " + teller);

		String ticketserved = resultSet.getString(3);
		System.out.println("ticketserved: " + ticketserved);

		String avgservicetime = resultSet.getString(4);
		System.out.println("avg service time: " + avgservicetime);

		String branch = resultSet.getString(5);
		System.out.println("branch: " + branch);
		

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return counters;

}
@Test
public String Tellergroup() {

	System.out.println("SQL Connected to Tellergroup: ");

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
		resultSet = statement.executeQuery("select b.BranchName, b.OperatorName , c.CounterId, SUM(t1.TicketServed) TicketServed, (cast (cast( (select top 1 sum(b.TicketServedWithinST)) as DECIMAL(20,2))\r\n"
				+ "				/(select top 2 sum(TicketServed)  where t1.BranchID = t1.BranchID and b.OperatorID = t1.OperatorID) as  DECIMAL(20,0)) * 100) as SLA  \r\n"
				+ "				from  eqreport..DashboardBranchOperatorStatus  t1\r\n"
				+ "				inner join eqreport..[DashboardBranchOperatorCategoryStatus] b on b.BranchID = t1.BranchID\r\n"
				+ "				inner join eqreport..PSRCounter c on c.BranchId = t1.BranchID\r\n"
				+ "				where t1.BranchID = 231 and CategoryName='EMOS' \r\n"
				+ "				group by t1.TicketServed,TicketServedWithinST,b.OperatorID,b.BranchID,t1.BranchID,  t1.OperatorID, b.BranchName,b.OperatorName,c.CounterId\r\n"
				+ "	");

		// Iterate over the result set and print the data
		while (resultSet.next()) {
		String sla = resultSet.getString(5);
		System.out.println("SLA: " + sla+"%");
		
		String ticketserved = resultSet.getString(4);
		System.out.println("Ticket Served: " +ticketserved);
		
		
		Tellergroup = sla;

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Tellergroup;

}

}


