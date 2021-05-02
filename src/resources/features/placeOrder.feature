Feature: Placing an Order

@placeorder
Scenario: Placing an order for product
	Given I navigate to page
	When I login with valid credentials
	And I click on create order
	And I provide user information
	Then I accept and grant the permissions
