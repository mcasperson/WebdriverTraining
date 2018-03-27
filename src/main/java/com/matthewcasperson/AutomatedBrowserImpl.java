package com.matthewcasperson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.base.Preconditions.checkNotNull;

public class AutomatedBrowserImpl implements AutomatedBrowser {
    private WebDriver webDriver;

    @Override
    public void setWebDriver(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void init() {
        // this is implemented by a decorator
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return new DesiredCapabilities();
    }

    @Override
    public void goTo(final String url) {
        checkNotNull(webDriver);
        checkNotNull(url);

        webDriver.get(url);
    }

    @Override
    public void clickElementWithId(final String elementId) {
        checkNotNull(webDriver);
        checkNotNull(elementId);

        webDriver.findElement(By.id(elementId)).click();
    }

    @Override
    public void clickElementWithId(String elementId, int waitTime) {
        if (waitTime <= 0) {
            clickElementWithId(elementId);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.id(elementId)))).click();
        }
    }

    @Override
    public String getTextFromElementWithId(final String elementId) {
        checkNotNull(webDriver);
        checkNotNull(elementId);

        return webDriver.findElement(By.id(elementId)).getText();
    }

    @Override
    public void destroy() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String selectId, String optionText) {
        new Select(webDriver.findElement(By.id(selectId))).selectByVisibleText(optionText);
    }

    @Override
    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    @Override
    public void populateTextBoxWithId(String elementId, String text) {
        webDriver.findElement(By.id(elementId)).sendKeys(text);
    }

    @Override
    public void clickLinkWithText(String text) {
        webDriver.findElement(By.linkText(text)).click();
    }

    @Override
    public void clickLinkWithText(String text, int waitTime) {
        if (waitTime <= 0) {
            clickLinkWithText(text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.linkText(text)))).click();
        }
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String elementId, String optionText, int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithId(elementId, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.id(elementId))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        if (waitTime <= 0) {
            clickElementWithXPath(xpath);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath)))).click();
        }
    }

    @Override
    public void populateTextBoxWithXpath(String xpath, String text) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Override
    public void populateTextBoxWithXpath(String xpath, String text, int waitTime) {
        if (waitTime <= 0) {
            populateTextBoxWithXpath(xpath, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath)))).sendKeys(text);
        }
    }

    @Override
    public String getTextFromElementWithXpath(String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }

    @Override
    public String getTextFromElementWithXpath(String xpath, int waitTime) {
        if (waitTime <= 0) {
            return getTextFromElementWithXpath(xpath);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            return wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath)))).getText();
        }
    }
}
