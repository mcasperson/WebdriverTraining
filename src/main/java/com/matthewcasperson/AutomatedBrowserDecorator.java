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
    public void clickElementWithId(String id, int waitTime) {
        automatedBrowser.clickElementWithId(id, waitTime);
    }

    @Override
    public String getTextFromElementWithId(String message) {
        return automatedBrowser.getTextFromElementWithId(message);
    }

    @Override
    public String getTextFromElementWithId(String id, int waitTime) {
        return automatedBrowser.getTextFromElementWithId(id, waitTime);
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
    public void populateTextBoxWithId(String id, String text) {
        automatedBrowser.populateTextBoxWithId(id, text);
    }

    @Override
    public void populateTextBoxWithId(String id, String text, int waitTime) {
        automatedBrowser.populateTextBoxWithId(id, text, waitTime);
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
    public void selectOptionByTextFromSelectWithId(String id, String optionText, int waitTime) {
        automatedBrowser.selectOptionByTextFromSelectWithId(id, optionText, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText) {
        automatedBrowser.selectOptionByTextFromSelectWithXPath(xpath, optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText, int waitTime) {
        automatedBrowser.selectOptionByTextFromSelectWithXPath(xpath, optionText, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText) {
        automatedBrowser.selectOptionByTextFromSelectWithCSS(css, optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText, int waitTime) {
        automatedBrowser.selectOptionByTextFromSelectWithCSS(css, optionText, waitTime);
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        automatedBrowser.clickElementWithXPath(xpath, waitTime);
    }

    @Override
    public void clickElementWithCSS(String css) {
        automatedBrowser.clickElementWithCSS(css);
    }

    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        automatedBrowser.clickElementWithCSS(css, waitTime);
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text) {
        automatedBrowser.populateTextBoxWithXPath(xpath, text);
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text, int waitTime) {
        automatedBrowser.populateTextBoxWithXPath(xpath, text, waitTime);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        automatedBrowser.populateTextBoxWithCSS(css, text);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text, int waitTime) {
        automatedBrowser.populateTextBoxWithCSS(css, text, waitTime);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        return automatedBrowser.getTextFromElementWithXPath(xpath);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath, int waitTime) {
        return automatedBrowser.getTextFromElementWithXPath(xpath, waitTime);
    }

    @Override
    public String getTextFromElementWithCSS(String css) {
        return automatedBrowser.getTextFromElementWithCSS(css);
    }

    @Override
    public String getTextFromElementWithCSS(String css, int waitTime) {
        return automatedBrowser.getTextFromElementWithCSS(css, waitTime);
    }
}
