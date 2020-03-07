package com.hrms.testbase;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass{
	
	protected static LoginPageElements login;
	protected static DashboardPageElements dashboard;
	protected static AddEmployeePage addEmp;
	protected static PersonalDetailsPageElements pdetails;
	
	public static void initializeAllPage() {
		login=new LoginPageElements();
		dashboard= new DashboardPageElements();
		addEmp=new AddEmployeePage();
		pdetails=new PersonalDetailsPageElements();
		
	}

}
