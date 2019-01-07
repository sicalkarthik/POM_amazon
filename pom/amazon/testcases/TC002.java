package pom.amazon.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.amazon.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC002 extends ProjectWrappers {
	@BeforeClass
	public void beforeClass() {
		testName = "TC002";
		description = "AmazonMobile";
		startTestCase(testName, description);
		author = "Karthi";
		category = "sample";
		test.assignAuthor(author);
		test.assignCategory(category);
		browser = "Chrome";
		dataSheetName = "TC002";
	}
	@Test(dataProvider="fetchData")
	public void AmazonMobile(String SortBy,String Brand){
		new HomePage()
		.mouseOverCategory()
		.mouseOverMobiles()
		.clickAllMobilePhones()
		.clickSmartPhones()
		.checkBrand(Brand)
		.selectSortBy(SortBy)
		.sleep(2000)
		.clickFirstResult()
		.switchLastWindow()
		.clickAddToCart()
		.switchParentWindow()
		.clickSecondResult()
		.switchLastWindow()
		.clickAddToCart()
		.switchParentWindow()
		.clickThirdResult()
		.switchLastWindow()
		.clickAddToCart()
		.clickCart()
		.getSubTotal();
	}
}
