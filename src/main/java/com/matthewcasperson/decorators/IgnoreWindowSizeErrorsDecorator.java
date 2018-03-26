package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserDecorator;
import org.openqa.selenium.WebDriverException;

public class IgnoreWindowSizeErrorsDecorator extends AutomatedBrowserDecorator {
    public IgnoreWindowSizeErrorsDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public void maximizeWindow() {
        try {
            automatedBrowser.maximizeWindow();
        } catch (final WebDriverException ex) {
            // ignored
        }
    }
}
