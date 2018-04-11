package academy.learnprogramming;

import academy.learnprogramming.decorators.ChromeDecorator;
import academy.learnprogramming.decorators.FirefoxDecorator;
import academy.learnprogramming.decorators.WebDriverDecorator;

public class AutomatedBrowserFactory {
    public AutomatedBrowser getAutomatedBrowser(String browser) {
        if ("Chrome".equalsIgnoreCase(browser)) {
            return getChromeBrowser();
        }

        if ("Firefox".equalsIgnoreCase(browser)) {
            return getFirefoxBrowser();
        }

        throw new IllegalArgumentException("Unknown browser " + browser);
    }

    private AutomatedBrowser getChromeBrowser() {
        return new ChromeDecorator(
                new WebDriverDecorator()
        );
    }

    private AutomatedBrowser getFirefoxBrowser() {
        return new FirefoxDecorator(
                new WebDriverDecorator()
        );
    }
}
