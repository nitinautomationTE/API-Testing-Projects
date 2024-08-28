Feature: Validating Place API's

Scenario Outline: Verify if Place is being successfully added using ApiPlaceAPI
        Given Add Place PAYLOAD "<name>" "<language>" "<address>"
        When user calls "AddPlaceAPI" with Post HTTP request
        Then the API call got success with status code 200
        And "status" in response body is "OK"
        And "scope" in response body is "APP"
        
Examples:

      |name|language|address|
      |AKKHouse|Punjabi|World cross center|
      |AKKHouse2|English|Seahouse center|