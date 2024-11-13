@tag
Feature: Title of your feature

  @offline
  Scenario: login page offline scenaios
    Given Navigate to the login page
    When Goes to offline
    Then single You are currently offline toast is displayed
    When click on the singin button without filling the email and password
    Then single Please check your internet connection toast is displayed
    When fill with invalid emailID and password
    And click on the signin button
    Then single Please check your internet connection toast is displayed
    #When click on the Forgot Password
    #Then single Please check your internet connection toast is displayed
    #When click on the sign up
    #Then single Please check your internet connection toast is displayed
    When connect back to online
    Then single connected toast is displayed
      

  @sanity
  Scenario: Login the application
    When Enter the username and password and click on the login the button.
    Then If login success page should be navigating to the stream page.
    
    
  @offline
  Scenario: Stream page offline scenario.
  	Given Navigate to the stream page
  	When Goes to offline
    Then single You are currently offline toast is displayed
    When click on the create stream button
    Then single Please check your internet connection toast is displayed
    When click on the create Record video button
    Then single Please check your internet connection toast is displayed
    When click on the Schedule Webinar video button
    Then single Please check your internet connection toast is displayed
    When click on the upcoming tab
    Then single Please check your internet connection toast is displayed
    When click on the Past tab
    Then single Please check your internet connection toast is displayed
    When try to search on the search
    Then single Please check your internet connection toast is displayed
   	When click on the Destination menu
  	Then single Please check your internet connection toast is displayed in destination page
  	When Navigate back to stream page
  	Then single Please check your internet connection toast is displayed in stream page
  	#When click on the library menu
  	#Then single Please check your internet connection toast is displayed in Library page 
  	And show stopper Ui with "Something went wrong" content should be displayed
  	When click on the stream menu from library in offline
  	Then element is not click able
    When connect back to online
    Then single connected toast is displayed
    When click on the Try again button from the show stopper UI
    And click on the stream menu
    Then page is navigating to the stream page
    When Goes to offline
    #And click on the Members menu
		#Then single Please check your internet connection toast is displayed on the members page
    

  #####______stream page____########
  @sanity
  Scenario Outline: Create a Normal live stream without destination integration and enter the studio page
    Given Enter the stream Title on the title field
    When Click on Create Live stream button
    Then Toast is displayed with the content <Toast>
    And page is Navigating to pre-preview screen
    When Click on the Enter stream button from the pre-preview screen
    Then page will be navigating the studio page.
    When click on the leave button
    Then page should be navigating to the stream page
    And status should not be displayed for the create stream
    And label should be staus as <label>

    Examples: 
      | Toast                       | label          |
      | Stream Created successfully | Live Streaming |

  #####______Schedule stream____########
  @sanity
  Scenario Outline: Scheduled a live stream without destination integration and enter the studio page
    Given Enter the Stream Title on the title field
    When Click on the schedule for later
    Then Zone , date and time dropdown is displayed
    Given Select teh zone and select the future date and time
    When Click on the create live stream button
    Then Toast is displayed with the content <Toast>
    And page should not Navigating to pre-preview screen
    When Click on the Enter Studio button from the Stream page
    Then page will be navigating the pre-preview page.
    When Click on the Enter stream button from the pre-preview screen
    Then page will be navigating the studio page.
    When click on the leave button
    Then page should be navigating to the stream page
    And status should be displayed as <status> for the create stream
    And label should be staus as <label>

    Examples: 
      | Toast                         | status    | label          |
      | Stream Scheduled successfully | Scheduled | Live Streaming |

  #####______Recording____########
  @sanity
  Scenario Outline: Create Recording and enter the studio page
    Given Enter the stream Title on the title field
    When Click on Create Recording button
    Then page is Navigating to pre-preview screen
    When Click on the Enter stream button from the pre-preview screen
    Then page will be navigating the studio page.
    When click on the leave button
    Then page should be navigating to the stream page
    And status should be displayed as <status> create stream
    And label should be staus as <label>

    Examples: 
      | Toast                       | status       | label     |
      | Stream Created successfully | Yet to Start | Recording |

  #####______webinar____########
  @sanity
  Scenario Outline: Schedule Webinar
    Given Fill all the field on the webinar
    When Click on Schedule Webinar
    Then webinar created successfully Ui is displayed <Text>
    And page will be navigating to the Webinar Settings

    Examples: 
      | Text                          |
      | Webinar Created Successfully! |

  @sanity
  Scenario Outline: Enter the studio page from the webinar settings page.
    When click on the Enter studio button
    Then page will be navigating to the pre-preview screen
    When click on the Enter stream button
    Then page will be navigating to the studio page
    When click on the leave button
    Then page should be navigating to the stream page
    And status should be displayed as <status> create stream
    And label should be staus as <label>

    Examples: 
      | status    | label   |
      | Scheduled | Webinar |
