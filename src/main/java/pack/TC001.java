package pack;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wrappers.ProjectWrappers;
import pages.LoginPage;

public class TC001 extends ProjectWrappers{
	@BeforeClass
	public void beforeClass()
	{
		testName="TC001";  
		description="Admin";
		author="Karthikeyan";
		category="sample";
		browser="firefox";
	}
	
	@Test
	public void test() {
		new LoginPage(driver, test).enterSearchText("Hi Google");
	}
}
