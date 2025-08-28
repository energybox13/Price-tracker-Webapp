Feature: Get top 10 trending bollywood songs in India
Scenario: Get top Indian tredning from billboard
Given User open url "https://www.billboard.com/charts/india-songs-hotw/"
Then User get the top songs 
Then User send it to whatsapp group

