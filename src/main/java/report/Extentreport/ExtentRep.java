package report.Extentreport;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentRep {

	static ExtentReports extent;

	public static ExtentReports getrepObj() {
		
		/*	String path = System.getProperty("user.dir")+"\\Reports\\extentreport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Creadit Card Ptoject");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Kulsoom", "Tester");
		return extent;
		
	}
	*/
		
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/extentreports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		//htmlReporter = new ExtentHtmlReporter ("./reports/Extent.html");
		htmlReporter.config().setDocumentTitle("Automation");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Spectra Dashboard Automation Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		//extent.setSystemInfo("OS", "WINDOWS 10");
		extent.setSystemInfo("TesterName","kulsoom");
		extent.setSystemInfo("Browsername","chrome");
		
		// directory where output is to be printed
		ExtentLoggerReporter logger = new ExtentLoggerReporter("user/build/name/");
		//ExtentReporter extent = new ExtentReports();
		extent.attachReporter(logger);
		
		
		
			
		logger.config().enableTimeline(true);
	//	((Object) logger.config()).setAutoCreateRelativePathMedia(true);
		logger.config().setCSS("css-string");
		logger.config().setDocumentTitle("page title");
		logger.config().setEncoding("utf-8");
		logger.config().setJS("js-string");
		logger.config().setProtocol(Protocol.HTTPS);
		logger.config().setReportName("build name");
		logger.config().setTheme(Theme.DARK);
		logger.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");


		
		return extent; 
	}
	
	public static String getReportName() {
		Date d = new Date();
		String fileName = "Report" + "_" + d.toString().replace(":", "_").replace(" ", "_")+ ".html";
		return fileName;
	}

	public static ExtentReports createInstance() {
		// TODO Auto-generated method stub
		return null;
	}


		
	
	
}
