package Utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter
{
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest reportLogger;


    public void onStart (ITestContext testContext) {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) ;//time stamp
        String repName="Extent-Report-"+timestamp;
        htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        extent=new ExtentReports() ;

        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environemnt", "QA");
        extent.setSystemInfo("user","Swapnil");
        htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report htmIReporter.config(). setReportName("Functional Test Report"); // name of the report htm1Reporter.config().setTestViewchartLocation(ChartLocation.TOP);//location of the chart htmIReporter.config() . setTheme (Theme .DARK) ;
    }


    public void onTestSuccess (ITestResult tr)
    {

        reportLogger=extent.createTest(tr.getName()); // create new entry in th report
        reportLogger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure (ITestResult tr)
    {
        reportLogger=extent.createTest(tr.getName ()); // create new entry in th report
        reportLogger.log(Status.FAIL, MarkupHelper.createLabel (tr.getName(),ExtentColor.RED));
        String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";

        File f = new File (screenshotPath);

        if(f.exists())
        {
            reportLogger.fail("Screenshot is below:" + reportLogger.addScreenCaptureFromPath(screenshotPath));
        }
    }


    public void onTestskipped (ITestResult tr)
    {
        reportLogger=extent.createTest(tr.getName()); // create new entry in th report
        reportLogger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext) {

        extent.flush ();
    }

}