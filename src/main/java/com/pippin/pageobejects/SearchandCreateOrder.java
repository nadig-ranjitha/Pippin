package com.pippin.pageobejects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pippin.utils.seleniumUtils;

import io.github.cdimascio.dotenv.Dotenv;

public class SearchandCreateOrder extends seleniumUtils {
	public SearchandCreateOrder(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		dotenv = Dotenv.load();
	}

	private WebDriver driver;
	SearchandCreateOrder search_order;
	Dotenv dotenv;

	@FindBy(className = "btn order-btn text-left sidebarMarginTop ng-star-inserted")
	WebElement btn_place_order;

	@FindBy(xpath = "//*[@class='mat-radio-outer-circle']")
	WebElement rdio_btn_FullSearch;

	@FindBy(id = "Property_First_Name")
	WebElement txt_full_name;

	@FindBy(id = "search-box")
	WebElement txt_add_information;

	@FindBy(id = "Order_Mortgage_Date")
	WebElement cal_infornmation;

	@FindBy(id = "Property_Order_Number")
	WebElement additional_info;

	@FindBy(className = "mat-datepicker-toggle-default-icon ng-star-inserted")
	WebElement cal_logo;

	@FindBy(className = "mat-calendar-body-cell-content mat-calendar-body-today")
	WebElement current_date;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement btn_continue;

	@FindBy(id = "mat-checkbox-2-input")
	WebElement accept_terms_condition;

	@FindBy(xpath = "//*[contains(text(),'Submit')]")
	WebElement btn_submit;

	@FindBy(id = "ordDetBtnSendMsg")
	WebElement btn_create_message;

	@FindBy(xpath = "//*[@class='mat-button-wrapper']/span")
	WebElement user_name_text;

	@FindBy(id = "Order_ID")
	WebElement txt_order_id;

	@FindBy(id = "msg-area")
	WebElement txt_msg_area;

	@FindBy(id = "msgSend")
	WebElement btn_msg_area;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	WebElement logout_btn;

	//To Place an Order
	public void place_order() throws Exception {
		System.out.println(System.getProperty("user.dir"));
		webdriverElementToIdentify();
		((JavascriptExecutor) driver).executeScript(
				"document.getElementsByClassName('btn order-btn text-left sidebarMarginTop ng-star-inserted')[0].click()");
	}

	//Inserting all user information for Placing New Order.
	public void user_information() throws Exception {
		String file_path = System.getProperty("user.dir");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		webdriverElementToIdentify();
		((JavascriptExecutor) driver)
				.executeScript("document.getElementsByClassName('mat-radio-label-content')[6].click()");
		implicitlyWait();
		js.executeScript("window.scrollBy(0,500)");
		webdriverElementToIdentify();
		txt_full_name.clear();
		txt_full_name.sendKeys(dotenv.get("user_first_name"));
		webdriverElementToIdentify();
		js.executeScript("window.scrollBy(0,200)");
		txt_add_information.sendKeys(dotenv.get("auto_complete_address"));
		webdriverElementToIdentify();
		txt_add_information.sendKeys(Keys.DOWN);
		webdriverElementToIdentify();
		txt_add_information.sendKeys(Keys.DOWN);
		txt_add_information.sendKeys(Keys.RETURN);

		js.executeScript("window.scrollBy(0,400)");
		additional_info.sendKeys(dotenv.get("additional_name"));

		js.executeScript("window.scrollBy(0,200)");
		webdriverElementToIdentify();
		cal_infornmation.click();
		webdriverElementToIdentify();
		((JavascriptExecutor) driver).executeScript(
				"document.getElementsByClassName('mat-calendar-body-cell-content mat-calendar-body-today')[0].click()");

	//Uploading 3.pdf files and deleting the two files
		webdriverElementToIdentify();
		driver.findElement(By.id("file-upload")).sendKeys(file_path + "\\TestData\\File1.pdf");
		webdriverElementToIdentify();
		driver.findElement(By.id("file-upload")).sendKeys(file_path + "\\TestData\\File2.pdf");
		webdriverElementToIdentify();
		driver.findElement(By.id("file-upload")).sendKeys(file_path + "\\TestData\\File3.pdf");
		webdriverElementToIdentify();

		js.executeScript("window.scrollBy(0,200)");
		((JavascriptExecutor) driver).executeScript(
				"document.getElementsByClassName('d-flex align-items-center ng-star-inserted')[0].getElementsByClassName('mat-icon-button _mat-animation-noopable')[0].click()");
		webdriverElementToIdentify();
		((JavascriptExecutor) driver).executeScript("document.getElementById('conOk').click()");

		webdriverElementToIdentify();
		((JavascriptExecutor) driver).executeScript(
				"document.getElementsByClassName('d-flex align-items-center ng-star-inserted')[0].getElementsByClassName('mat-icon-button _mat-animation-noopable')[0].click()");

		webdriverElementToIdentify();
		((JavascriptExecutor) driver).executeScript("document.getElementById('conOk').click()");

		webdriverElementToIdentify();
		btn_continue.click();
		webdriverElementToIdentify();
	}

	//  Reviewing Order , Validating the order details and passing the data in message box. 
	public void accept_information() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		webdriverElementToIdentify();
		((JavascriptExecutor) driver)
				.executeScript("document.getElementsByClassName('mat-checkbox-layout')[0].click()");
		webdriverElementToIdentify();
		btn_submit.click();
		webdriverElementToIdentify();
		String usr_nams = user_name_text.getText();
		js.executeScript("window.scrollBy(0,200)");
		webdriverElementToIdentify();
		String user_order_id = txt_order_id.getText();
		webdriverElementToIdentify();
		btn_create_message.click();
		webdriverElementToIdentify();
		String enter_data = usr_nams + " " + user_order_id + " " + java.time.LocalDateTime.now();
		txt_msg_area.sendKeys(enter_data);
		webdriverElementToIdentify();
		btn_msg_area.click();
		webdriverElementToIdentify();
		user_name_text.click();
		webdriverElementToIdentify();
		logout_btn.click();
	}
}
