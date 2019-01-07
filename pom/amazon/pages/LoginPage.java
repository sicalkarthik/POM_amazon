package pom.amazon.pages;

import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers{
	public AmazonRegister clickCreateAmazonAccount(){
		clickByXPath(prop.getProperty("LoginPage.clickCreateAmazonAccount"));
		return new AmazonRegister();
	}

}
