Feature: Search on ebay site

@Test
Scenario Outline: All Listings and Auction tab
    Given when am on EBay home page
    When I enter the text to search : iPhone
    And click the search button
    And the <tab> is selected
    Then the first result has price and postage displayed

Examples:
|   tab             |
|   all listings    |
#|   auction         |
#|   But it now      |

@Test
Scenario: Buy It Now tab
    Given when am on EBay home page
    When I enter the text to search : Camera with the Books
    And click the search button
    And Buy it now tab is selected
    Then the first result has price and butItNow displayed

@Test
Scenario: Page Navigation
    Given when am on EBay home page
    When I enter the text to search : Camera with the Books
    And click the search button
    And click on Page 2
    Then I should get results in Page 2