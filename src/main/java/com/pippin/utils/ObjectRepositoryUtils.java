package com.pippin.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ObjectRepositoryUtils {
	private static Properties prop;

	static void loadObjectRepository() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(Constants.OBJECTREPOSITORY_PATH);
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			Assert.fail("Failed to load " + "'s Object Repository properties file: " + e.getMessage());
		}
	}

	public static By getLocator(String strElement) {
		loadObjectRepository();
		// retrieve the specified object from the object list
		String locator = prop.getProperty(strElement);
		if (locator == null) {
			System.out.println("No value is present for the key \"" + strElement + "\" in the object repository");
			Assert.fail("No value is present for the key \"" + strElement + "\" in the object repository");
		}

		// extract the locator type and value from the object

		String[] locatorSplit = locator.split(":", 2);

		String locatorType = locatorSplit[0];
		String locatorValue = locatorSplit[1];

		// for testing and debugging purposes
		// System.out.println("Retrieving object of type '" + locatorType + "'
		// and value '" + locatorValue + "' from the object map");

		// return a instance of the By class based on the type of the locator
		// this By can be used by the browser object in the actual test
		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return By.tagName(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else {
			Assert.fail("Unknown locator type '" + locatorType + "'");
			return null;
		}
	}

	public static String getJavaScript(String key) {
		String locator = prop.getProperty(key);
		String locatorValue = locator.split(":", 2)[1];

		return locatorValue;
	}

	public static String getExpression(String key) throws Exception {
		String locator = prop.getProperty(key);
		String locatorValue = locator.split(":", 2)[1];

		return locatorValue;
	}

}
