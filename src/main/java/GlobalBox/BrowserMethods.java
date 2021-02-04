package GlobalBox;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserMethods
{
	public static WebDriver driver;
	public static ChromeDriverService chromeDriverService ;
	
	@SuppressWarnings("deprecation")
	public static void initializeBrowserDriver()
	{
	String browsername = CommonMethods.readPropertiesFile("inputdata.properties", "browser");
	switch(browsername)
	{
	case "chrome":
		try 
		{
		chromeDriverService = new ChromeDriverService.Builder()
		.usingDriverExecutable(new File("E:\\WebPortal\\Selenium\\chromedriver.exe"))
		.usingAnyFreePort()
		.build();	
		chromeDriverService.start();
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("--start-maximized",
										   "--test-type",
											"--ignore-certificate-content",
											"--disable-popup-blocking",
											"--allow-running-insecure-content",
											"--disable-translate",
											"--always-authorize-plugins",
											"--disable-notification"));
		DesiredCapabilities chromecap = DesiredCapabilities.chrome();
		chromecap.setCapability(ChromeOptions.CAPABILITY, options);
		chromecap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromecap.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		chromecap.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		chromecap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		chromecap.setJavascriptEnabled(true);
		driver = new ChromeDriver(chromeDriverService, chromecap);
		WaitMethods.waitInitializerFordriver();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	}

	public static void getURL(WebDriver localdriver,String url)
	{
		localdriver.get(url);
	}
	
	
}
