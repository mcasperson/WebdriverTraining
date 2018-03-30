package com.matthewcasperson;

import com.matthewcasperson.pages.ticketmonster.TicketMonster;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FormTest {
    private static final int RETRY_COUNT = 3;

    private static Stream<String> browserProvider() {
        return Stream.of(
                //"ChromeHeadless",
                "FirefoxHeadless"
        );
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    void testWithIDs(String browser) {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();
            automatedBrowser.goTo("http://webdriver-tests.s3-website-us-east-1.amazonaws.com/form.html");

            automatedBrowser.clickElementWithId("testnewdiv");
            automatedBrowser.clickElementWithId("testdiv3", 10);

            automatedBrowser.clickElementWithId("testbutton");
            assertEquals("Button Clicked", getMessageText(automatedBrowser));

            automatedBrowser.selectOptionByTextFromSelectWithId("testselect", "Option 2.1");
            assertEquals("Select Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateTextBoxWithId("testtext", "This is some test text");
            assertEquals("Text Input Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateTextBoxWithId("testtextarea", "This is some test text in a text area");
            assertEquals("Text Area Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithId("testradio1");
            assertEquals("Radio Button Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithId("testcheckbox1");
            assertEquals("Checkbox Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithId("testsubmit");
            assertEquals("Form Submitted", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithId("testimage");
            assertEquals("Image Clicked", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithId("testdiv");
            assertEquals("Div Clicked", getMessageText(automatedBrowser));
        } finally {
            automatedBrowser.destroy();
        }
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    void testWithXPaths(String browser) {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();
            automatedBrowser.goTo("http://webdriver-tests.s3-website-us-east-1.amazonaws.com/form.html");

            automatedBrowser.clickElementWithXPath("//*[@id=\"testnewdiv\"]");
            automatedBrowser.clickElementWithXPath("//*[@id=\"testdiv3\"]", 10);

            automatedBrowser.clickElementWithXPath("//*[@id=\"testbutton\"]");
            assertEquals("Button Clicked", getMessageText(automatedBrowser));

            automatedBrowser.selectOptionByTextFromSelectWithXPath("//*[@id=\"testselect\"]", "Option 2.1");
            assertEquals("Select Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateTextBoxWithXPath("//*[@id=\"testtext\"]", "This is some test text");
            assertEquals("Text Input Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateTextBoxWithXPath("//*[@id=\"testtextarea\"]", "This is some test text in a text area");
            assertEquals("Text Area Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithXPath("//*[@id=\"testradio1\"]");
            assertEquals("Radio Button Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithXPath("//*[@id=\"testcheckbox1\"]");
            assertEquals("Checkbox Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithXPath("//*[@id=\"testsubmit\"]");
            assertEquals("Form Submitted", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithXPath("//*[@id=\"testimage\"]");
            assertEquals("Image Clicked", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithXPath("//*[@id=\"testdiv\"]");
            assertEquals("Div Clicked", getMessageText(automatedBrowser));
        } finally {
            automatedBrowser.destroy();
        }
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    void testWithCSS(String browser) {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();
            automatedBrowser.goTo("http://webdriver-tests.s3-website-us-east-1.amazonaws.com/form.html");

            automatedBrowser.clickElementWithCSS("#testnewdiv");
            automatedBrowser.clickElementWithCSS("#testdiv3", 10);

            automatedBrowser.clickElementWithCSS("#testbutton");
            assertEquals("Button Clicked", getMessageText(automatedBrowser));

            automatedBrowser.selectOptionByTextFromSelectWithCSS("#testselect", "Option 2.1");
            assertEquals("Select Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateTextBoxWithCSS("#testtext", "This is some test text");
            assertEquals("Text Input Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateTextBoxWithCSS("#testtextarea", "This is some test text in a text area");
            assertEquals("Text Area Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithCSS("#testradio1");
            assertEquals("Radio Button Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithCSS("#testcheckbox1");
            assertEquals("Checkbox Changed", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithCSS("#testsubmit");
            assertEquals("Form Submitted", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithCSS("#testimage");
            assertEquals("Image Clicked", getMessageText(automatedBrowser));

            automatedBrowser.clickElementWithCSS("#testdiv");
            assertEquals("Div Clicked", getMessageText(automatedBrowser));
        } finally {
            automatedBrowser.destroy();
        }
    }

    private String getMessageText(AutomatedBrowser automatedBrowser) {
        return automatedBrowser.getTextFromElementWithId("message");
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    void ticketMonster(String browser) {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();
            automatedBrowser.alterRequestTo(".*?/rest/media/1", 404);

            for (int i = 0; i < RETRY_COUNT; ++i) {
                try {
                    automatedBrowser.captureHarFile();

                    final TicketMonster ticketMonster = new TicketMonster(automatedBrowser);
                    ticketMonster.getWelcomePage().open();
                    ticketMonster.getWelcomePage().buyTickets();
                    ticketMonster.getEvents().selectConcert();
                    ticketMonster.getEvents().selectRockConcert();
                    ticketMonster.getEvents().selectSydneyVenue();
                    ticketMonster.getEvents().orderTickets();
                    ticketMonster.getBookings().selectFrontLeft();
                    ticketMonster.getBookings().addAdultTickets(2);
                    ticketMonster.getBookings().addTickets();
                    ticketMonster.getBookings().setEmail("a@a.com");
                    ticketMonster.getBookings().checkout();
                    final String confirmation = ticketMonster.getBookings().getConfirmationHeader();
                    assertTrue(confirmation.contains("confirmed"));
                    break;
                } catch (Exception ex) {
                    // ignored
                }
                finally {
                    automatedBrowser.saveHarFile("test.har");
                }
            }
        } finally {
            automatedBrowser.destroy();
        }
    }
}
