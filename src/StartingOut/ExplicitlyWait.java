package StartingOut;

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
	
	public WebElement awaitElement(String xpath) {
		By locator = By.xpath(xpath);
		return awaitElement(locator);
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

	public static WebElement clickElementWhenReady(WebDriver driver, By locator, int timeout) {
		WebElement we = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			we = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
//			System.out.println("Element clickable");
			we.click();
//			System.out.println("Element clicked");
		} catch (Exception e) {
			System.out.println("EW message: " + e.getMessage());
		}
		return we;
	}

	public WebElement clickElementWhenReady(By locator, int timeout) {
		return clickElementWhenReady(driver, locator, timeout);
	}

	public static WebElement clickElementWhenReady(WebDriver driver, By locator) {
		return clickElementWhenReady(driver, locator, 3);
	}

	public WebElement clickElementWhenReady(By locator) {
		return clickElementWhenReady(driver, locator, 3);
	}
	
	public WebElement clickElementWhenReady(String xpath) {
		By locator = By.xpath(xpath);
		return clickElementWhenReady(locator);
	}

	public List<WebElement> awaitElements(By locator, int timeout) {
		return awaitElements(this.driver, locator, timeout);
	}

	public List<WebElement> awaitElements(String xpath){
		By locator = By.xpath(xpath);
		return awaitElements(locator);
	}
	
	public List<WebElement> awaitElements(By locator) {
		return awaitElements(locator, 3);
	}

	public static List<WebElement> awaitElements(WebDriver driver, By locator, int timeout) {
		List<WebElement> wel = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wel = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return wel;
	}

	public static List<WebElement> awaitElements(WebDriver driver, By locator) {
		return awaitElements(driver, locator, 3);
	}

	public static void clickElementRepeatedlyWithXpath(ExplicitlyWait ew, int reps, String xpath, long waitTime)
			throws InterruptedException {
		for (int i = 0; i < reps; i++) {
			ew.clickElementWhenReady(By.xpath(xpath));
			Thread.sleep(waitTime);
		}
	}

	public void clickElementRepeatedlyWithXpath(int reps, String xpath, long waitTime) throws InterruptedException {
		clickElementRepeatedlyWithXpath(this, reps, xpath, waitTime);
	}

	public static List<WebElement> clickElementsWhenReady(long waitTime, ExplicitlyWait ew, String xpath)
			throws InterruptedException {
		By locator = By.xpath(xpath);
		return clickElementsWhenReady(waitTime, ew, locator);
	}
	
	public static List<WebElement> clickElementsWhenReady(long waitTime, ExplicitlyWait ew, By locator) 
			throws InterruptedException {
		List<WebElement> list = ew.awaitElements(locator);
		for(int index = 0; index < list.size(); index++) {
			list.get(index).click();
			Thread.sleep(waitTime);
		}
		return list;
	}

	public List<WebElement> clickElementsWhenReady(long waitTime, String xpath) throws InterruptedException {
		return clickElementsWhenReady(waitTime, this, xpath);
	}

	public List<WebElement> clickElementsWhenReady(String xpath) throws InterruptedException {
		By locator = By.xpath(xpath);
		return clickElementsWhenReady(locator);
	}

	public List<WebElement> clickElementsWhenReady(By locator) throws InterruptedException {
		return clickElementsWhenReady(this, locator);		
	}

	public List<WebElement> clickElementsWhenReady(ExplicitlyWait ew, By locator) throws InterruptedException {
		return clickElementsWhenReady(3, ew, locator);
		
	}
}
