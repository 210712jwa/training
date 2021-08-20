Feature: Login Functionality for Ship Manager

	Background:
		Given We have a WebDriver instantiated and configured

	Scenario: Successful Login
		Given User is at the login page
		When User enters a valid username and valid password
		Then User should see a landing page with the header View My Own Ships Page
		And The WebDriver should be closed
	
	Scenario: Unsuccessful Login
		Given User is at the login page
		When User enters incorrect credentials
		Then User should see the text INVALID LOGIN!
		And The WebDriver should be closed