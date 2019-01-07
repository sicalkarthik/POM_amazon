package wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DP;

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
		invokeApp(browser, surl);
	}
	
	public static String dataSheetName;
	@DataProvider(name="fetchData")
	public static String[][] getInput() throws FileNotFoundException, IOException{
		return DP.getData(dataSheetName);
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
