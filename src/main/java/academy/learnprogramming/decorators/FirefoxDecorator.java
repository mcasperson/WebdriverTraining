package academy.learnprogramming.decorators;

import academy.learnprogramming.AutomatedBrowser;
import academy.learnprogramming.decoratorbase.AutomatedBrowserBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDecorator extends AutomatedBrowserBase {
    public FirefoxDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public void init() {
        final FirefoxOptions options = new FirefoxOptions();
        options.merge(getDesiredCapabilities());
        final WebDriver webDriver = new FirefoxDriver(options);
        getAutomatedBrowser().setWebDriver(webDriver);
        getAutomatedBrowser().init();
    }
}