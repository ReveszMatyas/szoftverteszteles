Feature: Sending message

  Background:

    Scenario:
      Given the home page is opened
      And the 'NameMessage' field is filled with 'asdasd'
      And the 'SubmitMessage' button is clicked
      Then the following messages are shown in errormessage:
        | Phone must be between 11 and 21 characters.     |
        | Message must be between 20 and 2000 characters. |
        | Phone may not be blank                          |
        | Subject may not be blank                        |
        | Message may not be blank                        |
        | Email may not be blank                          |
        | Subject must be between 5 and 100 characters.   |

    Scenario:
      Given the home page is opened
      And the 'NameMessage' field is filled with 'Albert Einstein'
      And the 'PhoneNumberMessage' field is filled with '06308291111'
      And the 'SubjectMessage' field is filled with 'adsasd'
      And the 'DescriptionField' field is filled with 'asdasdasdadsasdasdasassadadsdsdsdsaasd'
      And the 'SubmitMessage' button is clicked
      Then the 'Email may not be blank' message is shown in errormessage

