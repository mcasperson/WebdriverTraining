package com.matthewcasperson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

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
}
