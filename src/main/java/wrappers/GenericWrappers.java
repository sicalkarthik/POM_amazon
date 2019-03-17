package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporting;

public class GenericWrappers extends Reporting implements Wrappers {
	public String surl;

	public GenericWrappers() {
		Properties configprop = new Properties();
		try {
			configprop.load(new FileInputStream("./properties/config.properties"));
			surl = configprop.getProperty("URL"); 
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	public static Properties prop;

	public void loadObjects() {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./properties/object.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers/geckodriver");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				reportStep("Browser got launched", "PASS");
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver64.exe");
				driver = new FirefoxDriver();
				driver.get(url);
				reportStep("Browser got launched", "PASS");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
	
		} catch (WebDriverException e) {
			reportStep("Browser closed due to unknown error", "FAIL");
		}
	}

	public long takeSnap() {
		long n = (long) Math.floor(Math.random() * 10000000000l);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + n + ".jpeg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}

	public void clickByXPath(String XPath) {
		try {
			driver.findElementByXPath(XPath).click();
			reportStep("Element found", "pass");
		} catch (NotFoundException e) {
			reportStep("Element not found", "fail");
		} catch (ElementNotInteractableException e) {
			reportStep("Element not interactable", "fail");
		}
	}

	public void enterByXPath(String XPath, String data) {
		try {
			driver.findElementByXPath(XPath).sendKeys(data);
			reportStep("Element found", "pass");
		} catch (NotFoundException e) {
			reportStep("Element not found", "fail");
		} catch (ElementNotInteractableException e) {
			reportStep("Element not interactable", "fail");
		}
	}

	public void getTextByXPath(String XPath) {
		String text = null;
		try {
			text = driver.findElementByXPath(XPath).getText();
			reportStep("Element found with text: " + text, "pass");
		} catch (NotFoundException e) {
			reportStep("Element not found", "fail");
		} catch (ElementNotInteractableException e) {
			reportStep("Element not interactable", "fail");
		}
	}

	public void switchtoLastWindow() {
		try {
			Set<String> wins = driver.getWindowHandles();
			String fwin = null;
			for (String ewin : wins) {
				driver.switchTo().window(ewin);
				fwin = ewin;
			}
			reportStep("The driver got switched to last window with window id " + fwin, "Pass");
		} catch (WebDriverException e) {
			reportStep("The Browser got closed due to unknown error", "Fail");
		}
	}

	public void switchtoParentWindow() {
		try {
			Set<String> wins = driver.getWindowHandles();
			String fwin = null;
			for (String ewin : wins) {
				driver.switchTo().window(ewin);
				fwin = ewin;
				break;
			}
			reportStep("The driver got switched to last window with window id " + fwin, "Pass");
		} catch (WebDriverException e) {
			reportStep("The Browser got closed due to unknown error", "Fail");
		}
	}

	public void mouseOver(String XPath) {
		try {
			WebElement we = driver.findElementByXPath(XPath);
			Actions a = new Actions(driver);
			a.moveToElement(we).perform();
			reportStep("Element found", "pass");
		} catch (NotFoundException e) {
			reportStep("Element not found", "fail");
		} catch (ElementNotInteractableException e) {
			reportStep("Element not interactable", "fail");
		}
	}

	public void selectVisibleTextByXPath(String text, String XPath) {
		try {
			WebElement we = driver.findElementByXPath(XPath);
			Select s = new Select(we);
			s.selectByVisibleText(text);
			reportStep("Element found", "pass");
		} catch (NotFoundException e) {
			reportStep("Element not found", "fail");
		} catch (ElementNotInteractableException e) {
			reportStep("Element not interactable", "fail");
		}
	}

	public void threadSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			reportStep("The browser got closed","Fail");
		}
	}

	public void closeAllBrowsers() {
		driver.quit();
		reportStep("All browsers closed", "close");
	}

}
