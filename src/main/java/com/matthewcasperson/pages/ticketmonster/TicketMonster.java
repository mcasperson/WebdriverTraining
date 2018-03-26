package com.matthewcasperson.pages.ticketmonster;

import com.matthewcasperson.AutomatedBrowser;

public class TicketMonster {
    public static final int WAIT_TIME = 10;
    private final AutomatedBrowser automatedBrowser;
    private final WelcomePage welcomePage;
    private final EventsPage eventsPage;
    private final BookingPage bookingPage;

    public TicketMonster(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
        this.welcomePage = new WelcomePage(automatedBrowser);
        this.eventsPage = new EventsPage(automatedBrowser);
        this.bookingPage = new BookingPage(automatedBrowser);
    }

    public WelcomePage getWelcomePage() {
        return welcomePage;
    }

    public EventsPage getEvents() {
        return eventsPage;
    }

    public BookingPage getBookings() {
        return bookingPage;
    }
}
