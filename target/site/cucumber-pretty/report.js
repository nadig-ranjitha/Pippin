$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("placeOrder.feature");
formatter.feature({
  "line": 1,
  "name": "Placing an Order",
  "description": "",
  "id": "placing-an-order",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4313506534,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Placing an order for product",
  "description": "",
  "id": "placing-an-order;placing-an-order-for-product",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@placeorder"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I navigate to page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I login with valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I click on create order",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I provide user information",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I accept and grant the permissions",
  "keyword": "Then "
});
formatter.match({
  "location": "Order_Steps.i_navigate_to_page()"
});
formatter.result({
  "duration": 13167431143,
  "status": "passed"
});
formatter.match({
  "location": "Order_Steps.I_login_withvalid_credentials()"
});
formatter.result({
  "duration": 1305417156,
  "status": "passed"
});
formatter.match({
  "location": "Order_Steps.place_orders()"
});
formatter.result({
  "duration": 23321580913,
  "status": "passed"
});
formatter.match({
  "location": "Order_Steps.user_informations()"
});
formatter.result({
  "duration": 374295593691,
  "status": "passed"
});
formatter.match({
  "location": "Order_Steps.accept_information()"
});
formatter.result({
  "duration": 210688796370,
  "status": "passed"
});
formatter.after({
  "duration": 569544258,
  "status": "passed"
});
});