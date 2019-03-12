package page.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StartingOut.ExplicitlyWait;
import StartingOut.Repo;

public class FlightPageFactory {
	WebDriver driver;
	int wait;

	@FindBy(id = "tab-flight-tab-hp")
	static WebElement flightTab;

	@FindBy(id = "flight-origin-hp-flight") 
	WebElement origin;

	@FindBy(id = "flight-destination-hp-flight")
	WebElement destination;

	@FindBy(id = "flight-departing-hp-flight")
	WebElement departureDate;

	@FindBy(id = "flight-returning-hp-flight")
	WebElement returnDate;

	@FindBy(xpath = "//button[@class='btn-primary btn-action gcw-submit']")
	WebElement searchButton;
	
	public FlightPageFactory(WebDriver driver, int wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightTab() throws InterruptedException {
		flightTab.click();
		Thread.sleep(wait);
	}
	
	public void setOrigin(String origin) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = ''; ", this.origin);
		this.origin.sendKeys(origin);
		Thread.sleep(wait);
	}
	
	public void setDestination(String destination) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = ''; ", this.destination);
		this.destination.sendKeys(destination);
		Thread.sleep(wait);
	}
	
	public void setDeparture(String departure) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = ''; ", this.departureDate);
		this.departureDate.sendKeys(departure);
		Thread.sleep(wait);
	}
	
	public void setReturn(String returnDate) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = ''; ", this.returnDate);
		this.returnDate.sendKeys(returnDate);
		Thread.sleep(wait);
	}
	
	public void clickSearchButton() {
		this.searchButton.click();
	}
}
