package academy.learnprogramming;

import org.openqa.selenium.WebDriver;

public interface AutomatedBrowser {
    WebDriver getWebDriver();

    void setWebDriver(WebDriver webDriver);

    void init();

    void destroy();

    void goTo(String url);

    void clickElementWithId(String id);

    void selectOptionByTextFromSelectWithId(String optionText, String id);

    void populateElementWithId(String id, String text);

    String getTextFromElementWithId(String id);

    void clickElementWithXPath(String xpath);

    void selectOptionByTextFromSelectWithXPath(String optionText, String xpath);

    void populateElementWithXPath(String xpath, String text);

    String getTextFromElementWithXPath(String xpath);

    void clickElementWithCSSSelector(String cssSelector);

    void selectOptionByTextFromSelectWithCSSSelector(String optionText, String cssSelector);

    void populateElementWithCSSSelector(String cssSelector, String text);

    String getTextFromElementWithCSSSelector(String cssSelector);
}
