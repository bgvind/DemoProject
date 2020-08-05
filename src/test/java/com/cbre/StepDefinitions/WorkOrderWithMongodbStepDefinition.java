package com.cbre.StepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cbre.DB.DBUtil;
import com.cbre.Driver.DriverInitializer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class WorkOrderWithMongodbStepDefinition {

	WebDriver webDriver = null;
	Map<String, String> dataMap;

	@SuppressWarnings("unchecked")
	@Given("^I login to serviceInsight \"([^\"]*)\"$")
	public void i_login_to_serviceInsight(String arg1) throws Throwable {
		dataMap = DBUtil.getDocument("testData", "testCaseKey", arg1);
		webDriver = DriverInitializer.getDriver("chrome");
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		webDriver.get(dataMap.get("url"));
		WebElement webElement = webDriver.findElement(By.id("UserNameTextBox"));
		webElement.sendKeys(dataMap.get("username"));
		webElement = webDriver.findElement(By.id("PasswordTextBox"));
		webElement.sendKeys(dataMap.get("password"));
		webElement = webDriver.findElement(By.id("LogOnButton"));
		webElement.click();

	}

	@Given("^I navigate to WorkOrderHistory Page$")
	public void i_navigate_to_WorkOrderHistory_Page() throws Throwable {
		WebElement webElement = webDriver.findElement(By.xpath("//a[text()='Order Processing']"));
		webElement.click();
		webElement = webDriver.findElement(By.xpath(" //a[text()='Work Order History']"));
		webElement.click();

	}

	@When("^I enter fromDate  greater than toDate$")
	public void i_enter_fromDate_greater_than_toDate() throws Throwable {
		WebElement webElement = webDriver.findElement(By.xpath("//input[contains(@id,'FromDateTextBox')]"));
		webElement.sendKeys(dataMap.get("fromDate"));
		webElement = webDriver.findElement(By.xpath("//input[contains(@id,'ToDateTextBox')]"));
		webElement.sendKeys(dataMap.get("toDate"));
		webElement = webDriver.findElement(By.xpath("//input[contains(@id,'SearchButton')]"));
		webElement.click();

	}

	@Then("^I should see an alert message$")
	public void i_should_see_an_alert_message() throws Throwable {

		Thread.sleep(500);
		Alert alert = webDriver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals(dataMap.get("alertmsg"), msg);
		Thread.sleep(60);
		alert.accept();
		webDriver.quit();

	}

}
