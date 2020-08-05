package com.cbre.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"html:target/cucumber-html-report" }, features = "src/test/resources/features", glue = 
				"com.cbre.StepDefinitions")

public class RunnerClass {

}
