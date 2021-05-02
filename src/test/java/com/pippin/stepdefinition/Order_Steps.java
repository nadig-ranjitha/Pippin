package com.pippin.stepdefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pippin.pageobejects.OrderPage;
import com.pippin.pageobejects.SearchandCreateOrder;
import com.pippin.utils.DriverInitialisation;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.*;

public class Order_Steps {
	
	private WebDriver driver;
	OrderPage order;
	Dotenv dotenv;
	SearchandCreateOrder search_order;

	
	
	@Before
	public void setup() {
		driver = DriverInitialisation.runBrowser("chrome");
		dotenv = Dotenv.load();
		order = new OrderPage(driver);
		search_order = new SearchandCreateOrder(driver);
	}
	
	@Given("^I navigate to page$")
	public void i_navigate_to_page() {
		driver.get(dotenv.get("url"));
	}
	
	
	@Given("^I login with valid credentials$")
	public void I_login_withvalid_credentials() {
		order.loginWithValidCred();
	}
	
	@When("^I click on create order$")
	public void place_orders() throws Exception {
		search_order.place_order();
	}
	
	@When("^I provide user information$")
	public void user_informations() throws Exception {
		search_order.user_information();
	}
	
	@When("^I accept and grant the permissions$")
	public void accept_information() throws Exception {
		search_order.accept_information();
	}

	
	@After
	public void tearDown() {
		driver.close();
	}
	
	
}
