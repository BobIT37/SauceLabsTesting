package SauceLabs;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleSauceTest {
	
	public static final String USERNAME = "boblerry";
	public static final String ACCESS_KEY = "4717128e-26dc-46d1-91fe-533c69c5f1cc";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws MalformedURLException {
		
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability("platform", "macOS Mojave");
//		caps.setCapability("version", "10.14.6");
		
		ChromeOptions caps = new ChromeOptions(); 
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
		                  UnexpectedAlertBehaviour.IGNORE);

		//driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"),cap);
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
		
		driver.quit();
		System.out.println("Test is completed... ");
		
		

	}

}
