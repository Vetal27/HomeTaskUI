Feature: homeTaskUI
  As a user

  Scenario Outline: Check the search product and create purchase
    Given User opens '<Home Page>' page
    When User clicks on 'Search Field'
    And User write '<Search Word>' and click Enter button
    And User choose 'Apple' products
    And User click on first product
    And user check that product name contains '<Product Name>'
    And user click buy button
    Then User see cart window
    Examples:
      | Home Page               | Search Word                   | Product Name                  |
      | https://rozetka.com.ua/ | Apple iPhone 12 Pro Max 256GB | Apple iPhone 12 Pro Max 256 GB |


  Scenario Outline: Check registration without e-mail
    Given User opens '<Home Page>' page
    When User clicks on 'Log In' button
    And User click 'Registration' button
    And User clicks on 'Name' field
    And User enter name '<Name>'
    And User clicks on 'Surname' field
    And User enter surname '<Surname>'
    And User enter phone number '<Phone Number>'
    And User clicks on 'Password' field'
    And User enter password '<Password>'
    And user click on 'registration' button
    Then User see 'Write e-mail' message
    Examples:
      | Home Page               | Name      | Surname    | Phone Number | Password    |
      | https://rozetka.com.ua/ | Іван      | Іванов     | 0987654321   | qwerty12345 |


  Scenario Outline: Check search for non-existent goods
    Given User opens '<Home Page>' page
    When User clicks on 'Search Field'
    And User Write '<Search Word>'
    Then User see 'Message'

    Examples:
      | Home Page               | Search Word       |
      | https://rozetka.com.ua/ | синхрофазотрон    |
      | https://rozetka.com.ua/ | зілля невидомості |
      | https://rozetka.com.ua/ | індульгенція      |

  Scenario Outline: Check sorting
    Given User opens '<Home Page>' page
    When User clicks on 'Search Field'
    And User write '<Search Word>' and click Enter button
    And User choose 'Apple' producer
    And User click 'Sort Button'
    And User click 'From Cheap to Expensive' button
    And User check that first product cheaper than last
    And User click 'Sort Button'
    And User click 'From Expensive to Cheap' button
    Then User check that first product more expensive than last
    Examples:
      | Home Page               | Search Word                   |
      | https://rozetka.com.ua/ | Apple iPhone 12 Pro Max 256GB |