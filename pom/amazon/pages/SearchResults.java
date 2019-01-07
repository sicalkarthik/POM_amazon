package pom.amazon.pages;

import wrappers.GenericWrappers;

public class SearchResults extends GenericWrappers{
	public SearchResults switchWindow(){
		switchtoLastWindow();
		return this;
	}
	
	public ShoppingCart clickAddToCart(){
		clickByXPath(prop.getProperty("SearchResults.clickAddToCart"));
		return new ShoppingCart();
	}
}
