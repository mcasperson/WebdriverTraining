package com.matthewcasperson;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormTest {
    private static Stream<String> browserProvider() {
        return Stream.of(
                "BrowserStackEdge"
        );
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    void testTextInput(String browser) {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.goTo("http://webdriver-tests.s3-website-us-east-1.amazonaws.com/form.html");
            automatedBrowser.clickElementWithId("testbutton");
            assertEquals("Button Clicked", getMessageText(automatedBrowser));

            automatedBrowser.selectItemByTextFromSelectWithId("testselect", "Option 2.1");
            assertEquals("Select Changed", getMessageText(automatedBrowser));
        } finally {
            automatedBrowser.destroy();
        }
    }

    private String getMessageText(AutomatedBrowser automatedBrowser) {
        return automatedBrowser.getTextFromElementWithId("message");
    }
}
