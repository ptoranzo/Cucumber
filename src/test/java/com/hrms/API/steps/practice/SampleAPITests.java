package com.hrms.API.steps.practice;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleAPITests {
	
	
	public void getAllJobTitles() {
		Response response=RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNzAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI3MCwidXNlcklkIjoiNzMifQ.QltXPabid11Urwn1s07ZqakUBTLGRYD52Wa3cJHlerI")
		.when().get("http://18.232.148.34/syntaxapi/api/jobTitle.php");
		
		response.prettyPrint();
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
	}
	
	
	
	public void getOneEmployee() {
		Response response=RestAssured.given().param("employee_id", "4115").contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNzAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI3MCwidXNlcklkIjoiNzMifQ.QltXPabid11Urwn1s07ZqakUBTLGRYD52Wa3cJHlerI")
		.when().get("http://18.232.148.34/syntaxapi/api/getOneEmployee.php");
		
		response.prettyPrint();
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
		
	}
	
	/*
	 * TASK: getAllEmployeeStatuses
	 * Pretty print
	 * print status code
	 */

	
	public void getAllEmployees() {
		Response response=RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNzAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI3MCwidXNlcklkIjoiNzMifQ.QltXPabid11Urwn1s07ZqakUBTLGRYD52Wa3cJHlerI")
				.when().get("http://18.232.148.34/syntaxapi/api/getAllEmployees.php");
		
		response.prettyPrint();
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
	}
	
	
	@Test
	public void createEmployee() {
		
		Map<String, Object> info=new HashMap<>();
		info.put("emp_firstname", "Dwight");
		info.put("emp_lastname", "Schrute");
		info.put("emp_middle_name", "Beets");
		info.put("emp_gender", "1");
		info.put("emp_birthday", "1992-02-22");
		info.put("emp_status", "Employee");
		info.put("emp_job_title", "IT Support Manager");
		
		
		Response response=RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEwNzAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjI3MCwidXNlcklkIjoiNzMifQ.QltXPabid11Urwn1s07ZqakUBTLGRYD52Wa3cJHlerI")
				
//				.param("emp_firstname", "Dwight")
//				.param("emp_lastname\", \"Schrute\")
//				.param("emp_middle_name", "Beets")
//				.param("emp_gender", "1")
//				.param("emp_birthday", "1992-02-22")
//				.param("emp_status", "Employee")
//				.param("emp_job_title", "IT Support Manager")
				.when().post("http://18.232.148.34/syntaxapi/api/createEmployee.php");
		
		response.prettyPrint();
		int actualResponseCode=response.getStatusCode();
		Assert.assertEquals(200, actualResponseCode);
	}
}
