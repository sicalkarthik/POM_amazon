package pom.amazon.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.amazon.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers {
	@BeforeClass
	public void beforeClass() {
		testName = "TC001";
		description = "AmazonBook";
		startTestCase(testName, description);
		author = "Karthi";
		category = "sample";
		test.assignAuthor(author);
		test.assignCategory(category);
		browser = "Chrome";
		dataSheetName = "TC001";
	}

	@Test(dataProvider = "fetchData")
	public void amazonBook(String searchText,String Name,String Mobile,String Email,String Password ) {
		new HomePage()
		.enterSearchText(searchText)
		.clickSearch()
		.clickVishnupuram()
		.switchWindow()
		.clickAddToCart()
		.clickProceedToCheckout()
		.clickCreateAmazonAccount()
		.enterName(Name)
		.enterMobile(Mobile)
		.enterEmail(Email)
		.enterPassword(Password)
		.clickContinue()
		.getErrorMessage();
	}
}
