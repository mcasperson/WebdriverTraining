package com.matthewcasperson.pages.ticketmonster;

import com.matthewcasperson.AutomatedBrowser;

import static com.matthewcasperson.pages.ticketmonster.TicketMonster.WAIT_TIME;

public class BookingPage {
    private final AutomatedBrowser automatedBrowser;

    public BookingPage(AutomatedBrowser automatedBrowser) {
        this.automatedBrowser = automatedBrowser;
    }

    public void selectFrontLeft() {
        automatedBrowser.selectOptionByTextFromSelectWithId("S1 - Front left", "sectionSelect", WAIT_TIME);
    }

    public void addAdultTickets(Integer number) {
        automatedBrowser.populateElementWithXPath(
                "/html/body/div[2]/div[2]/div[2]/div[1]/div/div/form/div[1]/div/div/input",
                number.toString(),
                WAIT_TIME);
    }

    public void addTickets() {
        automatedBrowser.clickElementWithXPath("/html/body/div[2]/div[2]/div[2]/div[1]/div/div/form/div[3]/div/input", WAIT_TIME);
    }

    public void setEmail(String email) {
        automatedBrowser.populateElementWithId("email", email);
    }

    public void checkout() {
        automatedBrowser.clickElementWithXPath("/html/body/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/form/div[2]/input", WAIT_TIME);
    }

    public String getConfirmationHeader() {
        return automatedBrowser.getTextFromElementWithXPath("/html/body/div[2]/div[2]/div[1]/h2", WAIT_TIME);
    }
}
