package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.decoratorbase.AutomatedBrowserDecorator;

public class StepWaitDecorator extends AutomatedBrowserDecorator {

    private static final int SLEEP = 2000;

    public StepWaitDecorator(AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    private void sleep() {
        try {
            Thread.sleep(SLEEP);
        } catch (final InterruptedException ex) {
            // ignored
        }
    }

    @Override
    public void clickElementWithId(String testbutton) {
        sleep();
        getAutomatedBrowser().clickElementWithId(testbutton);

    }

    @Override
    public void clickElementWithId(String id, int waitTime) {
        sleep();
        getAutomatedBrowser().clickElementWithId(id, waitTime);
    }

    @Override
    public String getTextFromElementWithId(String message) {
        sleep();
        return getAutomatedBrowser().getTextFromElementWithId(message);


    }

    @Override
    public String getTextFromElementWithId(String id, int waitTime) {
        sleep();
        return getAutomatedBrowser().getTextFromElementWithId(id, waitTime);


    }

    @Override
    public void destroy() {
        sleep();
        getAutomatedBrowser().destroy();
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String selectId, String optionText) {
        sleep();
        getAutomatedBrowser().selectOptionByTextFromSelectWithId(selectId, optionText);
    }

    @Override
    public void maximizeWindow() {
        sleep();
        getAutomatedBrowser().maximizeWindow();
    }

    @Override
    public void populateElementWithId(String id, String text) {
        sleep();
        getAutomatedBrowser().populateElementWithId(id, text);
    }

    @Override
    public void populateElementWithId(String id, String text, int waitTime) {
        sleep();
        getAutomatedBrowser().populateElementWithId(id, text, waitTime);
    }

    @Override
    public void clickLinkWithText(String text) {
        sleep();
        getAutomatedBrowser().clickLinkWithText(text);
    }

    @Override
    public void clickLinkWithText(String text, int wait) {
        sleep();
        getAutomatedBrowser().clickLinkWithText(text, wait);
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        sleep();
        getAutomatedBrowser().clickElementWithXPath(xpath);
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String id, String optionText, int waitTime) {
        sleep();
        getAutomatedBrowser().selectOptionByTextFromSelectWithId(id, optionText, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText) {
        sleep();
        getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(xpath, optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText, int waitTime) {
        sleep();
        getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(xpath, optionText, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText) {
        sleep();
        getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(css, optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText, int waitTime) {
        sleep();
        getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(css, optionText, waitTime);
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        sleep();
        getAutomatedBrowser().clickElementWithXPath(xpath, waitTime);
    }

    @Override
    public void clickElementWithCSS(String css) {
        sleep();
        getAutomatedBrowser().clickElementWithCSS(css);
    }

    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        sleep();
        getAutomatedBrowser().clickElementWithCSS(css, waitTime);
    }

    @Override
    public void populateElementWithXPath(String xpath, String text) {
        sleep();
        getAutomatedBrowser().populateElementWithXPath(xpath, text);
    }

    @Override
    public void populateElementWithXPath(String xpath, String text, int waitTime) {
        sleep();
        getAutomatedBrowser().populateElementWithXPath(xpath, text, waitTime);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        sleep();
        getAutomatedBrowser().populateTextBoxWithCSS(css, text);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text, int waitTime) {
        sleep();
        getAutomatedBrowser().populateTextBoxWithCSS(css, text, waitTime);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        sleep();
        return getAutomatedBrowser().getTextFromElementWithXPath(xpath);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath, int waitTime) {
        sleep();
        return getAutomatedBrowser().getTextFromElementWithXPath(xpath, waitTime);
    }

    @Override
    public String getTextFromElementWithCSS(String css) {
        sleep();
        return getAutomatedBrowser().getTextFromElementWithCSS(css);
    }

    @Override
    public String getTextFromElementWithCSS(String css, int waitTime) {
        sleep();
        return getAutomatedBrowser().getTextFromElementWithCSS(css, waitTime);
    }

    @Override
    public void alterRequestTo(String url, int responseCode) {
        sleep();
        getAutomatedBrowser().alterRequestTo(url, responseCode);
    }

    @Override
    public void captureHarFile() {
        sleep();
        getAutomatedBrowser().captureHarFile();
    }

    @Override
    public void saveHarFile(String file) {
        sleep();
        getAutomatedBrowser().saveHarFile(file);
    }
}
