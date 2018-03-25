package com.matthewcasperson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
            webDriver.close();
        }
    }
}
