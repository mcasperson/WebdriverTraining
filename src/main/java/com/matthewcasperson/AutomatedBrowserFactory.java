package com.matthewcasperson;

import com.matthewcasperson.decorators.BrowserStackDecorator;
import com.matthewcasperson.decorators.BrowserStackEdgeDecorator;
import com.matthewcasperson.decorators.ChromeDecorator;

public class AutomatedBrowserFactory {
    public AutomatedBrowser getAutomatedBrowser(String browser) {
        if ("Chrome".equalsIgnoreCase(browser)) {
            return getChromeBrowser();
        }

        if ("BrowserStackEdge".equalsIgnoreCase(browser)) {
            return getBrowserStackBrowser();
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
}
