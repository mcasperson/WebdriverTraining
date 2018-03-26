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

    @Override
    public void clickLinkWithText(String text, int wait) {
        automatedBrowser.clickLinkWithText(text, wait);
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        automatedBrowser.clickElementWithXPath(xpath);
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String elementId, String optionText, int waitTime) {
        automatedBrowser.selectOptionByTextFromSelectWithId(elementId, optionText, waitTime);
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        automatedBrowser.clickElementWithXPath(xpath, waitTime);
    }

    @Override
    public void populateTextBoxWithXpath(String xpath, String text) {
        automatedBrowser.populateTextBoxWithXpath(xpath, text);
    }

    @Override
    public void populateTextBoxWithXpath(String xpath, String text, int waitTime) {
        automatedBrowser.populateTextBoxWithXpath(xpath, text, waitTime);
    }

    @Override
    public String getTextFromElementWithXpath(String xpath) {
        return automatedBrowser.getTextFromElementWithXpath(xpath);
    }

    @Override
    public String getTextFromElementWithXpath(String xpath, int waitTime) {
        return automatedBrowser.getTextFromElementWithXpath(xpath, waitTime);
    }
}
