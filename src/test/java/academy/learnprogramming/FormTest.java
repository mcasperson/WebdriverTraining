package academy.learnprogramming;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class FormTest {
    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();

    @Test
    public void formTestByID() throws URISyntaxException {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");
        try {
            automatedBrowser.init();
            automatedBrowser.goTo(FormTest.class.getResource("/form.html").toURI().toString());
            automatedBrowser.clickElementWithId("button_element");
            String message = automatedBrowser.getTextFromElementWithId("message");
            assertEquals("Button Clicked", message);
        } finally {
            automatedBrowser.destroy();
        }
    }
}
