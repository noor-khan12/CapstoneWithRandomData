@capstoneRandom
Feature: Register new user on the retail webiste 

@CapstoneProject	
Scenario: User verify currency values change 
	Given User is on Retail website 
	When User click on currency 
	And User choose Euro from dropdown 
	Then Currency value should change to Euro
	
@emptyShoppingCart	
Scenario: User empty Shopping cart message displays 
Given User is on Retail website
When User click on shopping cart 
Then “Your shopping cart is empty!” message should display

	
	