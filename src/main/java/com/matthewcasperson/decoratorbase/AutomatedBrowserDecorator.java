package com.matthewcasperson.decoratorbase;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutomatedBrowserDecorator implements AutomatedBrowser {
    protected AutomatedBrowser automatedBrowser;

    public AutomatedBrowserDecorator() {

    }

    public AutomatedBrowserDecorator(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    @Override
    public WebDriver getWebDriver() {
        if (automatedBrowser != null) {
            return automatedBrowser.getWebDriver();
        }

        return null;
    }

    @Override
    public void setWebDriver(WebDriver webDriver) {
        if (automatedBrowser != null) {
            automatedBrowser.setWebDriver(webDriver);
        }
    }

    @Override
    public void init() {
        if (automatedBrowser != null) {
            automatedBrowser.init();
        }
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return automatedBrowser.getDesiredCapabilities();
    }

    @Given("I open the browser \"(.*?)\"")
    public void openBrowser(String browser) {
        automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        automatedBrowser.init();
    }

    @Given("I close the browser")
    public void closeBrowser() {
        if (automatedBrowser != null) {
            automatedBrowser.destroy();
            automatedBrowser = null;
        }
    }

    @And("I open the url \"(.*?)\"")
    @Override
    public void goTo(String url) {
        if (automatedBrowser != null) {
            automatedBrowser.goTo(url);
        }
    }

    @Override
    public void clickElementWithId(String testbutton) {
        if (automatedBrowser != null) {
            automatedBrowser.clickElementWithId(testbutton);
        }

    }

    @Override
    public void clickElementWithId(String id, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.clickElementWithId(id, waitTime);
        }
    }

    @Override
    public String getTextFromElementWithId(String message) {
        if (automatedBrowser != null) {
            return automatedBrowser.getTextFromElementWithId(message);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithId(String id, int waitTime) {
        if (automatedBrowser != null) {
            return automatedBrowser.getTextFromElementWithId(id, waitTime);
        }

        return null;
    }

    @Override
    public void destroy() {
        if (automatedBrowser != null) {
            automatedBrowser.destroy();
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String selectId, String optionText) {
        if (automatedBrowser != null) {
            automatedBrowser.selectOptionByTextFromSelectWithId(selectId, optionText);
        }
    }

    @Override
    public void maximizeWindow() {
        if (automatedBrowser != null) {
            automatedBrowser.maximizeWindow();
        }
    }

    @Override
    public void populateTextBoxWithId(String id, String text) {
        if (automatedBrowser != null) {
            automatedBrowser.populateTextBoxWithId(id, text);
        }
    }

    @Override
    public void populateTextBoxWithId(String id, String text, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.populateTextBoxWithId(id, text, waitTime);
        }
    }

    @Override
    public void clickLinkWithText(String text) {
        if (automatedBrowser != null) {
            automatedBrowser.clickLinkWithText(text);
        }
    }

    @Override
    public void clickLinkWithText(String text, int wait) {
        if (automatedBrowser != null) {
            automatedBrowser.clickLinkWithText(text, wait);
        }
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        if (automatedBrowser != null) {
            automatedBrowser.clickElementWithXPath(xpath);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String id, String optionText, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.selectOptionByTextFromSelectWithId(id, optionText, waitTime);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText) {
        if (automatedBrowser != null) {
            automatedBrowser.selectOptionByTextFromSelectWithXPath(xpath, optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.selectOptionByTextFromSelectWithXPath(xpath, optionText, waitTime);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText) {
        if (automatedBrowser != null) {
            automatedBrowser.selectOptionByTextFromSelectWithCSS(css, optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.selectOptionByTextFromSelectWithCSS(css, optionText, waitTime);
        }
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.clickElementWithXPath(xpath, waitTime);
        }
    }

    @Override
    public void clickElementWithCSS(String css) {
        if (automatedBrowser != null) {
            automatedBrowser.clickElementWithCSS(css);
        }
    }

    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.clickElementWithCSS(css, waitTime);
        }
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text) {
        if (automatedBrowser != null) {
            automatedBrowser.populateTextBoxWithXPath(xpath, text);
        }
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.populateTextBoxWithXPath(xpath, text, waitTime);
        }
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        if (automatedBrowser != null) {
            automatedBrowser.populateTextBoxWithCSS(css, text);
        }
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text, int waitTime) {
        if (automatedBrowser != null) {
            automatedBrowser.populateTextBoxWithCSS(css, text, waitTime);
        }
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        if (automatedBrowser != null) {
            return automatedBrowser.getTextFromElementWithXPath(xpath);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithXPath(String xpath, int waitTime) {
        if (automatedBrowser != null) {
            return automatedBrowser.getTextFromElementWithXPath(xpath, waitTime);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithCSS(String css) {
        if (automatedBrowser != null) {
            return automatedBrowser.getTextFromElementWithCSS(css);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithCSS(String css, int waitTime) {
        if (automatedBrowser != null) {
            return automatedBrowser.getTextFromElementWithCSS(css, waitTime);
        }

        return null;
    }

    @Override
    public void alterRequestTo(String url, int responseCode) {
        if (automatedBrowser != null) {
            automatedBrowser.alterRequestTo(url, responseCode);
        }
    }

    @Override
    public void captureHarFile() {
        if (automatedBrowser != null) {
            automatedBrowser.captureHarFile();
        }
    }

    @Override
    public void saveHarFile(String file) {
        if (automatedBrowser != null) {
            automatedBrowser.saveHarFile(file);
        }
    }
}
