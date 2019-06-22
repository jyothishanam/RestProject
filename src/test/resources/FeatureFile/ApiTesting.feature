Feature: Api Request methods exploring with cucumber
  @Get
  Scenario: Get Request method
    Given I have petId as "123"
    When I performs a get request 
    Then I should get a response code as 200
    And I should have below details in response
    |petId|status|name|
    |123|pending|teddy|
    
  