package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SyntaxAPIAuthenticationSteps {
	private Response response;
	public static String Token;
	private static RequestSpecification request;
	String generateTokenURI="http://18.232.148.34/syntaxapi/api/generateToken.php";
	
	@Given("user generates token")
	public void user_generates_token() {
	    request= given().header("Content-Type", "application/json");
	    System.out.println(request.log().all()); 
	    response =request.body(CommonMethods.readJson("C:\\Users\\Paola\\eclipse-workspace\\Cucumber\\src\\test\\resources\\JSONFiles\\generateToken.json"))
	    .post(generateTokenURI);
	    System.out.println(response.prettyPrint());
	    
	    Token= response.jsonPath().getString("token");
	    System.out.println(Token);
	}

}
