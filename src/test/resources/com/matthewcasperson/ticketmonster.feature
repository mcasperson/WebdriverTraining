Feature: Buy Tickets on TicketMonster
  Scenario: Open browser
    Given I open the browser "Chrome"
    And I open the url "https://ticket-monster.herokuapp.com"
    Then I close the browser