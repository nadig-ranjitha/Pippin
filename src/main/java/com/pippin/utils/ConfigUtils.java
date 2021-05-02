package com.pippin.utils;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Reading configurations from the file which is provided in the format of
 * .properties under Configurations root folders.
 */
public class ConfigUtils {

	final static Logger logger = Logger.getLogger(ConfigUtils.class);

	public ConfigUtils() throws IOException {

		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "log4j.properties");
		logger.info("Log4j path : " + System.getProperty("user.dir") + File.separator + "log4j.properties");

	}

}
