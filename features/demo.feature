
Feature: User login and view own details(Wenting and Yixin UI Testing Combined)

Scenario: test Login, top up opalcard, search history by card number, delete history, and clear history page.
Given open fireFox browser
When asd-demo-opal is loaded
Then login button enabled
Then view payment detail
Then opal card selected
Then type amount of top up
Then view main page
Then view payment history
Then search by opal card number
Then delete history
Then clear history page
