package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserDecorator;
import com.matthewcasperson.exceptions.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStackDecorator extends AutomatedBrowserDecorator {
    private static final String USERNAME_ENV = "BROWSERSTACK_USERNAME";
    private static final String AUTOMATE_KEY_ENV = "BROWSERSTACK_KEY";

    public BrowserStackDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public void init() {
        try {
            final String URL = "https://" + System.getenv(USERNAME_ENV) + ":" + System.getenv(AUTOMATE_KEY_ENV) + "@hub-cloud.browserstack.com/wd/hub";
            final WebDriver webDriver = new RemoteWebDriver(new URL(URL), getDesiredCapabilities());
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            automatedBrowser.setWebDriver(webDriver);
        } catch (MalformedURLException ex) {
            throw new ConfigurationException(ex);
        }
    }
}