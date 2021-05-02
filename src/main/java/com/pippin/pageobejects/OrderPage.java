package com.pippin.pageobejects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pippin.utils.seleniumUtils;

import io.github.cdimascio.dotenv.Dotenv;

public class OrderPage extends seleniumUtils {
	WebDriver driver;
	Dotenv dotenv;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		dotenv = Dotenv.load();
		
	}
	
	@FindBy(id="Email_Address")
	WebElement email;
	
	@FindBy(id="User_Password")
	WebElement password;
	
	@FindBy(id="loginBtnLogin")
	WebElement go;
	
	
	public void loginWithValidCred() {
		email.clear();
		email.sendKeys(dotenv.get("pippin_username"));
		System.out.println(dotenv.get("pippin_username"));
		System.out.println(dotenv.get("pippin_password"));
		password.sendKeys(dotenv.get("pippin_password"));
		go.click();
	}
	
	
}
