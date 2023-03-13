Feature: Submission page error validation

  Scenario: Validate if user can see the error messages without filling the mandatory fields
    Given chrome browser is open
    And user is on Planit Testing Website
    And user clicks on contact page from the home page
    And click on submit button
    Then verify error messages
    And populate mandatory fields
    
    |forename | Jai| 
		|email | jkasera7@gmail.com| 
		|message | Planit Test Case 1 Success|
		
		And validate errors are gone
		
		And close the Browser
	