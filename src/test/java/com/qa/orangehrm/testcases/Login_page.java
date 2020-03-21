package com.qa.orangehrm.testcases;



	import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	import com.qa.orangehrm.base.Testbase;
	import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;
	public class Login_page extends Testbase {

		LoginPage loginpage;
		HomePage homepage;
	public Login_page()
	{
		super();
		
	}
	@BeforeTest
	public void setup() {
		initialization();
		 loginpage=new LoginPage();
		 homepage=new HomePage();
	}
	@Test(priority=1)
		public void login() {
	homepage=loginpage.LoginCheck();
	}

	}


