package WaitTypes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWait {
	WebDriver driver;

	public ExplicitlyWait(WebDriver driver) {
		this.driver = driver;
	}

	public void explicitlyWait(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement sendKeys(By locator, int timeout, String message) {
		return sendKeys(this.driver, locator, timeout, message);
	}

	public WebElement sendKeys(By locator, String message) {
		return sendKeys(locator, 3, message);
	}

	public WebElement sendKeys(WebDriver driver, By locator, String message) {
		return sendKeys(driver, locator, 3, message);
	}

	public static WebElement sendKeys(WebDriver driver, By locator, int timeout, String message) {
		WebElement we = null;
		try {
//			System.out.println("Waiting up to " + timeout + " seconds for element.");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			we.sendKeys(message);
//			System.out.println("Element found and keys sent");
		} catch (Exception e) {
			String error = e.getMessage();
			System.out.println(error);
		}
		return we;
	}

	public WebElement awaitElement(By locator, int timeout) {
		return awaitElement(driver, locator, timeout);
	}

	public static WebElement awaitElement(WebDriver driver, By locator) {
		return awaitElement(driver, locator, 3);
	}

	public WebElement awaitElement(By locator) {
		return awaitElement(driver, locator, 3);
	}

	public static WebElement awaitElement(WebDriver driver, By locator, int timeout) {
		WebElement we = null;
		try {
//			System.out.println("Waiting up to " + timeout + " seconds for element.");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//			System.out.println("Element found");
		} catch (Exception e) {
			System.out.println("Element not found");
		}
		return we;
	}

	public static WebElement clickWhenReady(WebDriver driver, By locator, int timeout) {
		WebElement we = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			we = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
//			System.out.println("Element clickable");
			we.click();
//			System.out.println("Element clicked");
		} catch (Exception e) {
			System.out.println("Element not clickable");
		}
		return we;
	}

	public WebElement clickWhenReady(By locator, int timeout) {
		return clickWhenReady(driver, locator, timeout);
	}

	public static WebElement clickWhenReady(WebDriver driver, By locator) {
		return clickWhenReady(driver, locator, 3);
	}

	public WebElement clickWhenReady(By locator) {
		return clickWhenReady(driver, locator, 3);
	}

	public List<WebElement> awaitElements(By locator, int timeout) {
		return awaitElements(this.driver, locator, timeout);
	}

	public List<WebElement> awaitElements(By locator) {
		return awaitElements(locator, 3);
	}

	public static List<WebElement> awaitElements(WebDriver driver, By locator, int timeout) {
		List<WebElement> wel = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wel = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return wel;
	}
	
	public static List<WebElement> awaitElements(WebDriver driver, By locator){
		return awaitElements(driver, locator, 3);
	}
}
