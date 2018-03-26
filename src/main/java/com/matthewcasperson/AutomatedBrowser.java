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
}
