package com.hrms.steps;

import com.hrms.testbase.PageInitializer;
import com.hrms.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonMethods{

	@Before
	public void start(Scenario scenario) { // name of scenario will go in parameters
		System.out.println("Starting scenario "+scenario.getName());
		setUp();
		PageInitializer.initializeAllPage();
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Ending scenario "+scenario.getName());
		if(scenario.isFailed()) {
			byte [] picture=takeScreenshot("/failed/"+scenario.getName());
			scenario.embed(picture, "image.png");
		}
		tearDown();
	}
}
