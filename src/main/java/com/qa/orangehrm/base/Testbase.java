package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.orangehrm.util.TestUtil;
import com.qa.orangehrm.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	public static WebDriver driver;
	public static Properties prob;

	public Testbase()  {
		try {
			
		prob=new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/kirup/Workspace_QA_test_selenium/OrangeHrm_java/src/main/java/com/qa/orangehrm/config/config.properties");
				prob.load(ip);
	}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		public void initialization() {

			String browsername=prob.getProperty("browser");
			if(browsername.equals("chrome")) {
				WebDriverManager.chromedriver().setup();		
				driver=new ChromeDriver();
			}
			else if(browsername.equals("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(browsername.equals("IE")) {
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
			}
			EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
			WebEventListener eventListener =new WebEventListener();
			edriver.register(eventListener);
			driver=edriver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prob.getProperty("url"));
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		}
}