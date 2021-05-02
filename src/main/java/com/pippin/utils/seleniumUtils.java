package com.pippin.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumUtils {

	private final int counter = 120;
	protected WebDriver driver;
	private static Logger log;
	static WebDriverWait wait;
	

	public seleniumUtils(WebDriver driver) {
		this.driver = driver;
		log = LogManager.getLogger(this.getClass().getSimpleName());
	}

	/**
	 * Waits for element to display in web page and fails the test case if
	 * element is not displayed in specific time
	 * 
	 * @param=By element locator for which you are waiting for it to become
	 *           visible
	 * 
	 */
	final public void WaitUntilElementIsVisible(By element) throws Exception {
		try {
			int i;
			for (i = 0; i < counter; i++) {
				try {

					boolean flag = driver.findElement(element).isDisplayed();
					if (flag) {
						break;
					} else {
						log.info("Waiting for element to be visible !!! " + i + " seconds :: " + element);

					}

				} catch (Exception ex) {
					log.info("Waiting for element to be visible !!! " + i + " seconds :: " + element);
					
				}
			}
			if (i >= counter) {
				log.error("Element is not displayed after " + i + " seconds element is :: " + element);
			}

		} catch (Exception e) {

		} finally {
			implicitlyWait();
		}
	}

	
	public static void waitForElementToBeStale(By by, long timeout) {
		WebDriver driver=null;
		//public static Logger logger=LoggerFactory.getLogger(TestSupport.class);
		WebElement element = driver.findElement(by);
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		try{
			wait.until(ExpectedConditions.stalenessOf(element));
		}
		catch(TimeoutException e){
			log.debug("Timeout while waiting for element - {} to become stale");
			
		}
	}
	
	final public void WaitUntilElementIsvisible() throws InterruptedException
	{
		Timeouts time=driver.manage().timeouts();
		time.wait(100000, 1);
	}
	
	
	final public void webdriverwait() throws InterruptedException {
		Thread.sleep((long) (23 * 1000));
	}

	final public void implicitlyWait() {
		try {
				driver.manage().timeouts().implicitlyWait(300000, TimeUnit.SECONDS);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	final public void webdriverElementToIdentify() {
		try {
			//Thread.sleep((long) (50 * 1000));
			webdriverwait();
		} catch (InterruptedException e) {
		}
	}
//	public boolean waitForJStoLoad() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, 30);
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    // wait for jQuery to load
//	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//	      @Override
//	      public Boolean apply(WebDriver driver) {
//	        try {
//	          return ((Long)js.executeScript("return jQuery.active") == 0);
//	        }
//	        catch (Exception e) {
//	          return true;
//	        }
//	      }
//	    };

	    // wait for Javascript to load
//	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//	      @Override
//	      public Boolean apply(WebDriver driver) {
//	        return js.executeScript("return document.readyState")
//	            .toString().equals("complete");
//	      }
//	    };
//	    
//	    ExpectedCondition<Boolean> loader = new ExpectedCondition<Boolean>() {
//		      @Override
//		      public Boolean apply(WebDriver driver) {
//		    	  //js.executeScript("document.getElementsByClassName('preloader-full ng-star-inserted')").length == 0
//		        return js.executeScript("document.getElementsByClassName('preloader-full ng-star-inserted').length")
//		            .toString().equals("1");
//		      }
//		    };

//	  return  (boolean) wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
//	}

	/**
	 * waits for web element to become invisible for given time and fails the
	 * test case if element is displayed after defined time
	 * 
	 * @param=By element locator in the form of By
	 *
	 */
	final public void WaitUntilElementIsInVisible(WebElement element) throws Exception {
		try {
			int i;
			for (i = 0; i < counter; i++) {
				try {
					implicitlyWait();
					boolean flag = element.isDisplayed();
					if (!flag) {
						break;
					} else {
						log.info("Waiting for element to be Invisible !!! " + i + " seconds " + element);
						
					}
				} catch (StaleElementReferenceException r) {
					log.info("Waiting for element to be Invisible !!! " + i + " seconds " + element);
					
				} catch (Exception e) {
					break;
				}
			}
			if (i >= counter) {
				log.error(element + " Element is  displayed after " + i + " seconds");

			}
		} catch (Exception e) {
		} finally {
			implicitlyWait();
		}

	}

	/**
	 * To check whether element is displayed or not
	 * 
	 * @return=true if element is displayed
	 * @return=false if element is not displayed
	 * @param=By element locator in the form of By
	 * 
	 */
	final public boolean isDisplayed(By element) {
		boolean flag = false;
		int counter = 05;
		if (driver instanceof InternetExplorerDriver)
			counter = 10;
		try {
			for (int i = 0; i < counter; i++) {
				try {
					implicitlyWait();
					flag = driver.findElement(element).isDisplayed();
					if (flag) {
						flag = true;
						break;
					} else {
					
					}
				} catch (Exception e) {
				
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			implicitlyWait();
		}
		return flag;
	}

	/**
	 * wait until element is displayed in browser and element is enabled for
	 * clicking
	 * 
	 * @param=By element you want to wait for till it is clickable
	 *
	 */
	final public void WaitUntilElementIsClickable(By element) {
		try {
			boolean flag = false;
			String message = null;
			WaitUntilElementIsVisible(element);
			for (int i = 0; i < counter; i++) {
				try {
					implicitlyWait();
					if (driver.findElement(element).isEnabled()) {
						flag = true;
						break;
					} else {
						log.info("Waiting for element to be clickable " + i + " seconds");
						
					}
				} catch (Exception e) {
					log.info("Waiting for element to be clickable " + i + " seconds");
					
					message = e.getMessage();
				}
			}
			if (flag) {
			} else {
				log.error(element + " is not clickable till " + counter + " seconds due to " + message);

			}
		} catch (Exception e) {

		} finally {
			implicitlyWait();
		}
	}

	/**
	 * scroll to the required element in web page using BY element
	 * 
	 * @param=By element you want to scroll to
	 *
	 */
	final public void scroll(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {

			js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(element));
		} catch (Exception e) {
			log.error("Failed to scroll to " + element + " due to " + e.getMessage());
		} finally {
			js = null;

		}
	}

	/**
	 * scroll to the given web element
	 * 
	 * @param=WebElement web element you want to scroll to
	 * 
	 */
	final public void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		} catch (Exception e) {
			log.error("Failed to scroll to " + element + " due to " + e.getMessage());
		} finally {
			js = null;

		}
	}

	/**
	 * clicks on given element using driver
	 * 
	 * @param=By element locator you want to click using driver
	 * 
	 */
	final public void click(By element) {
		try {
			scroll(element);
			WaitUntilElementIsClickable(element);

			if (driver instanceof InternetExplorerDriver)

				driver.findElement(element).click();
			log.info("successfully clicked on element " + element);
		} catch (TimeoutException e) {
		} catch (Exception e) {
			log.error(element + " cannot be clicked due to " + e.getMessage());

		} finally {

		}
	}

	/**
	 * Locates the elements present in the portal with given locator
	 * 
	 * @param=By Locator of the elements you want to find
	 * @return=List<WebElement> returns the list of web elements
	 */
	final public List<WebElement> findElements(By elements) {
		List<WebElement> element = null;
		try {
			// WaitUntilElementIsPresent(elements);
			element = driver.findElements(elements);
		} catch (Exception e) {
			log.error("unable to find elements due to " + e.getMessage());

		}
		return element;
	}

	final public void clickelement(By element) {
		driver.findElement(element).click();
	}

	/**
	 * Locates the element present in the portal with given locator
	 * 
	 * @param=By Locator of the element you want to find
	 * @return=WebElement returns the web element
	 * 
	 */
	final public WebElement findElement(By element) {
		WebElement webElement = null;
		try {

			webElement = driver.findElement(element);
		} catch (Exception e) {
			log.error("unable to find the element " + element + " due to " + e.getMessage());
		}
		return webElement;
	}

	final public void sendKeys(By element, String keys) {
		try {

			findElement(element).sendKeys("");
			findElement(element).sendKeys(keys.trim());
			log.info("succesfully sent the keys:: \"" + keys + "\" to the input box of element:: " + element);
		} catch (Exception e) {
			log.error("unable to send \"" + keys + "\" keys to input box " + element + " due to " + e.getMessage());

		}
	}

	final public String getAttribute(By element, String attribute) {
		String value = null;
		try {
			value = findElement(element).getAttribute(attribute);
		} catch (Exception e) {
			log.error("Cannot get the Attribute :: " + attribute + " value of element " + element + " due to "
					+ e.getMessage());

		}
		return value;
	}

	final public String getText(By element) {
		String value = null;
		try {
			scroll(element);
			WaitUntilElementIsVisible(element);
			value = findElement(element).getText();
			log.info(" Text of the element :: " + element + " is ::" + value);
		} catch (Exception e) {
			log.error("Cannot get the text of element " + element + " due to " + e.getMessage());

		}
		return value.trim();
	}

	final public void clickUsingJavascript(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			WaitUntilElementIsClickable(element);
			scroll(element);
			js.executeScript("arguments[0].click();", findElement(element));
			log.info("successfully clicked on element " + element);
		} catch (Exception e) {
			log.error(element + " cannot be clicked due to " + e.getMessage());

		} finally {
			js = null;

		}
	}

	final public void swithchtochildwindowHandle() {
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	final public String getCurrentHandleInf() {

		return driver.getWindowHandle();
		

	}

	final public void closeexstingwindow(String winHandleBefore) {
		driver.switchTo().window(winHandleBefore);
	}

	final public void clear(By element) {
		try {
			click(element);
			findElement(element).clear();
		} catch (Exception e) {
			log.error("unable to clear data present in input box for element " + element + " due to " + e.getMessage());

		}
	}

}
