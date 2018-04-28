package academy.learnprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;

public class ProxyTest {
    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();

    @Test
    public void captureHarFile() {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("FirefoxHeadless");
        try {
            automatedBrowser.init();

            automatedBrowser.captureHarFile();

            automatedBrowser.goTo("https://learnprogramming.academy/");
        } finally {
            try {
                automatedBrowser.saveHarFile("test.har");
            } finally {
                automatedBrowser.destroy();
            }
        }
    }

    @Test
    public void modifyRequests() {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Firefox");

        automatedBrowser.init();

        automatedBrowser.alterResponseFrom(".*?\\.png", 201);
        automatedBrowser.alterResponseFrom(".*?twitter\\.com.*", 500);
        automatedBrowser.alterResponseFrom(".*?google\\.com.*", 500);
        automatedBrowser.alterResponseFrom(".*?facebook\\.com.*", 500);

        automatedBrowser.goTo("https://learnprogramming.academy/");
    }

    @Test
    public void mockRequests() throws URISyntaxException {
        final AutomatedBrowser automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Firefox");
        try {
            automatedBrowser.init();
            automatedBrowser.alterResponseFrom(
                    ".*?query\\.yahooapis\\.com.*",
                    200,
                    "{\"query\":{\"count\":1,\"created\":\"2018-04-28T05:20:30Z\",\"lang\":\"en-US\",\"results\":{\"channel\":{\"astronomy\":{\"sunset\":\"7:00 pm\"}}}}}");
            automatedBrowser.goTo(FormTest.class.getResource("/apitest.html").toURI().toString());
            String sunset = automatedBrowser.getTextFromElementWithId("sunset", 60);
            Assert.assertTrue("Sunset is at 7:00", sunset.contains("7:00 pm"));
        } finally {
            automatedBrowser.destroy();
        }
    }
}
