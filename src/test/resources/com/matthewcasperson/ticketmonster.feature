Feature: Buy Tickets on TicketMonster
  Scenario: Open browser
    Given I open the browser "ChromeHeadless"
    And I maximize the window
    And I alter requests to urls matching the regex ".*?/rest/media/1" by returning the http code "404"
    And I open the url "https://ticket-monster.herokuapp.com/"

  Scenario: Welcome Page
    And I click the link with the text "Buy tickets now" waiting up to "30" seconds

  Scenario: Select Concert
    And I click the link with the text "Concert" waiting up to "30" seconds
    And I click the link with the text "Rock concert of the decade" waiting up to "30" seconds
    And I select option "Sydney : Sydney Opera House" from the drop down list with the id "venueSelector" waiting up to "30" seconds
    And I click the element with the xpath "/html/body/div[2]/div[2]/div[2]/div[3]/div/div[4]/div/input" waiting up to "30" seconds

  Scenario: Clean up
    Then I close the browser