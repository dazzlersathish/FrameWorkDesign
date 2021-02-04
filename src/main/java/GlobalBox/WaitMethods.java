package GlobalBox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitMethods 
{

public static WebDriverWait wait15driver;

public static void waitInitializerFordriver()
{
	wait15driver = new WebDriverWait(BrowserMethods.driver, 15);
}

@SuppressWarnings("deprecation")
public static void fluentWait(WebDriver localdriver,int maxWaitTime,String locator)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(localdriver);
	wait.withTimeout(maxWaitTime, TimeUnit.SECONDS);
	wait.pollingEvery(3,TimeUnit.SECONDS);
	wait.ignoring(NoSuchElementException.class);
	
	WebElement elementISReady = wait.until(new Function<WebDriver,WebElement>(){
		public WebElement apply(WebDriver localdriver) {
			return localdriver.findElement(By.xpath(locator));
		}
			});
}


}
