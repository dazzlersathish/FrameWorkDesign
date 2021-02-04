package TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GlobalBox.BrowserMethods;
import GlobalBox.CommonMethods;

public class TestDriver
{
	
WebDriver driver;
@BeforeTest
public void startBrowser()
{
//	System.setProperty("webdriver.chrome.driver", "E:\\WebPortal\\Selenium\\chromedriver.exe");
//	driver = new ChromeDriver();
//	driver.get("https://www.facebook.com");

	BrowserMethods.initializeBrowserDriver();
	BrowserMethods.getURL(BrowserMethods.driver, CommonMethods.readPropertiesFile("inputdata.properties", "url"));
}


@Test
public void testTitle()
{
	
	System.out.println(BrowserMethods.driver.getTitle());
	}
}
