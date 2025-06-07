package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {
    private static final ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
