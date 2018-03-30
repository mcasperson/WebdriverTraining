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
        automatedBrowser.clickElementWithId(testbutton);

    }

    @Override
    public void clickElementWithId(String id, int waitTime) {
        sleep();
        automatedBrowser.clickElementWithId(id, waitTime);
    }

    @Override
    public String getTextFromElementWithId(String message) {
        sleep();
        return automatedBrowser.getTextFromElementWithId(message);


    }

    @Override
    public String getTextFromElementWithId(String id, int waitTime) {
        sleep();
        return automatedBrowser.getTextFromElementWithId(id, waitTime);


    }

    @Override
    public void destroy() {
        sleep();
        automatedBrowser.destroy();
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String selectId, String optionText) {
        sleep();
        automatedBrowser.selectOptionByTextFromSelectWithId(selectId, optionText);
    }

    @Override
    public void maximizeWindow() {
        sleep();
        automatedBrowser.maximizeWindow();
    }

    @Override
    public void populateTextBoxWithId(String id, String text) {
        sleep();
        automatedBrowser.populateTextBoxWithId(id, text);
    }

    @Override
    public void populateTextBoxWithId(String id, String text, int waitTime) {
        sleep();
        automatedBrowser.populateTextBoxWithId(id, text, waitTime);
    }

    @Override
    public void clickLinkWithText(String text) {
        sleep();
        automatedBrowser.clickLinkWithText(text);
    }

    @Override
    public void clickLinkWithText(String text, int wait) {
        sleep();
        automatedBrowser.clickLinkWithText(text, wait);
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        sleep();
        automatedBrowser.clickElementWithXPath(xpath);
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String id, String optionText, int waitTime) {
        sleep();
        automatedBrowser.selectOptionByTextFromSelectWithId(id, optionText, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText) {
        sleep();
        automatedBrowser.selectOptionByTextFromSelectWithXPath(xpath, optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String xpath, String optionText, int waitTime) {
        sleep();
        automatedBrowser.selectOptionByTextFromSelectWithXPath(xpath, optionText, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText) {
        sleep();
        automatedBrowser.selectOptionByTextFromSelectWithCSS(css, optionText);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String css, String optionText, int waitTime) {
        sleep();
        automatedBrowser.selectOptionByTextFromSelectWithCSS(css, optionText, waitTime);
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        sleep();
        automatedBrowser.clickElementWithXPath(xpath, waitTime);
    }

    @Override
    public void clickElementWithCSS(String css) {
        sleep();
        automatedBrowser.clickElementWithCSS(css);
    }

    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        sleep();
        automatedBrowser.clickElementWithCSS(css, waitTime);
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text) {
        sleep();
        automatedBrowser.populateTextBoxWithXPath(xpath, text);
    }

    @Override
    public void populateTextBoxWithXPath(String xpath, String text, int waitTime) {
        sleep();
        automatedBrowser.populateTextBoxWithXPath(xpath, text, waitTime);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        sleep();
        automatedBrowser.populateTextBoxWithCSS(css, text);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text, int waitTime) {
        sleep();
        automatedBrowser.populateTextBoxWithCSS(css, text, waitTime);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        sleep();
        return automatedBrowser.getTextFromElementWithXPath(xpath);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath, int waitTime) {
        sleep();
        return automatedBrowser.getTextFromElementWithXPath(xpath, waitTime);
    }

    @Override
    public String getTextFromElementWithCSS(String css) {
        sleep();
        return automatedBrowser.getTextFromElementWithCSS(css);
    }

    @Override
    public String getTextFromElementWithCSS(String css, int waitTime) {
        sleep();
        return automatedBrowser.getTextFromElementWithCSS(css, waitTime);
    }

    @Override
    public void alterRequestTo(String url, int responseCode) {
        sleep();
        automatedBrowser.alterRequestTo(url, responseCode);
    }

    @Override
    public void captureHarFile() {
        sleep();
        automatedBrowser.captureHarFile();
    }

    @Override
    public void saveHarFile(String file) {
        sleep();
        automatedBrowser.saveHarFile(file);
    }
}
