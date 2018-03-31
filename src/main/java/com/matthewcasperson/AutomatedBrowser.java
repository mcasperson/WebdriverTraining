package com.matthewcasperson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface AutomatedBrowser {
    WebDriver getWebDriver();

    void setWebDriver(WebDriver webDriver);

    boolean getBrowserFailedState();

    void setBrowserFailedState(boolean failedState);

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

    void selectOptionByTextFromSelectWithId(String optionText, String id);

    void selectOptionByTextFromSelectWithId(String optionText, String id, int waitTime);

    void selectOptionByTextFromSelectWithXPath(String optionText, String xpath);

    void selectOptionByTextFromSelectWithXPath(String optionText, String xpath, int waitTime);

    void selectOptionByTextFromSelectWithCSS(String optionText, String css);

    void selectOptionByTextFromSelectWithCSS(String optionText, String css, int waitTime);

    void populateElementWithId(String id, String text);

    void populateElementWithId(String id, String text, int waitTime);

    void populateElementWithXPath(String xpath, String text);

    void populateElementWithXPath(String xpath, String text, int waitTime);

    void populateTextBoxWithCSS(String css, String text);

    void populateTextBoxWithCSS(String css, String text, int waitTime);

    String getTextFromElementWithId(String id);

    String getTextFromElementWithId(String id, int waitTime);

    String getTextFromElementWithXPath(String xpath);

    String getTextFromElementWithXPath(String xpath, int waitTime);

    String getTextFromElementWithCSS(String css);

    String getTextFromElementWithCSS(String css, int waitTime);

    void verifyTextFromElementWithIdEquals(String id, String expected);

    void verifyTextFromElementWithIdEquals(String id, String expected, int waitTime);

    void verifyTextFromElementWithXPathEquals(String xpath, String expected);

    void verifyTextFromElementWithXPathEquals(String xpath, String expected, int waitTime);

    void verifyTextFromElementWithCSSEquals(String css, String expected);

    void verifyTextFromElementWithCSSEquals(String css, String expected, int waitTime);

    void verifyTextFromElementWithIdContains(String id, String expected);

    void verifyTextFromElementWithIdContains(String id, String expected, int waitTime);

    void verifyTextFromElementWithXPathContains(String xpath, String expected);

    void verifyTextFromElementWithXPathContains(String xpath, String expected, int waitTime);

    void verifyTextFromElementWithCSSContains(String css, String expected);

    void verifyTextFromElementWithCSSContains(String css, String expected, int waitTime);

    void alterRequestTo(String url, int responseCode);

    void captureHarFile();

    void saveHarFile(String file);
}
