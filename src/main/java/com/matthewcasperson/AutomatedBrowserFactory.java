package com.matthewcasperson;

import com.matthewcasperson.decorators.*;

public class AutomatedBrowserFactory {
    public AutomatedBrowser getAutomatedBrowser(String browser) {
        if ("Chrome".equalsIgnoreCase(browser)) {
            return getChromeBrowser();
        }

        if ("BrowserStackEdge".equalsIgnoreCase(browser)) {
            return getBrowserStackBrowser();
        }

        if ("BrowserStackIPhone".equalsIgnoreCase(browser)) {
            return getBrowserStackIPhone();
        }

        throw new IllegalArgumentException("Unknown browser " + browser);
    }

    private AutomatedBrowser getChromeBrowser() {
        return new ChromeDecorator(
                new AutomatedBrowserImpl()
        );
    }

    private AutomatedBrowser getBrowserStackBrowser() {
        return new BrowserStackDecorator(
                new BrowserStackEdgeDecorator(
                        new AutomatedBrowserImpl()
                )
        );
    }

    private AutomatedBrowser getBrowserStackIPhone() {
        return new BrowserStackDecorator(
                new BrowserStackIPhoneDecorator(
                        new IgnoreWindowSizeErrorsDecorator(
                                new AutomatedBrowserImpl()
                        )
                )
        );
    }
}