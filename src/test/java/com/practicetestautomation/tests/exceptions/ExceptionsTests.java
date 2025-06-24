package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.pageobjects.ExceptionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionsTests {
    private WebDriver driver;
    private Logger logger;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger = Logger.getLogger(ExceptionsTests.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Running test in " + browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                logger.warning("Configuration for " + browser + " is missing, so running tests in Chrome by default");
                driver = new ChromeDriver();
                break;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        logger.info("Browser is closed");
    }

    @Test
    public void noSuchElementExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddButton();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddButton();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void elementNotInteractableExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddButton();
        exceptionsPage.isRowTwoDisplayedAfterWait();
        exceptionsPage.enterTextInRowTwo("Sushi");
        exceptionsPage.saveRowTwo();
        Assert.assertEquals(exceptionsPage.getSuccessMessage(), "Row 2 was saved", "Message is not expected");
    }

    @Test
    public void invalidElementStateExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushEditButton();
        exceptionsPage.enterTextInRowOne("Sushi");
        exceptionsPage.saveRowOne();
        Assert.assertEquals(exceptionsPage.getSuccessMessage(), "Row 1 was saved", "Message is not expected");
    }

    @Test
    public void staleElementReferenceExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddButton();
        Assert.assertTrue(exceptionsPage.isInstructionsElementHiddenAfterWait(), "Instructions element is not hidden");

    }
}