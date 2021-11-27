@Before @capstoneRandom
Feature: Register and login to account using random data
@fakeLogin1
Scenario:
	Given user is registered on retail website1
	Given user is on Retail Website1
	When user click on MyAccount1 
	And user click on Login1 
	And user enter userName 'fakeEmail' and password1 'fakePassword' 
	And user click on LoginButton1 
	Then user should be logged in to my account dashboard1 