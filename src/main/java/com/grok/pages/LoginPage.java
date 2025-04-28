package com.grok.pages;

import com.grok.driver.DriverManager;
import com.grok.utils.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void login(String username, String password) {
        LogManager.info("Logging in with username: " + username);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}