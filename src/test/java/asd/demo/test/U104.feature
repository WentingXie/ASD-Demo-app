#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
    

   Feature: LoginFeature
   As a user of opal card
   I want to login to my opal card account 
   In order to login to the website

      
   Scenario:  Login to the opal card website
     
      Given I navigate to the login page
      When I enter the  username <useremail> and password<password>
      Then I click the login<login> button
      Then I should see the LoginServlet page

