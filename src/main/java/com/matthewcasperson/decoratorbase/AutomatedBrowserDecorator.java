package com.matthewcasperson.decoratorbase;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutomatedBrowserDecorator implements AutomatedBrowser {
    static private AutomatedBrowser sharedAutomatedBrowser;
    private AutomatedBrowser automatedBrowser;

    public AutomatedBrowserDecorator() {

    }

    public AutomatedBrowserDecorator(AutomatedBrowser automatedBrowser) {
        this.setAutomatedBrowser(automatedBrowser);
    }

    public AutomatedBrowser getAutomatedBrowser() {
        if (this.getClass().equals(AutomatedBrowserDecorator.class)) {
            return sharedAutomatedBrowser;
        }
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
    public boolean getBrowserFailedState() {
        if (getAutomatedBrowser() != null) {
            return getAutomatedBrowser().getBrowserFailedState();
        }

        return false;
    }

    @Override
    public void setBrowserFailedState(boolean failedState) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().setBrowserFailedState(failedState);
        }
    }

    @Override
    public void init() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().init();
        }
    }

    @Override
    public void destroy() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().destroy();
        }
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return getAutomatedBrowser().getDesiredCapabilities();
    }

    @Given("I open the browser \"(.*?)\"")
    public void openBrowser(String browser) {
        sharedAutomatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        sharedAutomatedBrowser.init();
    }

    @Given("I close the browser")
    public void closeBrowser() {
        if (sharedAutomatedBrowser != null) {
            sharedAutomatedBrowser.destroy();
            sharedAutomatedBrowser = null;
        }
    }

    @And("^I open the url \"(.*?)\"$")
    @Override
    public void goTo(String url) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().goTo(url);
        }
    }

    @And("^I click the element with the id \"(.*?)\"$")
    @Override
    public void clickElementWithId(String elementId) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithId(elementId);
        }

    }

    @And("^I click the element with the id \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
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

    @And("^I select option \"(.*?)\" from the drop down list with the id \"(.*?)\"$")
    @Override
    public void selectOptionByTextFromSelectWithId(String optionText, String selectId) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithId(optionText, selectId);
        }
    }

    @And("^I maximize the window$")
    @Override
    public void maximizeWindow() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().maximizeWindow();
        }
    }

    @And("^I populate the element with the id \"(.*?)\" with the text \"(.*?)\"$")
    @Override
    public void populateElementWithId(String id, String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithId(id, text);
        }
    }

    @And("^I populate the element with the id \"(.*?)\" with the text \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void populateElementWithId(String id, String text, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithId(id, text, waitTime);
        }
    }

    @And("^I click the link with the text \"(.*?)\"$")
    @Override
    public void clickLinkWithText(String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickLinkWithText(text);
        }
    }

    @And("^I click the link with the text \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void clickLinkWithText(String text, int wait) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickLinkWithText(text, wait);
        }
    }

    @And("^I click the element with the xpath \"(.*?)\"$")
    @Override
    public void clickElementWithXPath(String xpath) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithXPath(xpath);
        }
    }

    @And("^I select option \"(.*?)\" from the drop down list with the id \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void selectOptionByTextFromSelectWithId(String optionText, String id, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithId(optionText, id, waitTime);
        }
    }

    @And("^I select option \"(.*?)\" from the drop down list with the xpath \"(.*?)\"$")
    @Override
    public void selectOptionByTextFromSelectWithXPath(String optionText, String xpath) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(optionText, xpath);
        }
    }

    @And("^I select option \"(.*?)\" from the drop down list with the xpath \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void selectOptionByTextFromSelectWithXPath(String optionText, String xpath, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(optionText, xpath, waitTime);
        }
    }

    @And("^I select option \"(.*?)\" from the drop down list with the css selector \"(.*?)\"$")
    @Override
    public void selectOptionByTextFromSelectWithCSS(String optionText, String css) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(optionText, css);
        }
    }

    @And("^I select option \"(.*?)\" from the drop down list with the css selector \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void selectOptionByTextFromSelectWithCSS(String optionText, String css, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(optionText, css, waitTime);
        }
    }

    @And("^I click the element with the xpath \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithXPath(xpath, waitTime);
        }
    }

    @And("^I click the element with the css selector \"(.*?)\"$")
    @Override
    public void clickElementWithCSS(String css) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithCSS(css);
        }
    }

    @And("^I click the element with the css selector \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().clickElementWithCSS(css, waitTime);
        }
    }

    @And("^I populate the element with the xpath \"(.*?)\" with the text \"(.*?)\"$")
    @Override
    public void populateElementWithXPath(String xpath, String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithXPath(xpath, text);
        }
    }

    @And("^I populate the element with the xpath \"(.*?)\" with the text \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void populateElementWithXPath(String xpath, String text, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateElementWithXPath(xpath, text, waitTime);
        }
    }

    @And("^I populate the element with the css selector \"(.*?)\" with the text \"(.*?)\"$")
    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().populateTextBoxWithCSS(css, text);
        }
    }

    @And("^I populate the element with the css selector \"(.*?)\" with the text \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
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

    @Then("^I verify the text from the element with the id \"(.*?)\" equals \"(.*?)\"$")
    @Override
    public void verifyTextFromElementWithIdEquals(String id, String expected) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithIdEquals(id, expected);
        }
    }

    @Then("^I verify the text from the element with the id \"(.*?)\" equals \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void verifyTextFromElementWithIdEquals(String id, String expected, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithIdEquals(id, expected, waitTime);
        }
    }

    @Then("^I verify the text from the element with the xpath \"(.*?)\" equals \"(.*?)\"$")
    @Override
    public void verifyTextFromElementWithXPathEquals(String xpath, String expected) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithXPathEquals(xpath, expected);
        }
    }

    @Then("^I verify the text from the element with the xpath \"(.*?)\" equals \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void verifyTextFromElementWithXPathEquals(String xpath, String expected, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithXPathEquals(xpath, expected, waitTime);
        }
    }

    @Then("^I verify the text from the element with the css selector \"(.*?)\" equals \"(.*?)\"$")
    @Override
    public void verifyTextFromElementWithCSSEquals(String css, String expected) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithCSSEquals(css, expected);
        }
    }

    @Then("^I verify the text from the element with the css selector \"(.*?)\" equals \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void verifyTextFromElementWithCSSEquals(String css, String expected, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithCSSEquals(css, expected, waitTime);
        }
    }

    @Then("^I verify the text from the element with the id \"(.*?)\" contains \"(.*?)\"$")
    @Override
    public void verifyTextFromElementWithIdContains(String id, String expected) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithIdContains(id, expected);
        }
    }

    @Then("^I verify the text from the element with the id \"(.*?)\" contains \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void verifyTextFromElementWithIdContains(String id, String expected, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithIdContains(id, expected, waitTime);
        }
    }

    @Then("^I verify the text from the element with the xpath \"(.*?)\" contains \"(.*?)\"$")
    @Override
    public void verifyTextFromElementWithXPathContains(String xpath, String expected) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithXPathContains(xpath, expected);
        }
    }

    @Then("^I verify the text from the element with the xpath \"(.*?)\" contains \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void verifyTextFromElementWithXPathContains(String xpath, String expected, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithXPathContains(xpath, expected, waitTime);
        }
    }

    @Then("^I verify the text from the element with the css selector \"(.*?)\" contains \"(.*?)\"$")
    @Override
    public void verifyTextFromElementWithCSSContains(String css, String expected) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithCSSContains(css, expected);
        }
    }

    @Then("^I verify the text from the element with the css selector \"(.*?)\" contains \"(.*?)\" waiting up to \"(\\d+)\" seconds$")
    @Override
    public void verifyTextFromElementWithCSSContains(String css, String expected, int waitTime) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().verifyTextFromElementWithCSSContains(css, expected, waitTime);
        }
    }

    @And("^I alter requests to urls matching the regex \"(.*?)\" by returning the http code \"(\\d+)\"$")
    @Override
    public void alterRequestTo(String url, int responseCode) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().alterRequestTo(url, responseCode);
        }
    }

    @And("^I start capturing a HAR file$")
    @Override
    public void captureHarFile() {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().captureHarFile();
        }
    }

    @And("^I save the HAR file to \"(.*?)\"$")
    @Override
    public void saveHarFile(String file) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().saveHarFile(file);
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (getAutomatedBrowser() != null) {
            getAutomatedBrowser().setBrowserFailedState(scenario.isFailed());
        }
    }
}
