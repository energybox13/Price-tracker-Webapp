Feature: Get trending news every hour and send it to WhatsappGroup
Scenario: Open NDTV get the latest news including the link share over whatsapp
Given User launch the url "https://www.ndtv.com/latest?pfrom=home-ndtv_mainnavigation"
Then User get the top news of India 
Then User share the news to the group



