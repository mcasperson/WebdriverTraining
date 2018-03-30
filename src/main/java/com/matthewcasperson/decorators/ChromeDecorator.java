package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDecorator extends AutomatedBrowserDecorator {
    public ChromeDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public void init() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("allow-running-insecure-content");
        options.merge(getDesiredCapabilities());
        final WebDriver webDriver = new ChromeDriver(options);
        automatedBrowser.setWebDriver(webDriver);
        automatedBrowser.init();
    }
}
