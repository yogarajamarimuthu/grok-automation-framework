package com.grok.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extent = new ExtentReports();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports.html");
        spark.config().setDocumentTitle("Automation Test Report");
        extent.attachReporter(spark);
    }

    public static ExtentTest createTest(String testName) {
        test.set(extent.createTest(testName));
        return test.get();
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flush() {
        extent.flush();
    }
}