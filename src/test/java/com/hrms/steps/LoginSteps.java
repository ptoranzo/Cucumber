package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods{

	
	@Given("I open browser and navigate to the HRMS")
	public void i_open_browser_and_navigated_to_the_HRMS() {
		BaseClass.setUp();
	}
	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_password() {
		sendText(login.name, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		Assert.assertTrue(false);
	}
	@When("I click on login button")
	public void i_click_on_login_button() {
		click(login.loginBtn);
	}
	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		System.out.println("I am logged in");
	}
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		login = new LoginPageElements();
		sendText(login.name, ConfigsReader.getProperty("username"));
		sendText(login.password, "human");
	}
	@Then("I see error message")
	public void i_see_error_message() {
		boolean err = login.errMsg.isDisplayed();
		Assert.assertTrue("Message is ndot displayed", err);
	}
	@Then("I close browser")
	public void i_close_browser() {
	  tearDown();
	}

}
