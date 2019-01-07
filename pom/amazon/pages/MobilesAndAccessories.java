package pom.amazon.pages;

import wrappers.ProjectWrappers;

public class MobilesAndAccessories extends ProjectWrappers {
	public MobilesAndAccessories clickSmartPhones() {
		clickByXPath(prop.getProperty("MobilesAndAccessories.clickSmartPhones"));
		return this;
	}

	public MobilesAndAccessories checkBrand(String Brand) {
		if (Brand.equals("OnePlus"))
			clickByXPath(prop.getProperty("MobilesAndAccessories.checkOnePlus"));
		else if (Brand.equals("Mi"))
			clickByXPath(prop.getProperty("MobilesAndAccessories.checkMi"));
		else if (Brand.equals("Apple"))
			clickByXPath(prop.getProperty("MobilesAndAccessories.checkApple"));
		return this;
	}

	public MobilesAndAccessories selectSortBy(String text) {
		selectVisibleTextByXPath(text, prop.getProperty("MobilesAndAccessories.selectSortBy"));
		return this;
	}

	public MobilesAndAccessories clickFirstResult() {
		clickByXPath(prop.getProperty("MobilesAndAccessories.clickFirstResult"));
		return this;
	}

	public MobilesAndAccessories switchLastWindow() {
		switchtoLastWindow();
		return this;
	}

	public MobilesAndAccessories clickAddToCart() {
		clickByXPath(prop.getProperty("MobilesAndAccessories.clickAddToCart"));
		return this;
	}

	public MobilesAndAccessories switchParentWindow() {
		switchtoParentWindow();
		return this;
	}

	public MobilesAndAccessories clickSecondResult() {
		clickByXPath(prop.getProperty("MobilesAndAccessories.clickSecondResult"));
		return this;
	}

	public MobilesAndAccessories clickThirdResult() {
		clickByXPath(prop.getProperty("MobilesAndAccessories.clickThirdResult"));
		return this;
	}

	public MobilesAndAccessories clickCart() {
		clickByXPath(prop.getProperty("MobilesAndAccessories.clickCart"));
		return this;
	}

	public MobilesAndAccessories getSubTotal() {
		getTextByXPath(prop.getProperty("MobilesAndAccessories.getSubTotal"));
		return this;
	}

	public MobilesAndAccessories sleep(long time) {
		threadSleep(time);
		return this;
	}
}
