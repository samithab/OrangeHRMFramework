package com.learnautomation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigsDataProvider;
import com.learnautomation.utilities.ScreenshotsHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseClass {

    public static WebDriver driver;
    public ConfigsDataProvider config;
    public static ExtentReports extent;
    public static ExtentTest test;


    @BeforeSuite
    public void setUpSuite(){
        config= new ConfigsDataProvider();

        // Set up Extent Report before running suite
        String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Automation Test Report");
        spark.config().setDocumentTitle("QA Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Samitha");
        extent.setSystemInfo("Environment", "QA");

    }

    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void captureStatus(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed: " + result.getThrowable());

            // take screenshot and attach
            String screenshotPath = ScreenshotsHelper.takeScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + result.getThrowable());
        }
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    @BeforeClass
    public void setup(){
        driver = BrowserFactory.startApplication(driver,config.getBrowser(), config.getUrl());
    }

    @AfterSuite
    public void flushReport() {
        extent.flush(); // generate the report at the end of the suite
    }
}
