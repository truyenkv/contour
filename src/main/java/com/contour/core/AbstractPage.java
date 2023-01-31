package com.contour.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    private WebDriverWait explicitWait;
    private WebElement element;
    private Duration timeOut = Duration.ofMillis(5000);

    private By byXpath(String xpathValue) {
        return By.xpath(xpathValue);
    }

    private By byXpath(String xpath, String...value) {
        return By.xpath(String.format(xpath, value));
    }

    protected WebElement find(WebDriver driver, String xpathValue) {
        return driver.findElement(byXpath(xpathValue));
    }

    protected void clickToElement(WebDriver driver, String xpathValue) {
        find(driver, xpathValue).click();
    }

    protected String getDynamicLocator(String xpath, String...value){
        return String.format(xpath, value);
    }

    protected void clickElementWithValue(WebDriver driver, String xpath, String value){
        find(driver, getDynamicLocator(xpath, value)).click();
    }
    protected void waitForElementVisible(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, timeOut);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
    }

    protected void waitForElementClickable(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, timeOut);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
    }

    protected void waitForElementClickable(WebDriver driver, String xpath, String...value) {
        explicitWait = new WebDriverWait(driver, timeOut);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpath, value)));
    }

    public boolean isElementDisplay(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).isDisplayed();
    }

    protected String getElementText(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).getText();
    }

    protected void inputText(WebDriver driver, String xpath, String value){
        element = find(driver, xpath);
        element.clear();
        element.sendKeys(value);
    }

    protected void checkTheCheckBox(WebDriver driver, String xpathValue) {
        if (!find(driver, xpathValue).isSelected()) {
            find(driver, xpathValue).click();
        }
    }
}
