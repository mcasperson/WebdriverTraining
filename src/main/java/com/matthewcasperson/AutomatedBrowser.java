package com.matthewcasperson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface AutomatedBrowser {
    WebDriver getWebDriver();

    void setWebDriver(WebDriver webDriver);

    void init();

    void destroy();

    DesiredCapabilities getDesiredCapabilities();

    void goTo(String url);

    void maximizeWindow();

    void clickElementWithId(String id);

    void clickElementWithId(String id, int waitTime);

    void clickElementWithXPath(String xpath);

    void clickElementWithXPath(String xpath, int waitTime);

    void clickElementWithCSS(String css);

    void clickElementWithCSS(String css, int waitTime);

    void clickLinkWithText(String text);

    void clickLinkWithText(String text, int waitTime);

    void selectOptionByTextFromSelectWithId(String id, String optionText);

    void selectOptionByTextFromSelectWithId(String id, String optionText, int waitTime);

    void selectOptionByTextFromSelectWithXPath(String xpath, String optionText);

    void selectOptionByTextFromSelectWithXPath(String xpath, String optionText, int waitTime);

    void selectOptionByTextFromSelectWithCSS(String css, String optionText);

    void selectOptionByTextFromSelectWithCSS(String css, String optionText, int waitTime);

    void populateTextBoxWithId(String id, String text);

    void populateTextBoxWithId(String id, String text, int waitTime);

    void populateTextBoxWithXPath(String xpath, String text);

    void populateTextBoxWithXPath(String xpath, String text, int waitTime);

    void populateTextBoxWithCSS(String css, String text);

    void populateTextBoxWithCSS(String css, String text, int waitTime);

    String getTextFromElementWithId(String id);

    String getTextFromElementWithId(String id, int wait);

    String getTextFromElementWithXPath(String xpath);

    String getTextFromElementWithXPath(String xpath, int waitTime);

    String getTextFromElementWithCSS(String css);

    String getTextFromElementWithCSS(String css, int waitTime);
}
