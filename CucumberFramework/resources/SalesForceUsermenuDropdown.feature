Feature: Login Features 

Scenario: Login with valid username - password and validate usermenu options (testcase 5)
Given User is on "LoginPage"
When User enter into text box "Username" "mayag@tekarch.com"
When User enter into text box "Password" "Maya14$love"
Then User Clicks on Button "Login"
Given User is on "HomePage"
Then Click on UserMenu option "userMenu"
Then Print the Options in the UserMenu List "UserMenuList"

Scenario: Login with valid username - password and click on developer console option (testcase 8)
Given User is on "LoginPage"
When User enter into text box "Username" "mayag@tekarch.com"
When User enter into text box "Password" "Maya14$love"
Then User Clicks on Button "Login"
Given User is on "HomePage"
Then Click on UserMenu option "userMenu"
Then Select the required Option and close Window "DeveloperConsole"
 