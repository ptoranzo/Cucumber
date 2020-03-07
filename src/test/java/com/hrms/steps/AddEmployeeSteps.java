package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	String empId;
	
	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployeePage();
		pdetails = new PersonalDetailsPageElements();

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {

		dashboard.navigateToAddEmployee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and_(String fName, String mName, String lName) {
		sendText(addEmp.fName, fName);
		sendText(addEmp.mName, mName);
		sendText(addEmp.lName, lName);
		empId = addEmp.empId.getText();
	}

	@When("I click Save")
	public void i_click_Save() {
		click(addEmp.btnSave);
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {

		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(), empId);
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String string, String string2, String string3) {

	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {

		List<Map<String, String>> empDetailList=empDetails.asMaps(String.class,String.class);

		for (Map<String, String> map : empDetailList) {
			sendText(addEmp.fName, map.get("FirstName"));
			sendText(addEmp.mName, map.get("MiddleName"));
			sendText(addEmp.lName, map.get("LastName"));
		}
	}

	@When("I click on Edit")
	public void clickOnEdit_SaveButton() {
		click(pdetails.editSaveButton);
	}

	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetail) throws InterruptedException {
		List<Map<String, String>> modifyList = modifyEmpDetail.asMaps(String.class,String.class);

		for (Map<String, String> map : modifyList) {

			//click o edit
			click(pdetails.editSaveButton);
			
			//passing new details to the employee
			sendText(pdetails.licenNo, map.get("DriverLisence"));
			sendText(pdetails.licExpDate, map.get("ExpirationDate"));
			sendText(pdetails.SSN, map.get("SSN"));
			sendText(pdetails.SIN, map.get("SIN"));
			clickRadio(pdetails.genderLabels, map.get("Gender"));
			Thread.sleep(5000);
			
			selectDropdownValue(pdetails.maritalStatus, map.get("MaritalStatus"));
			selectDropdownValue(pdetails.nationality, map.get("Nationality"));
			sendText(pdetails.DOB, map.get("DOB"));
			
			//click on save
			click(pdetails.editSaveButton);
		}
	}

}
