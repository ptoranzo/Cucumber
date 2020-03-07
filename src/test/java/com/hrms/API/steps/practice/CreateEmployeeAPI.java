package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.hrms.utils.CommonMethods;

public class CreateEmployeeAPI {
	
	private static RequestSpecification request;
	private Response response;
	

	@Given("user call createEmployee API")
	public void user_call_createEmployee_API() {
	    request=given().header("Content-Type", "application/json").header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	    request.body(CommonMethods.readJson("C:\\Users\\Paola\\eclipse-workspace\\Cucumber\\src\\test\\resources\\JSONFiles\\createEmployee.json"));
	    
	}

	@When("User retrieves response")
	public void user_retrieves_response() {
	   response=request.post("http://18.232.148.34/syntaxapi/api/createEmployee.php");
	}

	@Then("status code is {int}")
	public void status_code_is(Integer int1) {
	    response.then().assertThat().statusCode(int1);
	}

	@Then("User validates employee is created")
	public void user_validates_employee_is_created() {
	    
	}

}
