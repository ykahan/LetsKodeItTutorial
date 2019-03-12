package pageObjectModelPractice;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import page.classes.SearchPage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.ExplicitlyWait;
import StartingOut.Repo;

class PageObjectModel {
	static WebDriver driver;
	static String url = "https://www.expedia.com/";
	static ExplicitlyWait ew;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = Repo.getChromeDriver();
		Repo.setup(driver);
		ew = new ExplicitlyWait(driver);
	}

	//

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(url);
		SearchPage.clickFlightsTab(ew);

		WebElement origin = SearchPage.getFlightOriginInput(ew);
		sendTextTwice(origin, "Chicago");

		WebElement destination = SearchPage.getFlightDestinationInput(ew);
		sendTextTwice(destination, "Texarkana");

		WebElement departureDateElement = SearchPage.getDepartureDateInput(ew);
		String departureDateString = getLeaveDate();
		sendTextTwice(departureDateElement, departureDateString);

		WebElement returnDate = SearchPage.getReturnDateInput(ew);
		String returnDateString = getReturnDate();
		sendTextTwice(returnDate, returnDateString);
		
		Thread.sleep(5000);
		SearchPage.clickSearchButton(ew);

		Thread.sleep(5000);
	}

	private void sendTextTwice(WebElement element, String string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < 2; i ++) {
			js.executeScript("arguments[0].value = ''; ", element);
			element.sendKeys(string);			
		}
	}

	private String getReturnDate() {
		String leaveDate = getLeaveDate();
		String[] leaveParts = leaveDate.split("/");
		int month = Integer.parseInt(leaveParts[0]);
		int day = Integer.parseInt(leaveParts[1]) + 15;
		int year = Integer.parseInt(leaveParts[2]);
		int[] parts = {month, day, year};
		parts = adjustDate(parts);
		return dateToString(parts[0], parts[1], parts[2]);
	}

	private String getLeaveDate() {
		LocalDateTime ldt = LocalDateTime.now();
		int month = ldt.getMonthValue();
		int day = ldt.getDayOfMonth() + 5;
		int year = ldt.getYear();
		int[] parts = { month, day, year };
		parts = adjustDate(parts);
		return dateToString(parts[0], parts[1], parts[2]);

	}

	private String dateToString(int month, int day, int year) {
		String date = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
		return date;
	}

	private int[] adjustDate(int[] parts) {
		int month = parts[0];
		int day = parts[1];
		int year = parts[2];
		if(day > 28) {
			day -= 10;
			month += 1;
		}
		if(month > 12) {
			month -= 12;
			year += 1;
		}
		parts[0] = month;
		parts[1] = day;
		parts[2] = year;
		return parts;
	}

}
