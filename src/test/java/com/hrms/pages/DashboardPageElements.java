package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	
	@FindBy(linkText="Leave")
	public WebElement leaveLink;
	
	@FindBy(linkText="Leave List")
	public WebElement leaveList;
	
	@FindBy(linkText="PIM")
	public WebElement pimLink;
	
	@FindBy(linkText="Add Employee")
	public WebElement addEmp;
	
	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToLeaveList() {
		click(leaveLink);
		click(leaveList);
	}

	public void navigateToAddEmployee() {
		click(pimLink);
		click(addEmp);
	}

}
