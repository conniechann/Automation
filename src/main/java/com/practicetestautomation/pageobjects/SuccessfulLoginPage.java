package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SuccessfulLoginPage extends BasePage {
    private By logoutButtonLocator = By.linkText("Log out");

    // Constructor to initialize the WebDriver instance
    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return isDisplayed(logoutButtonLocator);
    }

    public void load(){
        waitForElement(logoutButtonLocator);
    }
}
