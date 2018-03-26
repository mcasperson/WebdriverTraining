package com.matthewcasperson.pages.ticketmonster;

import com.matthewcasperson.AutomatedBrowser;

import static com.matthewcasperson.pages.ticketmonster.TicketMonster.WAIT_TIME;

public class WelcomePage {
    private final AutomatedBrowser automatedBrowser;

    public WelcomePage(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    public void open() {
        automatedBrowser.goTo("https://ticket-monster.herokuapp.com/");
    }

    public void buyTickets() {
        automatedBrowser.clickLinkWithText("Buy tickets now", WAIT_TIME);
    }
}
