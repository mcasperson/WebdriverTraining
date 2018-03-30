package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.decoratorbase.AutomatedBrowserDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadlessDecorator extends AutomatedBrowserDecorator {
    public FirefoxHeadlessDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public void init() {
        final FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");
        options.merge(getDesiredCapabilities());
        final WebDriver webDriver = new FirefoxDriver(options);
        automatedBrowser.setWebDriver(webDriver);
        automatedBrowser.init();
    }
}
