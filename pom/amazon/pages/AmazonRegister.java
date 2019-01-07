package pom.amazon.pages;

import wrappers.GenericWrappers;

public class AmazonRegister extends GenericWrappers {
	public AmazonRegister enterName(String Name) {
		enterByXPath(prop.getProperty("AmazonRegister.enterName"), Name);
		return this;
	}

	public AmazonRegister enterMobile(String Mobile) {
		enterByXPath(prop.getProperty("AmazonRegister.enterMobile"), Mobile);
		return this;
	}

	public AmazonRegister enterEmail(String Email) {
		enterByXPath(prop.getProperty("AmazonRegister.enterEmail"), Email);
		return this;
	}

	public AmazonRegister enterPassword(String Password) {
		enterByXPath(prop.getProperty("AmazonRegister.enterPassword"), Password);
		return this;
	}

	public AmazonRegister clickContinue() {
		clickByXPath(prop.getProperty("AmazonRegister.clickContinue"));
		return this;
	}
	
	public AmazonRegister getErrorMessage() {
		getTextByXPath(prop.getProperty("AmazonRegister.getErrorMessage"));
		return this;
	}
}
