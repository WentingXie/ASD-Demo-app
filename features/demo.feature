
Feature: Top Up and Payment History

Scenario: Test Login, top up opalcard, search card, delete history, and clear history page.
Given Open FireFox browser
When asd-demo-opal is loaded
Then Login button enabled
Then View Payment Detail
Then Opal card selected
Then Type amount of top up
Then View Main Page
Then View Payment History
Then Search by opal card number
Then Delete history
Then Clear history page