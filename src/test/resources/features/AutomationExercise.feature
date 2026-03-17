Feature: Automation Exercise Scenarios for Practise 


Scenario: Register User Test case 

	Given User navigates into url as "https://automationexercise.com/" 
	And User verifies the home page is visible successfully 
	When User clicks the SignupLogin button 
	And User verifies 'New User Signup!' is visible 
	And User enters the name and email address 
	And User clicks the Signup button 
	Then User verifies that 'ENTER ACCOUNT INFORMATION' is visible 
	When User fills account details 
	And User selects newsletter checkbox 
	And User selects special offers checkbox 
	And User fills address details 
	And User clicks Create Account button 
	Then User verifies 'ACCOUNT CREATED!' message is visible 
	When User clicks Continue button 
	Then User verifies that message 'Logged in as username' is visible 
	When User clicks Delete Account button 
	Then User verifies that 'ACCOUNT DELETED!' is populated 
	
