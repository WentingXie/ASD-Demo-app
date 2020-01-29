
Feature: Top Up and Payment History

Scenario: test Login, select the card to top up, enter amount then top up, search history by card number, delete history, and clear history page.
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
Then close browser