package academy.learnprogramming.decorators;

import academy.learnprogramming.AutomatedBrowser;
import academy.learnprogramming.decoratorbase.AutomatedBrowserBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverDecorator extends AutomatedBrowserBase {
    private WebDriver webDriver;

    public WebDriverDecorator() {

    }

    public WebDriverDecorator(AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void destroy() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Override
    public void goTo(final String url) {
        webDriver.get(url);
    }

    @Override
    public void clickElementWithId(final String id) {
        webDriver.findElement(By.id(id)).click();
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String optionText, String selectId) {
        new Select(webDriver.findElement(By.id(selectId))).selectByVisibleText(optionText);
    }

    @Override
    public void populateElementWithId(String id, String text) {
        webDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Override
    public String getTextFromElementWithId(final String id) {
        return webDriver.findElement(By.id(id)).getText();
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String optionText, String xpath) {
        new Select(webDriver.findElement(By.xpath(xpath))).selectByVisibleText(optionText);
    }

    @Override
    public void populateElementWithXPath(String xpath, String text) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }

    @Override
    public void clickElementWithCSSSelector(String cssSelector) {
        webDriver.findElement(By.cssSelector(cssSelector)).click();
    }

    @Override
    public void selectOptionByTextFromSelectWithCSSSelector(String optionText, String cssSelector) {
        new Select(webDriver.findElement(By.cssSelector(cssSelector))).selectByVisibleText(optionText);
    }

    @Override
    public void populateElementWithCSSSelector(String cssSelector, String text) {
        webDriver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    @Override
    public String getTextFromElementWithCSSSelector(String cssSelector) {
        return webDriver.findElement(By.cssSelector(cssSelector)).getText();
    }
}
