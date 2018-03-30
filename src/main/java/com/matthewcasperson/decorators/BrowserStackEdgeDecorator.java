package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.decoratorbase.AutomatedBrowserDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackEdgeDecorator extends AutomatedBrowserDecorator {
    public BrowserStackEdgeDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        final DesiredCapabilities desiredCapabilities = getAutomatedBrowser().getDesiredCapabilities();
        desiredCapabilities.setCapability("browser", "Edge");
        desiredCapabilities.setCapability("browser_version", "insider preview");
        desiredCapabilities.setCapability("os", "Windows");
        desiredCapabilities.setCapability("os_version", "10");
        desiredCapabilities.setCapability("resolution", "1920x1080");
        return desiredCapabilities;
    }
}
