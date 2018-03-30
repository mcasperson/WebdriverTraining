package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.decoratorbase.AutomatedBrowserDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;

public class XvfbWindowSizeDecorator extends AutomatedBrowserDecorator {
    private final int width;
    private final int height;

    public XvfbWindowSizeDecorator(int width, int height, final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
        this.width = width;
        this.height = height;
    }

    @Override
    public void maximizeWindow() {
        try {
            getAutomatedBrowser().maximizeWindow();
        } catch (final WebDriverException ex) {
            getAutomatedBrowser().getWebDriver().manage().window().setSize(new Dimension(width, height));
        }
    }
}
