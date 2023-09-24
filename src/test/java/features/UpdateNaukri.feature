Feature: Update Naukri Profile on multiple Websites

  @naukriIndiaUpdate
  Scenario Outline:1 Update user Naukri profile using allIndian login
    Given I have logged in setup and logged in to Naukri website
    And have my profile section open with <username> login and <password>
    When I check for profile section and validate whether updated
    Then I update bio with new data
    And check whether my profile is updated as of today

    Examples: 
      | username                     | password      |
      | "sayanbhandari007@gmail.com" | "Opps@sam*95" |
      | "bhandarisayan@gmail.com"    | "Opps@sam*95" |
      | "sayanbhandari001@gmail.com" | "Opps@sam*95" |

  @naukriInternationalUpdate
  Scenario Outline:2 Update user GulfNaukri profile using International login
    Given I have logged in setup and logged in to gulfNaukri website
    And have my gulfprofile section open with <gulfusername> login and <gulfpassword>
    When I check for gulfprofile section and validate whether updated
    Then I update gulfbio with new data
    And check whether my gulfprofile is updated as of today

    Examples: 
      | gulfusername                 | gulfpassword  |
      | "sayanbhandari007@gmail.com" | "Opps@sam*95" |

#@naukriProfileResumeUpload
   #Scenario Outline:3 Update user GulfNaukri profile using International login
    #Given I have logged in setup and logged in to gulfNaukri website
    #And have my gulfprofile section open with <gulfusername> login and <gulfpassword>
    #When I check for gulfprofile section and validate whether updated
    #Then I update gulfbio with new data
    #And check whether my gulfprofile is updated as of today