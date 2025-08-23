Feature: Get details of trending movies on BookMyShow and share it over whatsapp
Scenario: Open BookMyshow get the treding movie with user view details and share it over whatsapp
Given  User launch browser
Then   User goes to url "https://in.bookmyshow.com/explore/home/bengaluru"
Then  User select location of his/her choice
Then  User will see the details of trending movies
Then  User get the details of it share it to certain whatspp contacts
Then  User close the browser
