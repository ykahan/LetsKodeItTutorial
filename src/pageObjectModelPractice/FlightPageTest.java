package pageObjectModelPractice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import StartingOut.Repo;
import page.classes.FlightPageFactory;

class FlightPageTest {
	WebDriver driver;
	String url;
	FlightPageFactory fpf;

	@BeforeEach
	void setUp() throws Exception {
		driver = Repo.getChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fpf = new FlightPageFactory(driver, 1000);
		url = "https://www.expedia.com/";
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(url);
		fpf.clickFlightTab();
		fpf.setOrigin("Moscow");
		fpf.setDestination("Sandwich");
		fpf.setDeparture("4/3/2019");
		fpf.setReturn("6/23/2019");
		fpf.clickSearchButton();
	}

}
