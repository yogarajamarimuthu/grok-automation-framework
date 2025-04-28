package com.grok.stpedefinitions;

import com.grok.config.ConfigReader;
import com.grok.driver.DriverManager;
import com.grok.pages.LoginPage;
import com.grok.utils.ExtentReportManager;
import com.grok.utils.LogManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    private final WebDriver driver = DriverManager.getDriver();
    private final LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        LogManager.info("Navigating to login page");
        driver.get(ConfigReader.getProperty("url"));
        ExtentReportManager.getTest().info("Navigated to login page");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.login(username, password);
        ExtentReportManager.getTest().info("Entered credentials: " + username);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        LogManager.info("Clicking login button");
        ExtentReportManager.getTest().info("Clicked login button");
    }

    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() {
        String currentUrl = driver.getCurrentUrl();
        LogManager.info("Verifying homepage URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("home"), "Not redirected to homepage");
        ExtentReportManager.getTest().pass("Successfully redirected to homepage");
    }
}