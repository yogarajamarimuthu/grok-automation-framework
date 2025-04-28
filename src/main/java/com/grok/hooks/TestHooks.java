package com.grok.hooks;

import com.grok.driver.DriverManager;
import com.grok.utils.ExtentReportManager;
import com.grok.utils.LogManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestHooks {

    @Before
    public void setUp(Scenario scenario) {
        LogManager.info("Starting scenario: " + scenario.getName());
        ExtentReportManager.createTest(scenario.getName());
        DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LogManager.info("Scenario failed: " + scenario.getName());
            ExtentReportManager.getTest().fail("Scenario failed");
        } else {
            LogManager.info("Scenario passed: " + scenario.getName());
            ExtentReportManager.getTest().pass("Scenario passed");
        }
        DriverManager.quit();
        ExtentReportManager.flush();
    }
}