package com.matthewcasperson;

import com.matthewcasperson.pages.ticketmonster.TicketMonster;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FormTest {
    private static Stream<String> browserProvider() {
        return Stream.of(
                "Chrome"
        );
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    void testTextInput(String browser) {
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

    private String getMessageText(AutomatedBrowser automatedBrowser) {
        return automatedBrowser.getTextFromElementWithId("message");
    }

    @ParameterizedTest
    @MethodSource("browserProvider")
    void teicketMonster(String browser) {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();

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
        } finally {
            automatedBrowser.destroy();
        }
    }
}
