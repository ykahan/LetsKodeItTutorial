package WaitTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	WebDriver driver;

	public void waitTypes(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement awaitElement(By locator, int timeout) {
		return awaitElement(driver, locator, timeout);
	}

	public static WebElement awaitElement(WebDriver driver, By locator, int timeout) {
		WebElement we = null;
		try {
			System.out.println("Waiting up to " + timeout + " seconds for element.");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element found");
		} catch (Exception e) {
			System.out.println("Element not found");
		}
		return we;
	}
	
	public static void clickWhenReady(WebDriver driver, By locator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement we = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
			System.out.println("Element clickable");
			we.click();
			System.out.println("Element clicked");
		}
		catch(Exception e) {
			System.out.println("Element not clickable");
		}
	}
	
	public void clickWhenReady(By locator, int timeout) {
		clickWhenReady(driver, locator, timeout);
	}
}
