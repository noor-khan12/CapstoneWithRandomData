Feature: Register new user on the retail webiste 


@RegisterTest
Scenario: Create new user account in Test Environment 
	Given user is on Retail website
	When user click on MyAccount
	And user click on Register
	And user fill out the registration form with the below information 
	|firstName|lastName|email|telephone|password|confirmPassword|subscribe|
	|alex|connor|alex420@gmail.com|202101123456|wrongPassword|wrongPassword|yes|
	And user agree to privacy policy 
	And user click on continue button 
	Then user should see successful message 'Your Account Has Been Created!'
	
	