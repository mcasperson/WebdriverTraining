package academy.learnprogramming;

import academy.learnprogramming.decorators.*;

public class AutomatedBrowserFactory {
    public AutomatedBrowser getAutomatedBrowser(String browser) {
        if ("Chrome".equalsIgnoreCase(browser)) {
            return getChromeBrowser(false);
        }

        if ("ChromeHeadless".equalsIgnoreCase(browser)) {
            return getChromeBrowser(true);
        }

        if ("Firefox".equalsIgnoreCase(browser)) {
            return getFirefoxBrowser(false);
        }

        if ("FirefoxHeadless".equalsIgnoreCase(browser)) {
            return getFirefoxBrowser(true);
        }

        throw new IllegalArgumentException("Unknown browser " + browser);
    }

    private AutomatedBrowser getChromeBrowser(final boolean headless) {
        return new ChromeDecorator(headless,
                new ImplicitWaitDecorator(10,
                        new BrowserMobDecorator(
                                new WebDriverDecorator()
                        )
                )
        );
    }

    private AutomatedBrowser getFirefoxBrowser(final boolean headless) {
        return new FirefoxDecorator(headless,
                new ImplicitWaitDecorator(10,
                        new BrowserMobDecorator(
                                new WebDriverDecorator()
                        )
                )
        );
    }
}
