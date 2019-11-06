package SauceLabs;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleSauce2 {
	
	
	public static final String USERNAME = "boblerry";
	public static final String ACCESS_KEY = "4717128e-26dc-46d1-91fe-533c69c5f1cc";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
			
		
		ChromeOptions caps = new ChromeOptions(); 
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
		                  UnexpectedAlertBehaviour.IGNORE);

	
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		By email = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("loginBtn");
		//By header = By.xpath("//i18n-string[contains(text(),'Set up your HubSpot account')]");
		
		getElement(driver, email, 3).sendKeys("ilhanturkmen@outlook.com");
		getElement(driver, password, 1).sendKeys("Furkan123");
		getElement(driver, loginButton, 2).click();
		
		driver.quit();
	}
	
	public static WebElement getElement(WebDriver driver, By locator, int timeout){
		waitForPresenceOfElement(driver, locator, timeout);
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public static void waitForPresenceOfElement(WebDriver driver, By locator, int timeout){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}


}
