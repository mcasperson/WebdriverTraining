package com.matthewcasperson;

import org.openqa.selenium.WebDriver;

public interface AutomatedBrowser {
    void setWebDriver(WebDriver webDriver);
    WebDriver getWebDriver();

    void init();

    void goTo(String testFormUrl);

    void clickElementWithId(String testbutton);

    String getTextFromElementWithId(String message);

    void destroy();
}
