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
}
