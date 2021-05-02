package com.pippin.runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/resources/features", }, glue = { "com.pippin.stepdefinition" },

		monochrome = true,

		dryRun = false,

		format = { "html:target/site/cucumber-pretty", "json:target/cucumber.json" })

public class RunCukeTest {

}
