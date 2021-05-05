package TestScript;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GlobalBox.BrowserMethods;
import GlobalBox.CommonMethods;
import GlobalBox.ScreenshotMethod;

public class TestDriver
{
	
WebDriver driver;
@BeforeTest
public void startBrowser() throws Exception
{
	String resultDirectory = "TestResult";
	File resultDir = new File(resultDirectory);
	if(!resultDir.exists())
	{
		resultDir.mkdir();
	}
	
	CommonMethods.TestRunnerFolderPath = resultDirectory+"/"+CommonMethods.getTimeStamp();
	File screenshotResultDirectory = new File(CommonMethods.TestRunnerFolderPath);
	if(!screenshotResultDirectory.exists())
	{
		screenshotResultDirectory.mkdir();
	}
	
	BrowserMethods.initializeBrowserDriver();
	
}


@Test
public void testTitle()
{
	BrowserMethods.getURL(BrowserMethods.driver, CommonMethods.readPropertiesFile("inputdata.properties", "url"));
	
	System.out.println(BrowserMethods.driver.getTitle());
	ScreenshotMethod.takeScreenshot(BrowserMethods.driver, "tempfile", "Home Page");
}

@AfterTest
public static void releaseResource() throws Exception 
{
	ScreenshotMethod.finalizeScreenshotDocument();
	String browserName = CommonMethods.readPropertiesFile("inputdata.properties", "browser");
	switch(browserName)
	{
		case "chrome":
			BrowserMethods.chromeDriverService.stop();
			break;
		
		default:
			break;
			
	}
}
}
