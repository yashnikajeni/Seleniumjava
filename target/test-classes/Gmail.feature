Feature: To validate the login functionality of Gmail application
Scenario: To validate the login functionality with valid username and click next
Given To launch the browser and maximize the window
When To launch the url of Gmail application
And To pass the valid username in email field
And To click the next button
And To check whether navigated to password field or not
Then To close the browser


Scenario Outline: To validate positive and negative combinations of login functionality in Gmail application
Given User has to launch the browser and maximize the windows 
When User has launch the url of the Gmail application
And User has to pass the data "<emaildatas>"in Email field
And User has to click the next button
And User has to check whether navigated to password page or not
Then User has to close the browser

Examples:


|emaildatas     |
|annie@gmail.com|
|jenii@gmail.com|
|asdfg@gmail.com|
|zxcvb@gmail.com|
|mnbgv@gmail.com|


