package academy.learnprogramming;

import org.junit.Test;

import java.net.URISyntaxException;

public class WaitTest {
    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();

    @Test
    public void clickDynamicElement() throws URISyntaxException {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");
        try {
            automatedBrowser.init();
            automatedBrowser.goTo(FormTest.class.getResource("/form.html").toURI().toString());

            automatedBrowser.clickElementWithId("newdiv_element");
        } finally {
            automatedBrowser.destroy();
        }
    }

    @Test
    public void clickHiddenElement() throws URISyntaxException {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");
        try {
            automatedBrowser.init();
            automatedBrowser.goTo(FormTest.class.getResource("/form.html").toURI().toString());

            automatedBrowser.clickElementWithId("div3_element");
        } finally {
            automatedBrowser.destroy();
        }
    }

    @Test
    public void clickDynamicElementWithExplicitWait() throws URISyntaxException {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");
        try {
            automatedBrowser.init();
            automatedBrowser.goTo(FormTest.class.getResource("/form.html").toURI().toString());

            automatedBrowser.clickElementWithId("newdiv_element", 10);
        } finally {
            automatedBrowser.destroy();
        }
    }

    @Test
    public void clickHiddenElementWithExplicitWait() throws URISyntaxException {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");
        try {
            automatedBrowser.init();
            automatedBrowser.goTo(FormTest.class.getResource("/form.html").toURI().toString());

            automatedBrowser.clickElementWithId("div3_element", 10);
        } finally {
            automatedBrowser.destroy();
        }
    }
}
