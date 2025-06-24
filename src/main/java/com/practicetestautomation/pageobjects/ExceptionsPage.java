package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionsPage extends BasePage {
    private By addButtonLocator = By.id("add_btn");
    private By editButtonLocator = By.id("edit_btn");
    private By row2InputField = By.xpath("//div[@id='row2']/input");
    private By row1InputField = By.xpath("//div[@id='row1']/input");
    private By row2SaveButton = By.xpath("//div[@id='row2']/button[@name='Save']");
    private By row1SaveButton = By.xpath("//div[@id='row1']/button[@name='Save']");
    private By successMessageLocator = By.id("confirmation");
    private By instructionsLocator = By.id("instructions");


    public ExceptionsPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void pushAddButton() {
        driver.findElement(addButtonLocator).click();
    }

    public void pushEditButton() {
        driver.findElement(editButtonLocator).click();
    }

    public boolean isRowTwoDisplayedAfterWait() {
        return waitForIsDisplayed(row2InputField);
    }

    public void enterTextInRowTwo(String text) {
        driver.findElement(row2InputField).sendKeys(text);
    }

    public void enterTextInRowOne(String text) {
        WebElement row1Input = driver.findElement(row1InputField);
        row1Input.clear();
        driver.findElement(row1InputField).sendKeys(text);
    }

    public void saveRowTwo() {
        driver.findElement(row2SaveButton).click();
    }

    public void saveRowOne() {
        driver.findElement(row1SaveButton).click();
    }

    public String getSuccessMessage() {
        return waitForElement(successMessageLocator).getText();
    }

    public boolean isInstructionsElementHiddenAfterWait(){
        return waitForIsHidden(instructionsLocator);
    }

}
