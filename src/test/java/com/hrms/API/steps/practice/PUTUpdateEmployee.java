package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTUpdateEmployee {
	private static RequestSpecification request;
	private Response response;
	public static Object employee_ID;

	@Given("user calls updateEmployee API")
	public void user_calls_updateEmployee_API() {
	}

	@When("User retrieves response for updateEmployee API")
	public void user_retrieves_response_for_updateEmployee_API() {
	}

	@Then("status code is {int} for updateEmployee API")
	public void status_code_is_for_updateEmployee_API(Integer int1) {
	}

	@Then("user verifies employee name was updated")
	public void user_verifies_employee_name_was_updated() {
	}

	@Then("user validates employee was updated")
	public void user_validates_employee_was_updated() {
	}

}
