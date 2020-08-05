package com.cbre.StepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cbre.Driver.DriverInitializer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class WorkOrderStepDefinition {

	WebDriver webDriver = null;

	@Given("^I login to \"([^\"]*)\" using username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_using_username_and_Password(String arg1, String arg2, String arg3) throws Throwable {
		webDriver = DriverInitializer.getDriver("chrome");
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		webDriver.get(arg1);
		WebElement webElement = webDriver.findElement(By.id("UserNameTextBox"));
		webElement.sendKeys(arg2);
		webElement = webDriver.findElement(By.id("PasswordTextBox"));
		webElement.sendKeys(arg3);
		webElement = webDriver.findElement(By.id("LogOnButton"));
		webElement.click();
	}

	@Given("^I navigate to WorkOrderHistory$")
	public void i_navigate_to_WorkOrderHistory() throws Throwable {
		WebElement webElement = webDriver.findElement(By.xpath("//a[text()='Order Processing']"));
		webElement.click();
		webElement = webDriver.findElement(By.xpath(" //a[text()='Work Order History']"));
		webElement.click();

	}

	@When("^I enter fromDate \"([^\"]*)\" greater than toDate \"([^\"]*)\"$")
	public void i_enter_fromDate_greater_than_toDate(String arg1, String arg2) throws Throwable {
		WebElement webElement = webDriver.findElement(By.xpath("//input[contains(@id,'FromDateTextBox')]"));
		webElement.sendKeys(arg1);
		webElement = webDriver.findElement(By.xpath("//input[contains(@id,'ToDateTextBox')]"));
		webElement.sendKeys(arg2);
		webElement = webDriver.findElement(By.xpath("//input[contains(@id,'SearchButton')]"));
		webElement.click();

	}

	@SuppressWarnings("deprecation")
	@Then("^I should get an alert message  \"([^\"]*)\"$")
	public void i_should_get_an_alert_message(String arg1) throws Throwable {
		
		Thread.sleep(500);
		Alert alert = webDriver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals(arg1, msg);
		Thread.sleep(60);
		alert.accept();
		webDriver.quit();
	}

}
