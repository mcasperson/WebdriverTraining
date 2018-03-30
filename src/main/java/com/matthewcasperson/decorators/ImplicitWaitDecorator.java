package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.decoratorbase.AutomatedBrowserDecorator;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitDecorator extends AutomatedBrowserDecorator {
    private final int waitTime;

    public ImplicitWaitDecorator(final int waitTime, final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
        this.waitTime = waitTime;
    }

    @Override
    public void init() {
        automatedBrowser.getWebDriver().manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        automatedBrowser.init();
    }
}
