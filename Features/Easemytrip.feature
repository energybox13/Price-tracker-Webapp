Feature: Check the lowest flight between Bengaluru and Patna
Scenario: Check the lowest price between Bengaluru and Patna at ease my trip

Given User enter url "https://www.easemytrip.com/flights.html?utm_campaign=788997081&utm_source=g_c&utm_medium=cpc&utm_term=e_easemytrip&adgroupid=39319940377&gad_source=1&gad_campaignid=788997081&gbraid=0AAAAADo_0-iAWWK7ffpq6cBjiDHoOpQDn&gclid=Cj0KCQjw-ZHEBhCxARIsAGGN96LhE59F8QPpbKuIFRIEIT_thUkGdJ-BnRBsGbi7K9AzCWMt0U0KLNoaAnMGEALw_wcB"

Then User click  on Flights
Then  User enter from "Bengaluru" and to "Patna"
Then User select date of journey
Then User select no of passengers
Then User click on search

