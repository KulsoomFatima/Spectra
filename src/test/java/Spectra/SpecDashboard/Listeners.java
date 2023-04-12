package Spectra.SpecDashboard;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import report.Extentreport.ExtentRep;
import resources.base;

public class Listeners extends base implements ITestListener{
	
	
	ExtentTest test;
	ExtentReports extent = ExtentRep.getrepObj();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("** Executed " + result.getMethod().getMethodName() + " test successfully...");
        extentTest.get().log(Status.PASS, result.getMethod().getMethodName() + " ,Test passed");
		test.log(Status.PASS, MarkupHelper.createLabel("Name of test pass: "+ result.getName(), ExtentColor.GREEN));

       // extentTest.get().log(Status.PASS, test.info(null), null)
       // extentTest.setTestRunnerOutput(StringUtils.join(Reporter.getOutput(), "<br>"));
        for (String s : Reporter.getOutput()) {
        	   extent.setTestRunnerOutput(s);
        	 }
	}
	
	public void onTestFailure(ITestResult result) {
		//	System.out.println("Listener Say, Test Failed " + result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of test fail: "+ result.getName(), ExtentColor.RED));

		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click to see the details:"+ 
				"</font><b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

		WebDriver driver = base.driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());
		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		catch (IOException e) {
			extentTest.get().fail("Test Failed, cannot attach screenshot");
		}
		String logText = "<b> Test Method" + methodName + " Failed </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m); 
		
		
	}
	
/*	 public void logsGeneration()
	    {
	        test = extent.createTest("logsGeneration");
	        test.log(Status.INFO,"createTest() method will return the ExtentTest object");
	        test.log(Status.INFO, "I am in actual Test");
	        test.log(Status.INFO, "We can write the actual test logic in this Test");
	         
	        // Using Labels
	        test.log(Status.INFO, MarkupHelper.createLabel("************* Using Labels *************", ExtentColor.RED));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 1", ExtentColor.BLUE));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 2", ExtentColor.BLUE));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 3", ExtentColor.BLUE));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 4", ExtentColor.BLUE));
	    }
*/
	public String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/Screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("*************************************");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("*************************************");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_")+ ".png";
		return fileName;


	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of test skip: "+ result.getName(), ExtentColor.YELLOW));

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}
  
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		extent.flush();
	}
	
	
	

	
}
	/*public WebDriver driver;
	
	ExtentTest test;
	ExtentReports extent = ExtentRep.getrepObj();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		}

	
	public void onTestFailure(ITestResult result) {
		//	System.out.println("Listener Say, Test Failed " + result.getName());
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click to see the details:"+ 
				"</font><b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

		//WebDriver driver = base.driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());
		String TestCaseMethod = result.getMethod().getMethodName();

		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(TestCaseMethod, driver), result.getMethod().getMethodName());

		}
		
		catch (IOException e) {
			extentTest.get().fail("Test Failed, cannot attach screenshot");
		}
		String logText = "<b> Test Method" + methodName + " Failed </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m); 
	}

	private String getScreenshotPath(String testCaseMethod, WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}


	public String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/Screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("*************************************");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("*************************************");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_")+ ".png";
		return fileName;


	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	
	

}
*/
	/*
	
	public WebDriver driver;

	ExtentTest test;
	ExtentReports extent = ExtentRep.getrepObj();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		}
	
	public void onTestFailure(ITestResult result) {
		//	System.out.println("Listener Say, Test Failed " + result.getName());
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click to see the details:"+ 
				"</font><b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

		//WebDriver driver = base.driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());
	    String TestCaseMethod = result.getMethod().getMethodName();

		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		extentTest.get().addScreenCaptureFromPath(getScreenshotPath(TestCaseMethod, driver), result.getMethod().getMethodName());

		}
		catch (IOException e) {
			extentTest.get().fail("Test Failed, cannot attach screenshot");
		}
		String logText = "<b> Test Method" + methodName + " Failed </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m); 
		
		
		
		
	}
	
	 private String getScreenshotPath(String testCaseMethod, WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}


	public void logsGeneration()
	    {
	        test = extent.createTest("logsGeneration");
	        test.log(Status.INFO,"createTest() method will return the ExtentTest object");
	        test.log(Status.INFO, "I am in actual Test");
	        test.log(Status.INFO, "We can write the actual test logic in this Test");
	         
	        // Using Labels
	        test.log(Status.INFO, MarkupHelper.createLabel("*************** Using Labels ***************", ExtentColor.RED));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 1", ExtentColor.BLUE));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 2", ExtentColor.BLUE));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 3", ExtentColor.BLUE));
	        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 4", ExtentColor.BLUE));
	    }

	public String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/Screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("*************************************");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("*************************************");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_")+ ".png";
		return fileName;


	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	
	

}*/
	
	
	
