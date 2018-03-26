package com.matthewcasperson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface AutomatedBrowser {
    void setWebDriver(WebDriver webDriver);
    WebDriver getWebDriver();

    void init();

    DesiredCapabilities getDesiredCapabilities();

    void goTo(String url);

    void clickElementWithId(String elementId);

    String getTextFromElementWithId(String elementId);

    void destroy();

    void selectOptionByTextFromSelectWithId(String selectId, String optionText);

    void maximizeWindow();

    void populateTextBoxWithId(String elementId, String text);

    void clickLinkWithText(String text);

    void clickLinkWithText(String text, int waitTime);

    void clickElementWithXPath(String xpath);

    void selectOptionByTextFromSelectWithId(String elementId, String optionText, int waitTime);

    void clickElementWithXPath(String xpath, int waitTime);

    void populateTextBoxWithXpath(String xpath, String text);

    void populateTextBoxWithXpath(String xpath, String text, int waitTime);

    String getTextFromElementWithXpath(String xpath);

    String getTextFromElementWithXpath(String xpath, int waitTime);
}
