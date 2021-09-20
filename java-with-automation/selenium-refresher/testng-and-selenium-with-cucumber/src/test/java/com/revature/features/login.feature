Feature: Login

	@Smoke
	Scenario: H2 Header is successfully displayed
	Given User is at the login page
	Then Header should be present with the text "Connect with friends and the world around you on Facebook."

	@Smoke
	Scenario: Unsuccessful Login
	Given User is at the login page
	When User enters username "bach_tran@outlook.com"
	And User enters password "asdfsdf"
	And User presses the login button
	Then User should see text for incorrect password
	
#	@Smoke
#	Scenario Outline: Multiple Unsuccessful Logins
#		Given User is at the login page
#		When User enters username <username>
#		And User enters password <password>
#		And User presses the login button
#		Then User should see text for incorrect password
#		
#		Examples:
#			| username | password |
#			| bach_tran@outlook.com | asdfdsf |
#			| bach.tran@utexas.edu | asdfdsfds |
	