@tag
Feature: offline sceanrios

  @offline
  Scenario: login page : go to offline and check the toast content
    Given Navigate to login the page
    When go to offline in login page
    Then You are currently offline toast should be displayed

  @offline
  Scenario: Login page : click on the sigin in offline
    Given Navigate to login page
    When click on the signin btn in offline
    Then Please check your internet connection toast should be displayed
    
   @offline
   Scenario: Login page : come back to online in login page
   	Given Navigate to login page
    When come back to online in login page
    Then Connected toast should be displayed
    
    @normal
    Scenario: Login the application
    Given Navigate to login page
    When Enter the username and password and click on the login the button.
    Then If login success page should be navigating to the stream page.
    
    @offline
    Scenario: Stream page : offline scenario in stream page
    Given Navigate to the stream page
    When Goes to offline in stream page
    Then You are currently offline toast is displayed in stream page
    When click on the create stream button
    Then You are currently offline toast is displayed in stream page
    When click on the create Record video button
    Then Please check your internet connection toast is displayed
    When click on the Schedule Webinar video button
    Then Please check your internet connection toast is displayed in stream page
    When click on the upcoming tab in stream page
    Then Please check your internet connection toast is displayed in stream page
    When click on the Past tab in stream page
    Then Please check your internet connection toast is displayed in stream page
    When try to search on the search
    Then Please check your internet connection toast is displayed
    And loader is displayed in stream page
    When connect back to online
    Then Connected toast is displayed
    #When loader is should be removed
    #When Goes to offline
    #Then single <content_offline> toast is displayed
    #	When click on the Destination menu
    #	Then single Please check your internet connection toast is displayed in destination page
    #	When Navigate back to stream page
    #	Then single Please check your internet connection toast is displayed in stream page
    #	#When click on the library menu
    #	#Then single Please check your internet connection toast is displayed in Library page
    #	And show stopper Ui with "Something went wrong" content should be displayed
    #	When click on the stream menu from library in offline
    #	Then element is not click able
    #When connect back to online
    #Then single <content_Online> toast is displayed
    #	When click on the Try again button from the show stopper UI
    #	And click on the stream menu
    #	Then page is navigating to the stream page
    #	When Goes to offline
    #	And click on the Members menu
    #	Then single Please check your internet connection toast is displayed on the members page 
