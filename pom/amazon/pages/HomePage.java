package pom.amazon.pages;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
	public HomePage enterSearchText(String searchText) {
		enterByXPath(prop.getProperty("HomePage.enterSearchText"), searchText);
		return this;
	}

	public HomePage clickSearch() {
		clickByXPath(prop.getProperty("HomePage.clickSearch"));
		return this;
	}

	public SearchResults clickVishnupuram() {
		clickByXPath(prop.getProperty("HomePage.clickVishnupuram"));
		return new SearchResults();
	}

	public HomePage mouseOverCategory() {
		mouseOver(prop.getProperty("HomePage.mouseOverCategory"));
		return this;
	}

	public HomePage mouseOverMobiles() {
		mouseOver(prop.getProperty("HomePage.mouseOverMobiles"));
		return this;
	}

	public MobilesAndAccessories clickAllMobilePhones() {
		clickByXPath(prop.getProperty("HomePage.clickAllMobilePhones"));
		return new MobilesAndAccessories();
	}
}
