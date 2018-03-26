package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackIPhoneDecorator extends AutomatedBrowserDecorator {
    public BrowserStackIPhoneDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        final DesiredCapabilities desiredCapabilities = automatedBrowser.getDesiredCapabilities();
        desiredCapabilities.setCapability("browserName", "iPhone");
        desiredCapabilities.setCapability("device", "iPhone 7");
        desiredCapabilities.setCapability("realMobile", "true");
        desiredCapabilities.setCapability("os_version", "10.3");
        return desiredCapabilities;
    }
}
