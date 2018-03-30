package com.matthewcasperson;

import com.matthewcasperson.pages.ticketmonster.TicketMonster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FormTest {
    private String browser;

    public FormTest(String browser) {
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
    public void testWithIDs() {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();
            automatedBrowser.goTo("http://webdriver-tests.s3-website-us-east-1.amazonaws.com/form.html");

            automatedBrowser.clickElementWithId("testnewdiv");
            automatedBrowser.clickElementWithId("testdiv3", 10);

            automatedBrowser.clickElementWithId("testbutton");
            assertEquals("Button Clicked", getMessageText(automatedBrowser));

            automatedBrowser.selectOptionByTextFromSelectWithId("Option 2.1", "testselect");
            assertEquals("Select Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateElementWithId("testtext", "This is some test text");
            assertEquals("Text Input Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateElementWithId("testtextarea", "This is some test text in a text area");
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

    @Test
    public void testWithXPaths() {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();
            automatedBrowser.goTo("http://webdriver-tests.s3-website-us-east-1.amazonaws.com/form.html");

            automatedBrowser.clickElementWithXPath("//*[@id=\"testnewdiv\"]");
            automatedBrowser.clickElementWithXPath("//*[@id=\"testdiv3\"]", 10);

            automatedBrowser.clickElementWithXPath("//*[@id=\"testbutton\"]");
            assertEquals("Button Clicked", getMessageText(automatedBrowser));

            automatedBrowser.selectOptionByTextFromSelectWithXPath( "Option 2.1", "//*[@id=\"testselect\"]");
            assertEquals("Select Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateElementWithXPath("//*[@id=\"testtext\"]", "This is some test text");
            assertEquals("Text Input Changed", getMessageText(automatedBrowser));

            automatedBrowser.populateElementWithXPath("//*[@id=\"testtextarea\"]", "This is some test text in a text area");
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

    @Test
    public void testWithCSS() {
        final AutomatedBrowser automatedBrowser = new AutomatedBrowserFactory().getAutomatedBrowser(browser);
        try {
            automatedBrowser.init();
            automatedBrowser.maximizeWindow();
            automatedBrowser.goTo("http://webdriver-tests.s3-website-us-east-1.amazonaws.com/form.html");

            automatedBrowser.clickElementWithCSS("#testnewdiv");
            automatedBrowser.clickElementWithCSS("#testdiv3", 10);

            automatedBrowser.clickElementWithCSS("#testbutton");
            assertEquals("Button Clicked", getMessageText(automatedBrowser));

            automatedBrowser.selectOptionByTextFromSelectWithCSS( "Option 2.1", "#testselect");
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
}
