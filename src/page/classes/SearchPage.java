package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.ExplicitlyWait;

public class SearchPage {
	public static WebElement element = null;
	
	/*
	 * Returns the flight origin text box element
	 * @param ew
	 * @return
	 */
	public static WebElement getFlightOriginInput(ExplicitlyWait ew) {
		return ew.awaitElement("//input[@id='flight-origin-hp-flight']");
	}
	
	/*
	 * Returns the flight destination text box element
	 * @param ew
	 * @return
	 */
	public static WebElement getFlightDestinationInput(ExplicitlyWait ew) {
		return ew.awaitElement("//input[@id='flight-destination-hp-flight']");
	}
	
	/*
	 * Returns the departure date element
	 * @param ew
	 * @return
	 */
	public static WebElement getDepartureDateInput(ExplicitlyWait ew) {
		return ew.awaitElement("//input[@id='flight-departing-hp-flight']");
	}
	
	/*
	 * Returns the return date element
	 * @param ew
	 * @return
	 */
	public static WebElement getReturnDateInput(ExplicitlyWait ew) {
		return ew.awaitElement("//input[@id='flight-returning-hp-flight']");
	}

	/*
	 * Returns the search button element
	 * @param ew
	 * @return
	 */
	public static WebElement getSearchButton(ExplicitlyWait ew) {
		return ew.awaitElement("//button[@class='btn-primary btn-action gcw-submit']");
	}

	/*
	 * Clicks the search button element
	 * @param ew
	 */
	public static void clickSearchButton(ExplicitlyWait ew) {
		getSearchButton(ew).click();
	}
	
	/*
	 * Returns the hotels tab element
	 * @param ew
	 * @return
	 */
	public static WebElement getHotelsTab(ExplicitlyWait ew) {
		return ew.awaitElement("//button[@id='tab-hotel-tab-hp']");
	}

	/*
	 * Clicks the hotels tab element
	 * @param ew
	 */
	public static void clickHotelsTab(ExplicitlyWait ew) {
		getHotelsTab(ew).click();		
	}

	/*
	 * Returns the flights tab element
	 * @param ew
	 * @return
	 */
	public static WebElement getFlightsTab(ExplicitlyWait ew) {
		return ew.awaitElement("//button[@id='tab-flight-tab-hp']");
	}

	/*
	 * Clicks the flights tab element
	 * @param ew
	 */
	public static void clickFlightsTab(ExplicitlyWait ew) {
		getFlightsTab(ew).click();
	}
}
