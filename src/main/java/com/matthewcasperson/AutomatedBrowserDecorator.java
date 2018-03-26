package com.matthewcasperson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.google.common.base.Preconditions.checkNotNull;

public class AutomatedBrowserDecorator implements AutomatedBrowser {
    protected AutomatedBrowser automatedBrowser;

    public AutomatedBrowserDecorator(AutomatedBrowser automatedBrowser) {
        checkNotNull(automatedBrowser);

        this.automatedBrowser = automatedBrowser;
    }

    @Override
    public WebDriver getWebDriver() {
        return automatedBrowser.getWebDriver();
    }

    @Override
    public void setWebDriver(WebDriver webDriver) {

        automatedBrowser.setWebDriver(webDriver);
    }

    @Override
    public void init() {
        automatedBrowser.init();
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return automatedBrowser.getDesiredCapabilities();
    }

    @Override
    public void goTo(String url) {
        automatedBrowser.goTo(url);
    }

    @Override
    public void clickElementWithId(String testbutton) {
        automatedBrowser.clickElementWithId(testbutton);

    }

    @Override
    public String getTextFromElementWithId(String message) {
        return automatedBrowser.getTextFromElementWithId(message);
    }

    @Override
    public void destroy() {
        automatedBrowser.destroy();
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String selectId, String optionText) {
        automatedBrowser.selectOptionByTextFromSelectWithId(selectId, optionText);
    }

    @Override
    public void maximizeWindow() {
        automatedBrowser.maximizeWindow();
    }

    @Override
    public void populateTextBoxWithId(String elementId, String text) {
        automatedBrowser.populateTextBoxWithId(elementId, text);
    }

    @Override
    public void clickLinkWithText(String text) {
        automatedBrowser.clickLinkWithText(text);
    }
}
