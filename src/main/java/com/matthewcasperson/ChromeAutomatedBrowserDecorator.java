package com.matthewcasperson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeAutomatedBrowserDecorator extends AutomatedBrowserDecorator {
    public ChromeAutomatedBrowserDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public void init() {
        if (automatedBrowser != null) {
            final WebDriver webDriver = new ChromeDriver();
            automatedBrowser.setWebDriver(webDriver);
        }
    }
}
