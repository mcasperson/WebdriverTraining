package com.matthewcasperson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.base.Preconditions.checkNotNull;

public class AutomatedBrowserImpl implements AutomatedBrowser {
    private WebDriver webDriver;

    @Override
    public void setWebDriver(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    public void init() {
        // this is implemented by a decorator
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return new DesiredCapabilities();
    }

    @Override
    public void goTo(final String url) {
        checkNotNull(webDriver);
        checkNotNull(url);

        webDriver.get(url);
    }

    @Override
    public void clickElementWithId(final String id) {
        checkNotNull(webDriver);
        checkNotNull(id);

        webDriver.findElement(By.id(id)).click();
    }

    @Override
    public void clickElementWithId(String id, int waitTime) {
        if (waitTime <= 0) {
            clickElementWithId(id);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.id(id)))).click();
        }
    }

    @Override
    public String getTextFromElementWithId(final String id) {
        checkNotNull(webDriver);
        checkNotNull(id);

        return webDriver.findElement(By.id(id)).getText();
    }

    @Override
    public String getTextFromElementWithId(String id, int wait) {
        return null;
    }

    @Override
    public void destroy() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String id, String optionText) {
        new Select(webDriver.findElement(By.id(id))).selectByVisibleText(optionText);
    }

    @Override
    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    @Override
    public void populateTextBoxWithId(String id, String text) {
        webDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Override
    public void populateTextBoxWithId(String id, String text, int waitTime) {

    }

    @Override
    public void clickLinkWithText(String text) {
        webDriver.findElement(By.linkText(text)).click();
    }

    @Override
    public void clickLinkWithText(String text, int waitTime) {
        if (waitTime <= 0) {
            clickLinkWithText(text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.linkText(text)))).click();
        }
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String id, String optionText, int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithId(id, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.id(id))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText) {
        new Select(webDriver.findElement(By.xpath(xpath))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText, int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithXPath(xpath, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText) {
        new Select(webDriver.findElement(By.cssSelector(css))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText, int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithCSS(css, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(css))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        if (waitTime <= 0) {
            clickElementWithXPath(xpath);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath)))).click();
        }
    }

    @Override
    public void clickElementWithCSS(String css) {
        webDriver.findElement(By.cssSelector(css)).click();
    }

    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        if (waitTime <= 0) {
            clickElementWithCSS(css);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(css)))).click();
        }
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text, int waitTime) {
        if (waitTime <= 0) {
            populateTextBoxWithXPath(xpath, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath)))).sendKeys(text);
        }
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        webDriver.findElement(By.cssSelector(css)).sendKeys(text);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text, int waitTime) {
        if (waitTime <= 0) {
            populateTextBoxWithCSS(css, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(css)))).sendKeys(text);
        }
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }

    @Override
    public String getTextFromElementWithXPath(String xpath, int waitTime) {
        if (waitTime <= 0) {
            return getTextFromElementWithXPath(xpath);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            return wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath)))).getText();
        }
    }

    @Override
    public String getTextFromElementWithCSS(String css) {
        return webDriver.findElement(By.cssSelector(css)).getText();
    }

    @Override
    public String getTextFromElementWithCSS(String css, int waitTime) {
        if (waitTime <= 0) {
            return getTextFromElementWithCSS(css);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            return wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(css)))).getText();
        }
    }
}
