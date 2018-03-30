package com.matthewcasperson.pages.ticketmonster;

import com.matthewcasperson.AutomatedBrowser;

import static com.matthewcasperson.pages.ticketmonster.TicketMonster.WAIT_TIME;

public class EventsPage {
    private final AutomatedBrowser automatedBrowser;

    public EventsPage(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    public void selectConcert() {
        automatedBrowser.clickLinkWithText("Concert", WAIT_TIME);
    }

    public void selectRockConcert() {
        automatedBrowser.clickLinkWithText("Rock concert of the decade", WAIT_TIME);
    }

    public void selectSydneyVenue() {
        automatedBrowser.selectOptionByTextFromSelectWithId( "Sydney : Sydney Opera House", "venueSelector", WAIT_TIME);
    }

    public void orderTickets() {
        automatedBrowser.clickElementWithXPath("/html/body/div[2]/div[2]/div[2]/div[3]/div/div[4]/div/input", WAIT_TIME);
    }
}
