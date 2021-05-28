package org.example.init;

import com.aventstack.extentreports.Status;
import org.example.Utilities.TestUtility;
import org.example.reports.ExtentReportsSetUp;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener extends ExtentReportsSetUp implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result) {
       extentTest= extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test case passed is ::: "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test case failed is ::: "+result.getMethod().getMethodName());
        extentTest.log(Status.FAIL, result.getThrowable());
        try {
            extentTest.addScreenCaptureFromPath(TestUtility.TakeScreeshotForFailedTestCases(result.getMethod().getMethodName(), driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Case Skipped is ::: " +result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        extentReports =ReportSetUp();
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
