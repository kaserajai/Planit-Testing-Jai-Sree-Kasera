Feature: Buy products from the cart

  Scenario: Validate if user can buy the products successfully
    Given chrome browser is open
    And user is on Planit Testing Website
    And user clicks on Shop page from the home page
    When  Buy Products
     
    |stuffed_frog | 2|
    |fluffy_bunny | 5|
    |valentine_bear | 3|
    
		And go to Cart page
		Then Verify the subtotal, Price for each product and total price is correct
		
		|stuffed_frog|2|
    |fluffy_bunny|5|
    |valentine_bear|3|
    
    And close the Browser

	