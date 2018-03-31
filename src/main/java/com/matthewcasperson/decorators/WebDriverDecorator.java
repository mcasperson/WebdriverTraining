package com.matthewcasperson.decorators;

import com.matthewcasperson.decoratorbase.AutomatedBrowserDecorator;
import com.matthewcasperson.exceptions.ValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDecorator extends AutomatedBrowserDecorator {
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
    public DesiredCapabilities getDesiredCapabilities() {
        return new DesiredCapabilities();
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
    public void selectOptionByTextFromSelectWithId(String optionText, String selectId) {
        new Select(webDriver.findElement(By.id(selectId))).selectByVisibleText(optionText);
    }

    @Override
    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    @Override
    public void populateElementWithId(String id, String text) {
        webDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Override
    public void populateElementWithId(String id, String text, int waitTime) {
        if (waitTime <= 0) {
            populateElementWithId(id, text);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable((By.id(id)))).sendKeys(text);
        }
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
    public void selectOptionByTextFromSelectWithId(String optionText, String id, int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithId(id, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.id(id))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String optionText, String xpath) {
        new Select(webDriver.findElement(By.xpath(xpath))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String optionText, String xpath, int waitTime) {
        if (waitTime <= 0) {
            selectOptionByTextFromSelectWithXPath(xpath, optionText);
        } else {
            final WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
            new Select(wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath))))).selectByVisibleText(optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String optionText, String css) {
        new Select(webDriver.findElement(By.cssSelector(css))).selectByVisibleText(optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String optionText, String css, int waitTime) {
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
    public void populateElementWithXPath(String xpath, String text) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Override
    public void populateElementWithXPath(String xpath, String text, int waitTime) {
        if (waitTime <= 0) {
            populateElementWithXPath(xpath, text);
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

    @Override
    public void verifyTextFromElementWithIdEquals(String id, String expected) {
        final String text = getTextFromElementWithId(id);
        if (!expected.equals(text)) {
            throw new ValidationException(text + " does not equal the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithIdEquals(String id, String expected, int wait) {
        final String text = getTextFromElementWithId(id, wait);
        if (!expected.equals(text)) {
            throw new ValidationException(text + " does not equal the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithXPathEquals(String xpath, String expected) {
        final String text = getTextFromElementWithXPath(xpath);
        if (!expected.equals(text)) {
            throw new ValidationException(text + " does not equal the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithXPathEquals(String xpath, String expected, int waitTime) {
        final String text = getTextFromElementWithXPath(xpath, waitTime);
        if (!expected.equals(text)) {
            throw new ValidationException(text + " does not equal the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithCSSEquals(String css, String expected) {
        final String text = getTextFromElementWithCSS(css);
        if (!expected.equals(text)) {
            throw new ValidationException(text + " does not equal the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithCSSEquals(String css, String expected, int waitTime) {
        final String text = getTextFromElementWithCSS(css, waitTime);
        if (!expected.equals(text)) {
            throw new ValidationException(text + " does not equal the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithIdContains(String id, String expected) {
        final String text = getTextFromElementWithId(id);
        if (!text.contains(expected)) {
            throw new ValidationException(text + " does not contain the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithIdContains(String id, String expected, int wait) {
        final String text = getTextFromElementWithId(id, wait);
        if (!text.contains(expected)) {
            throw new ValidationException(text + " does not contain the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithXPathContains(String xpath, String expected) {
        final String text = getTextFromElementWithXPath(xpath);
        if (!text.contains(expected)) {
            throw new ValidationException(text + " does not contain the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithXPathContains(String xpath, String expected, int waitTime) {
        final String text = getTextFromElementWithXPath(xpath, waitTime);
        if (!text.contains(expected)) {
            throw new ValidationException(text + " does not contain the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithCSSContains(String css, String expected) {
        final String text = getTextFromElementWithCSS(css);
        if (!text.contains(expected)) {
            throw new ValidationException(text + " does not contain the expected text " + expected);
        }
    }

    @Override
    public void verifyTextFromElementWithCSSContains(String css, String expected, int waitTime) {
        final String text = getTextFromElementWithCSS(css, waitTime);
        if (!text.contains(expected)) {
            throw new ValidationException(text + " does not contain the expected text " + expected);
        }
    }
}
