package com.qa.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.base.Testbase;

public class LoginPage extends Testbase {
@FindBy(id="txtUsername")
WebElement id;
@FindBy(id="txtPassword")
WebElement password;
@FindBy(id="btnLogin")
WebElement loginbutton;
public LoginPage() {
	PageFactory.initElements(driver, this);
}
public HomePage LoginCheck() {
	id.sendKeys("Admin");
	password.sendKeys("admin123");
	loginbutton.click();
	return new HomePage();
}
}
