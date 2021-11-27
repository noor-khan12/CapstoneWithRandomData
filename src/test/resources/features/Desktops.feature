@capstoneRandom 
Feature: Desktops 
Background: 
	Given User is on Retail Website 
	When User click on Desktops tab 
	And User click on show all desktops 

@verifyItems 
Scenario: User verify all items are present in Desktops tab 
	Then User should see all items are present in Desktops page 
	
@cartSuccessMessage 
Scenario: User add HP LP 3065 from Desktops tab to the cart 
	And User click  ADD TO CART option on ‘HP LP3065’ item 
	And User select quantity '1' 
	And User click add to Cart button 
	Then User should see a message ‘Success: you have added HP LP3065 to your Shopping cart!’ 
@addCanon 
Scenario: User add Canon EOS 5D from Desktops tab to the cart 

	And User click ADD TO CART option on 'Canon EOS 5D' item 
	And User select color from dropdown ‘Red’ 
	And User select canon quantity '1' 
	And User click add to Cart button canon 
	Then User should see a message ‘Success: You have added Canon EOS 5D to your shopping cart!’
	
@dataTable 
Scenario Outline: User add a review to Canon EOS 5D item in Desktops tab 
	And User click on Canon EOS 5D item 
	And User click on write a review link 
	And user fill the review information with below information '<yourname>' '<yourReview>' '<Rating>' 
	And User click on Continue Button 
	Then User should see a message with 'Thank you for your review. It has been submitted to the webmaster for approval.' 
Examples: 
		|yourname	|yourReview																			|Rating		|
		|Noorul Hadi|if I can get this camera for $98 I will give a 5 star rating any day of the week!	|excellent	|
		|Hashim		|if I can get this camera for $98 I will give a 4 star rating any day of the week!	|very good	|
#		|Shaun		|I am indifferent to buy this or not shall be 25 chars								|good		|
#		|ABD		|didn't have a good experience at all here will put a negative review'				|bad		|
#		|Rohit		|didn't have a good experience at all here will put a negative review with 1 star	|worse		|
	