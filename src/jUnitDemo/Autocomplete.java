package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.ExplicitlyWait;
import StartingOut.Repo;

class Autocomplete {
	static WebDriver driver;
	static String url;
	static ExplicitlyWait ew;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = Repo.getChromeDriver();
		Repo.setup(driver);
		url = "https://www.southwest.com/air/booking/index.html?clk=GSUBNAV-AIR-BOOK";
		ew = new ExplicitlyWait(driver);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(url);
//		String searchText = "EWR";
		String searchText = "EWR";
		String partialText = "New York";
		WebElement textBox = ew.awaitElement("//input[@id='originationAirportCode']");
		textBox.sendKeys(partialText);
		List<WebElement> airports = ew.awaitElements("//li[contains(@id, 'originationAirportCode')]");
		airports.remove(0);
		int numAirports = airports.size();
		System.out.println("Found " + numAirports + " airports.");
		Thread.sleep(2000);
		for(WebElement airport: airports) {
			System.out.println(airport.getText());
		}
		for(WebElement airport : airports) {
			if (airport.getText().contains(searchText)) {
				System.out.println("Clicked " + airport.getText());
				airport.click();
				break;
			}
		}
		Thread.sleep(3000);
	}

}
