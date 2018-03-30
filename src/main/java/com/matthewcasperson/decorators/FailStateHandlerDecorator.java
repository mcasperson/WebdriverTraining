package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.decoratorbase.AutomatedBrowserDecorator;
import com.matthewcasperson.exceptions.BrowserInFailedStateException;

public class FailStateHandlerDecorator extends AutomatedBrowserDecorator {
    private boolean failedState = false;

    public FailStateHandlerDecorator(AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public boolean getBrowserFailedState() {
        return failedState;
    }

    @Override
    public void setBrowserFailedState(boolean failedState) {
        this.failedState = failedState;
    }

    @Override
    public void goTo(String url) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().goTo(url);
    }

    @Override
    public void maximizeWindow() {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().maximizeWindow();
    }

    @Override
    public void clickElementWithId(String id) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickElementWithId(id);
    }

    @Override
    public void clickElementWithId(String id, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickElementWithId(id, waitTime);
    }

    @Override
    public void clickElementWithXPath(String xpath) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickElementWithXPath(xpath);
    }

    @Override
    public void clickElementWithXPath(String xpath, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickElementWithXPath(xpath, waitTime);
    }

    @Override
    public void clickElementWithCSS(String css) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickElementWithCSS(css);
    }

    @Override
    public void clickElementWithCSS(String css, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickElementWithCSS(css, waitTime);
    }

    @Override
    public void clickLinkWithText(String text) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickLinkWithText(text);
    }

    @Override
    public void clickLinkWithText(String text, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().clickLinkWithText(text, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String optionText, String id) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().selectOptionByTextFromSelectWithId(optionText, id);
    }

    @Override
    public void selectOptionByTextFromSelectWithId(String optionText, String id, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().selectOptionByTextFromSelectWithId(optionText, id, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String optionText, String xpath) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(optionText, xpath);
    }

    @Override
    public void selectOptionByTextFromSelectWithXPath(String optionText, String xpath, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().selectOptionByTextFromSelectWithXPath(optionText, xpath, waitTime);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String optionText, String css) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(optionText, css);
    }

    @Override
    public void selectOptionByTextFromSelectWithCSS(String optionText, String css, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().selectOptionByTextFromSelectWithCSS(optionText, css, waitTime);
    }

    @Override
    public void populateElementWithId(String id, String text) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().populateElementWithId(id, text);
    }

    @Override
    public void populateElementWithId(String id, String text, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().populateElementWithId(id, text, waitTime);
    }

    @Override
    public void populateElementWithXPath(String xpath, String text) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().populateElementWithXPath(xpath, text);
    }

    @Override
    public void populateElementWithXPath(String xpath, String text, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().populateElementWithXPath(xpath, text, waitTime);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().populateTextBoxWithCSS(css, text);
    }

    @Override
    public void populateTextBoxWithCSS(String css, String text, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        getAutomatedBrowser().populateTextBoxWithCSS(css, text, waitTime);
    }

    @Override
    public String getTextFromElementWithId(String id) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        return getAutomatedBrowser().getTextFromElementWithId(id);
    }

    @Override
    public String getTextFromElementWithId(String id, int wait) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        return getAutomatedBrowser().getTextFromElementWithId(id, wait);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        return getAutomatedBrowser().getTextFromElementWithXPath(xpath);
    }

    @Override
    public String getTextFromElementWithXPath(String xpath, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        return getAutomatedBrowser().getTextFromElementWithXPath(xpath, waitTime);
    }

    @Override
    public String getTextFromElementWithCSS(String css) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        return getAutomatedBrowser().getTextFromElementWithCSS(css);
    }

    @Override
    public String getTextFromElementWithCSS(String css, int waitTime) {
        if (failedState) {
            throw new BrowserInFailedStateException();
        }

        return getAutomatedBrowser().getTextFromElementWithCSS(css, waitTime);
    }
}
