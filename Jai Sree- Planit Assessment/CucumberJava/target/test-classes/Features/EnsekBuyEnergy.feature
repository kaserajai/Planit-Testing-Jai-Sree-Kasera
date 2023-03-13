Feature: Login to Ensek Website to buy energy

  Scenario: Validate if user can buy the energy from Ensek Website
    Given browser is open
    And user is on Ensek Website
    And User clicks on Buy energy
    Then click on reset button
    And Buy Energy page gets displayed and user buys the energy
		And Close the Browser