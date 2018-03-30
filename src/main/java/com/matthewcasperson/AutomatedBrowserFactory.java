package com.matthewcasperson;

import com.matthewcasperson.decorators.*;

public class AutomatedBrowserFactory {
    public AutomatedBrowser getAutomatedBrowser(String browser) {
        if ("Chrome".equalsIgnoreCase(browser)) {
            return getChromeBrowser();
        }

        if ("ChromeHeadless".equalsIgnoreCase(browser)) {
            return getChromeHeadlessBrowser();
        }

        if ("Firefox".equalsIgnoreCase(browser)) {
            return getFirefoxBrowser();
        }

        if ("FirefoxHeadless".equalsIgnoreCase(browser)) {
            return getFirefoxHeadlessBrowser();
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
                new ImplicitWaitDecorator(10,
                        new BrowserMobDecorator(
                                new StepWaitDecorator(
                                        new WebDriverDecorator()
                                )
                        )
                )
        );
    }

    private AutomatedBrowser getFirefoxBrowser() {
        return new FirefoxDecorator(
                new ImplicitWaitDecorator(10,
                        new BrowserMobDecorator(
                                new StepWaitDecorator(
                                        new WebDriverDecorator()
                                )
                        )
                )
        );
    }

    private AutomatedBrowser getChromeHeadlessBrowser() {
        return new ChromeHeadlessDecorator(
                new ImplicitWaitDecorator(10,
                        //new BrowserMobDecorator(
                                new WebDriverDecorator()
                        //)
                )
        );
    }

    private AutomatedBrowser getFirefoxHeadlessBrowser() {
        return new FirefoxHeadlessDecorator(
                new ImplicitWaitDecorator(10,
                        new BrowserMobDecorator(
                                new StepWaitDecorator(
                                        new WebDriverDecorator()
                                )
                        )
                )
        );
    }

    private AutomatedBrowser getBrowserStackBrowser() {
        return new BrowserStackDecorator(
                new ImplicitWaitDecorator(10,
                        new BrowserStackEdgeDecorator(
                                new WebDriverDecorator()
                        )
                )
        );
    }

    private AutomatedBrowser getBrowserStackIPhone() {
        return new BrowserStackDecorator(
                new ImplicitWaitDecorator(10,
                        new BrowserStackIPhoneDecorator(
                                new IgnoreWindowSizeErrorsDecorator(
                                        new WebDriverDecorator()
                                )
                        )
                )
        );
    }
}
