package com.matthewcasperson;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest {
    @ParameterizedTest
    @MethodSource("browserProvider")
    public void testTextInput(String browser) {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.goTo("file://" + FormTest.class.getClassLoader().getResource("form.html").getFile());
            automatedBrowser.clickElementWithId("testbutton");
            final String messageText = automatedBrowser.getTextFromElementWithId("message");
            assertEquals("Button Clicked", messageText);
        } finally {
            automatedBrowser.destroy();
        }
    }

    static Stream<String> browserProvider() {
        return Stream.of(
               "Chrome"
        );
    }
}
