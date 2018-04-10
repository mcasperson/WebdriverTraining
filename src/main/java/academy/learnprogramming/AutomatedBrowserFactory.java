package academy.learnprogramming;

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
        return null;
    }

    private AutomatedBrowser getFirefoxBrowser() {
        return null;
    }
}
