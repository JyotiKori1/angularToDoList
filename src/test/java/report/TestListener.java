package report;

	
	import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;

	
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.Status;

import commonLib.BaseTest;

	public class TestListener implements ITestListener {

		protected static Logger logger = LogManager.getLogger(TestListener.class);  
		public void onStart(ITestContext context) {
			logger.info("*** Test Suite " + context.getName() + " started ***");
		}

		public void onFinish(ITestContext context) {
			logger.info(("*** Test Suite " + context.getName() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		}

		public void onTestStart(ITestResult result) {
			logger.info(("*** Running test method " + result.getMethod().getMethodName() + "..."));
			ExtentTestManager.startTest(result.getMethod().getMethodName());
		}

		public void onTestSuccess(ITestResult result) {
			logger.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
			ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		}

		public void onTestSkipped(ITestResult result) {
			logger.info("*** Test " + result.getMethod().getMethodName() + " skipped...");
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			logger.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		}

}
