package com.matthewcasperson;

import com.matthewcasperson.pages.ticketmonster.TicketMonster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class TicketMonsterTest {
    private static final int RETRY_COUNT = 3;

    private String browser;

    public TicketMonsterTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                "ChromeHeadless",
                "FirefoxHeadless"
        );
    }


    @Test
    public void ticketMonster() {
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
                } finally {
                    automatedBrowser.saveHarFile("test.har");
                }
            }
        } finally {
            automatedBrowser.destroy();
        }
    }
}
