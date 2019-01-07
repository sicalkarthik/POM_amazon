package pom.amazon.pages;

import wrappers.GenericWrappers;

public class ShoppingCart extends GenericWrappers {
	public LoginPage clickProceedToCheckout(){
		clickByXPath(prop.getProperty("ShoppingCart.clickProceedToCheckout"));
		return new LoginPage();
	}
}
