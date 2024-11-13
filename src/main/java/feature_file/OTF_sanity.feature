@tag
Feature: Title of your feature

  @offline
  Scenario Outline: login page offline scenaios
    Given Navigate to the login page
    When Goes to offline
    Then single <content_offline> toast is displayed
    When click on the singin button without filling the email and password
    Then single <connectivity_check> toast is displayed
    When fill with invalid emailID and password click on the signin button
    Then single <connectivity_check> toast is displayed
    #When click on the Forgot Password
    #Then single Please check your internet connection toast is displayed
    #When click on the sign up
    #Then single Please check your internet connection toast is displayed
    When connect back to online
    Then single <content_Online> toast is displayed

    Examples: 
      | content_offline             | content_Online | connectivity_check                      |
      | "You are currently offline" | "Connected"    | "Please check your internet connection" |

  @sanity
  Scenario: Login the application
    When Enter the username and password and click on the login the button.
    Then If login success page should be navigating to the stream page.

  @offline
  Scenario Outline: Stream page offline scenario.
    Given Navigate to the stream page
    When Goes to offline
    Then single <content_offline> toast is displayed
    When click on the create stream button
    Then single <connectivity_check> toast is displayed
    When click on the create Record video button
    Then single <connectivity_check> toast is displayed
    When click on the Schedule Webinar video button
    Then single <connectivity_check> toast is displayed
    When click on the upcoming tab
    Then single <connectivity_check> toast is displayed
    When click on the Past tab
    Then single <connectivity_check> toast is displayed
    When try to search on the search
    Then single <connectivity_check> toast is displayed
    And loader is displayed
    When connect back to online
    Then single <content_Online> toast is displayed
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
    Examples: 
      | content_offline             | content_Online | connectivity_check                      |
      | "You are currently offline" | "Connected"    | "Please check your internet connection" |

  @offline
  Scenario Outline: Destination page offline scenario
    Given Navigate to the destination page by click on the destination menu
    When Goes to offline
    Then single <content_offline> toast is displayed
    When connect back to online
    Then single <content_Online> toast is displayed

    Examples: 
      | content_offline             | content_Online | connectivity_check                      |
      | "You are currently offline" | "Connected"    | "Please check your internet connection" |

  @offline
  Scenario Outline: library page offline scenario
    Given Navigate to the library page by clicking on the library menu
    When Goes to offline
    Then single <content_offline> toast is displayed
    And show stopper Ui with "Something went wrong" content is displayed
    When click on the Try again button
    Then page should not reload and show stopper Ui is not removed
    When connect back to online
    Then single <content_Online> toast is displayed
    When click on the Try again button
    Then page should be loaded and showstopper ui should not be displayed

    Examples: 
      | content_offline             | content_Online | connectivity_check                      |
      | "You are currently offline" | "Connected"    | "Please check your internet connection" |

  @offline
  Scenario Outline: Members page offline scenario
    Given Navigate to the Members page by clicing on the members menu
    When Goes to offline
    Then single <content_offline> toast is displayed
    #When click on the invite members button
    #Then single Please check your internet connection toast is displayed
    #When try to search on the search
    #Then single Please check your internet connection toast is displayed
    When connect back to online
    Then single <content_Online> toast is displayed

    Examples: 
      | content_offline             | content_Online | connectivity_check                      |
      | "You are currently offline" | "Connected"    | "Please check your internet connection" |

  @offline
  Scenario Outline: Pre-preview page offline scenario
    Given Navigate to pre-preview screen
    When Goes to offline
    Then single <content_offline> toast is displayed
    When Click on the Enter stream button
    Then Enter stream stream button should not be clickable
    And page is not navigating to the studio page
    When connect back to online
    Then single <content_Online> toast is displayed
    When Click on the Enter stream button
    Then page is navigating to the studio page

    Examples: 
      | content_offline             | content_Online | connectivity_check                      |
      | "You are currently offline" | "Connected"    | "Please check your internet connection" |

  @offline
  Scenario Outline: studio page offline scenario
    Given navigate to the studio page
    When Goes to offline
    Then single <content_offline> toast is displayed
    And show stopper Ui with "Something went wrong" content is displayed
    When click on the Try again button
    Then page should not reload and not navigate to the pre-preview screen
    When connect back to online
    Then single <content_Online> toast is displayed
    When click on the Try again button
    Then page should be loaded and navigated to the pre-preview screen

    Examples: 
      | content_offline             | content_Online | connectivity_check                      |
      | "You are currently offline" | "Connected"    | "Please check your internet connection" |
  #@sanity
  #Scenario Outline: Enter the studio page from the webinar settings page.
    #When click on the Enter studio button
    #Then page will be navigating to the pre-preview screen
    #When click on the Enter stream button
    #Then page will be navigating to the studio page
    #When click on the leave button
    #Then page should be navigating to the stream page
    #And status should be displayed as <status> create stream
    #And label should be staus as <label>
#
    #Examples: 
      #| status    | label   |
      #| Scheduled | Webinar |
