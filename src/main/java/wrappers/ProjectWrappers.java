package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrappers {
	@BeforeSuite
	public void beforeSuite(){
		startReport();
	}
	
	@BeforeTest
	public void beforeTest(){
		loadObjects();
	}
	
	@BeforeMethod
	public void launchAmazon(){
		startTestCase(testName, description);
		test.assignAuthor(author);
		test.assignCategory(category);
		invokeApp(browser, surl);
	}
	 
	@AfterMethod
	public void closeAmazon(){
		closeAllBrowsers();
	}
	
	@AfterClass
	public void afterClass(){
		prop=null;
	}
	
	@AfterTest
	public void afterTest(){
		endTestCase();
	}
	
	@AfterSuite
	public void afterSuite(){
		endReport();
	}
}
