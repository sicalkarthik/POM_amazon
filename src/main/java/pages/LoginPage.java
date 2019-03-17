package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers{
	public LoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	} 

	public LoginPage enterSearchText(String SearchText) { 
		enterByXPath(prop.getProperty("LoginPage.enterSearchText"), SearchText);
		return this;
	}
}
