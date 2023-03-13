
Feature: Successful submission message validation

  Scenario: Validate if user can submit the feedback form successfully
    Given chrome browser is open
    And user is on Planit Testing Website
    And user clicks on contact page from the home page
    When  populate mandatory fields
    
    |forename | Jai| 
		|email | jkasera7@gmail.com| 
		|message | Planit Test Case 2 Success|
		
		And click on submit button
		Then validate successful submission message
		And close the Browser
	