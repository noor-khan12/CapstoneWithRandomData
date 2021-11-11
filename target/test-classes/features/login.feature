Feature: Login to retail website
#each feature file starts with Feature keyword and name for feature file 


@smokeTest  @Regression  @endtoendTesting
Scenario: Retail website login test 
Given user is on Retail website 
When user click on MyAccount 
And user click on Login 
And user enter userName 'eagles@tekschool.us' and password 'eagles'
And user click on LoginButton 
Then user should be logged in to my account dashboard 

@endtoendTesting @smokeTest
Scenario Outline: Retail website Login test with multiple accounts 
#same scenario will run three times with different data sets 
Given user is on Retail website 
When user click on MyAccount 
And user click on Login 
And user enter userName '<userName>' and password '<password>'
And user click on LoginButton 
Then user should be logged in to my account dashboard 

Examples: 
|userName|password|
|eagles@tekschool.us|eagles|
|hawks@tekschool.us|hawks|
|falcons@tekschool.us|falcons|
