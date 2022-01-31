package example.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import example.init.BaseClass;

public class ExtentReportsSetUp extends BaseClass
{
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports ReportSetUp()
    {
        extentSparkReporter= new ExtentSparkReporter(System.getProperty("user.dir") + "/CRMExtentResults/CRMExtentReport.html");
        extentReports= new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Test Automation Report");
        extentSparkReporter.config().setDocumentTitle("Test Automation");

        return extentReports;
    }
}
