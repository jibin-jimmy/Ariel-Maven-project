package com.mindtree.Utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {
    private static ExtentTest test;
    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static String datetime = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    public static String tempDate;
    private static ScreenShot ss1 = new ScreenShot();

    public static void createReport() {
        String reportPath = "./Reports/ExtentReport_" + datetime + ".html";
        spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        tempDate = datetime;
    }

    public static void beforeMethodextent(String methodName) {
        test = extent.createTest("Ariel Test - " + methodName)
                     .assignAuthor("Jibin Jimmy");
    }

    public static void error(String error) {
        test.fail(error);
    }

    public static void info(String info) {
        test.info(info);
    }

    public static void fail(String failMessage, WebDriver driver) throws IOException {
        test.fail(failMessage)
            .addScreenCaptureFromPath(ss1.Screenshot(driver));
    }

    public static void pass(String passMessage, WebDriver driver) throws IOException {
        test.pass(passMessage)
            .addScreenCaptureFromPath(ss1.Screenshot(driver));
    }

    public static void afterMethodExtent() {
        // Nothing specific here unless needed per test
    }

    public static void afterTestExtent() {
        extent.flush();
    }
}