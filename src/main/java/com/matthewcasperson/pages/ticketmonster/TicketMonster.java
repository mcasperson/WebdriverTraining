package com.matthewcasperson.pages.ticketmonster;

import com.matthewcasperson.AutomatedBrowser;

public class TicketMonster {
    private final AutomatedBrowser automatedBrowser;
    private final WelcomePage welcomePage;

    public TicketMonster(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
        this.welcomePage = new WelcomePage(automatedBrowser);
    }

    public WelcomePage getWelcomePage() {
        return welcomePage;
    }
}
