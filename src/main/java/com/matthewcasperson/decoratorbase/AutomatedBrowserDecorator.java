package com.matthewcasperson.decoratorbase;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutomatedBrowserDecorator implements AutomatedBrowser {
    private AutomatedBrowser automatedBrowser;

    public AutomatedBrowserDecorator() {

    }

    public AutomatedBrowserDecorator(AutomatedBrowser automatedBrowser) {
        this.setAutomatedBrowser(automatedBrowser);
    }

    public AutomatedBrowser getAutomatedBrowser() {
        return automatedBrowser;
    }

    public void setAutomatedBrowser(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    @Override
    public WebDriver getWebDriver() {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getWebDriver();
        }

        return null;
    }

    @Override
    public void setWebDriver(WebDriver webDriver) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().setWebDriver(webDriver);
        }
    }

    @Override
    public void init() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().init();
        }
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return getAutomatedBrowser().getDesiredCapabilities();
    }

    @Given("I open the browser \"(.*?)\"")
    public void openBrowser(String browser) {
        setAutomatedBrowser(new AutomatedBrowserFactory().getAutomatedBrowser(browser));
        getAutomatedBrowser().init();
    }

    @Given("I close the browser")
    public void closeBrowser() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().destroy();
            setAutomatedBrowser(null);
        }
    }

    @And("I open the url \"(.*?)\"")
    @Override
    public void goTo(String url) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().goTo(url);
        }
    }

    @Override
    public void clickElementWithId(String testbutton) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithId(testbutton);
        }

    }

    @Override
    public void clickElementWithId(String id, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithId(id, waitTime);
        }
    }

    @Override
    public String getTextFromElementWithId(String message) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithId(message);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithId(String id, int waitTime) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithId(id, waitTime);
        }

        return null;
    }

    @Override
    public void destroy() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().destroy();
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String selectId, String optionText) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithId(selectId, optionText);
        }
    }

    @Override
    public void maximizeWindow() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().maximizeWindow();
        }
    }

    @Override
    public void populateTextBoxWithId(String id, String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateTextBoxWithId(id, text);
        }
    }

    @Override
    public void populateTextBoxWithId(String id, String text, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateTextBoxWithId(id, text, waitTime);
        }
    }

    @Override
    public void clickLinkWithText(String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickLinkWithText(text);
        }
    }

    @Override
    public void clickLinkWithText(String text, int wait) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickLinkWithText(text, wait);
        }
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithXPath(xpath);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String id, String optionText, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithId(id, optionText, waitTime);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(xpath, optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(xpath, optionText, waitTime);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(css, optionText);
        }
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(css, optionText, waitTime);
        }
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithXPath(xpath, waitTime);
        }
    }

    @Override
    public void clickElementWithCSS(String css) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithCSS(css);
        }
    }

    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithCSS(css, waitTime);
        }
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateTextBoxWithXPath(xpath, text);
        }
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateTextBoxWithXPath(xpath, text, waitTime);
        }
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateTextBoxWithCSS(css, text);
        }
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateTextBoxWithCSS(css, text, waitTime);
        }
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithXPath(xpath);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithXPath(String xpath, int waitTime) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithXPath(xpath, waitTime);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithCSS(String css) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithCSS(css);
        }

        return null;
    }

    @Override
    public String getTextFromElementWithCSS(String css, int waitTime) {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getTextFromElementWithCSS(css, waitTime);
        }

        return null;
    }

    @Override
    public void alterRequestTo(String url, int responseCode) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().alterRequestTo(url, responseCode);
        }
    }

    @Override
    public void captureHarFile() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().captureHarFile();
        }
    }

    @Override
    public void saveHarFile(String file) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().saveHarFile(file);
        }
    }
}
