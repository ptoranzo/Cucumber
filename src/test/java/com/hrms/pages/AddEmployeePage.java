package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePage extends BaseClass{
	
	@FindBy(id="firstName")
	public WebElement fName;
	
	@FindBy(id="middleName")
	public WebElement mName;
	
	@FindBy(id="lastName")
	public WebElement lName;
	
	@FindBy(id="employeeId")
	public WebElement empId;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy(xpath="//div[@class='head']/h1")
	public WebElement empCreated;
	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
