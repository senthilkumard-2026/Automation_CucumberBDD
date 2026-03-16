Feature: Automation Exercise Scenarios for Practise 


Scenario: Register User Test case 

	Given User navigates into url as "https://automationexercise.com/" 
	And User verifies the home page is visible successfully 
	When User clicks the SignupLogin button
	And User verifies 'New User Signup!' is visible 
	And User enters the name and email address 
	And User clicks the Signup button 
	Then User verifies that 'ENTER ACCOUNT INFORMATION' is visible 
<<<<<<< HEAD
=======
	
>>>>>>> eac79a0 (Added changes in features)
