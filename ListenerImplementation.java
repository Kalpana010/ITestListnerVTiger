package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerImplementation implements ITestListener
{
	ExtentReports report; 
	


	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub
//		System.out.print("TextScript execution is started");
//		ITestListener.super.onTestStart(result);
		//String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TextScript execution is started",true);
			}

	//@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TextScript execution is passed",true);
		
	
	}

	//@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(message+methodName+"TextScript executions failed ",true);
	}

    @Override
	public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TextScript executions Skipped ",true);
	}


	//@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName();
		//Reporter.log("TextScript executions failed ",true);
		JavaUtils jutil = new JavaUtils();
		
		ExtentSparkReporter reporter = new  ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+"html");
	reporter.config().setDocumentTitle("VTigerCrm");
	reporter.config().setTheme(Theme.STANDARD);
	reporter.config().setReportName("pune");
	
	 report = new ExtentReports();
	report.attachReporter(reporter); //this method is used to to attach the configuration
	
	report.setSystemInfo("os","window");
	report.setSystemInfo("Browser", "chrome");
	report.setSystemInfo("chromeversion", "122");
	report.setSystemInfo("Author", "kalpana");

	
		 
	}

	//@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		//String methodName = result.getMethod().getMethodName();
		//Reporter.log("TextScript executions failed ",true);
		report.flush(); //it generate the report
	}

}
