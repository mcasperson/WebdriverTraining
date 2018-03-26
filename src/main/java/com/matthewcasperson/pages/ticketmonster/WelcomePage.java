package com.matthewcasperson.pages.ticketmonster;

import com.matthewcasperson.AutomatedBrowser;

public class WelcomePage {
    private final AutomatedBrowser automatedBrowser;

    public WelcomePage(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    public void open() {
        automatedBrowser.goTo("https://ticket-monster.herokuapp.com/");
    }

    public void buyTickets() {
        automatedBrowser.clickLinkWithText("Buy tickets now", 10);
    }
}
