package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class LeaveListPageElements extends BaseClass{
	
	@FindBy(css="a.toggle.tiptip")
	public WebElement leaveListTbl;
	
	public LeaveListPageElements() {
		PageFactory.initElements(driver, this);
	}

}
