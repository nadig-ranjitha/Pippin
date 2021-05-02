package com.pippin.utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverInitialisation {

	private static DesiredCapabilities desiredCapabilities;
	private static ChromeOptions chromeOptions;
	public static WebDriver driver;

	public static WebDriver runBrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
			desiredCapabilities = DesiredCapabilities.chrome();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			// chromePrefs.put("excludeSwitches", "disable-component-update");
			chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			chromeOptions.addArguments("--disable-notifications");

			// chromeOptions.addArguments("--incognito");
			// openbrowser maximized state
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--enable-automation");
			// Don't show any infobars in the browser
			chromeOptions.addArguments("disable-infobars");
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			desiredCapabilities.setBrowserName(desiredCapabilities.getBrowserName());
			// "disable-popup-blocking", true

			desiredCapabilities.setJavascriptEnabled(true);

			driver = new ChromeDriver(desiredCapabilities);
			break;

		case "ie":
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;

		case "safari":
			driver = new SafariDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		}
		return driver;
	}
}
