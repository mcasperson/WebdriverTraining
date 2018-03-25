package com.matthewcasperson;

import org.openqa.selenium.WebDriver;

public class AutomatedBrowserDecorator implements AutomatedBrowser {
    protected AutomatedBrowser automatedBrowser;

    public AutomatedBrowserDecorator(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    @Override
    public void setWebDriver(WebDriver webDriver) {
        if (automatedBrowser != null) {
            automatedBrowser.setWebDriver(webDriver);
        }
    }

    @Override
    public WebDriver getWebDriver() {
        if (automatedBrowser != null) {
            return automatedBrowser.getWebDriver();
        }

        return null;
    }

    @Override
    public void init() {
        if (automatedBrowser != null) {
            automatedBrowser.init();
        }
    }

    @Override
    public void goTo(String url) {
        if (automatedBrowser != null) {
            automatedBrowser.goTo(url);
        }
    }

    @Override
    public void clickElementWithId(String testbutton) {
        if (automatedBrowser != null) {
            automatedBrowser.clickElementWithId(testbutton);
        }
    }

    @Override
    public String getTextFromElementWithId(String message) {
        if (automatedBrowser != null) {
            return automatedBrowser.getTextFromElementWithId(message);
        }

        return null;
    }

    @Override
    public void destroy() {
        if (automatedBrowser != null) {
            automatedBrowser.destroy();
        }
    }
}
