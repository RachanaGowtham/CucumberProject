Feature: Login Features 

Scenario: Login with valid username and no password (testcase 1)
Given User is on "LoginPage"
When User enter into text box "Username" "mayag@tekarch.com"
#When User enter into text box "Password" "Maya14$love"
Then User Clicks on Button "Login"
Then Validate error message "Message" "Please enter your password."


Scenario: Login with valid username - password and validate if it entered home page (testcase 2)
Given User is on "LoginPage"
When User enter into text box "Username" "mayag@tekarch.com"
When User enter into text box "Password" "Maya14$love"
Then User Clicks on Button "Login"
Given User is on "HomePage"
Then Validate the new page "Home Page ~ Salesforce - Developer Edition" 


Scenario: Login with valid username - password and validate remember me option (testcase 3)
Given User is on "LoginPage"
When User enter into text box "Username" "mayag@tekarch.com"
When User enter into text box "Password" "Maya14$love"
Then User Clicks on CheckBox "RememberMe"
Then User Clicks on Button "Login"
Given User is on "HomePage"
Then Click on UserMenu option "userMenu"
Then Print the Options in the UserMenu List "UserMenuList"
Then Select the required Option from UserMenu "Logout"
Then Validate text "Username" "mayag@tekarch.com"

Scenario: Login with valid username and click on forgot password option (testcase 4a)
Given User is on "LoginPage"
When User enter into text box "Username" "mayag@tekarch.com"
Then User Clicks on Option "ForgotPassword"
Then Validate the new page "Forgot Your Password | Salesforce" 

Scenario: Login with invalid username - password and validate the invalid login text message(testcase 4b)
Given User is on "LoginPage"
When User enter into text box "Username" "1234@tekarch.com"
When User enter into text box "Password" "4321"
Then User Clicks on Button "Login"
Then Validate error message "loginErrorMessage" "Please check your username and password. If you still can't log in, contact your Salesforce administrator."


