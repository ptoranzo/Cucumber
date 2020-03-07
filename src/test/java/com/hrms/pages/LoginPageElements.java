package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods{
	
	@FindBy(xpath="//div[@id='divLogo']")
	public WebElement logo;
	
	@FindBy(id="logInPanelHeading")
	public WebElement loginLabel;
	
	@FindBy(name="txtUsername")
	public WebElement name;
	
	@FindBy(css="input#txtPassword")
	public WebElement password;
	
	@FindBy(css="input[name='Submit']")
	public WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	public WebElement errMsg;
	
	public LoginPageElements() {
		PageFactory.initElements(driver, this); //initializes all elements
	}
	
	public void login(String uid, String pwd) {
		sendText(name, uid);
		sendText(password, pwd);
		click(loginBtn);
	}
	
}
