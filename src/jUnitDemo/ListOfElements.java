package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.Repo;
import WaitTypes.ExplicitlyWait;

class ListOfElements {

	WebDriver driver;
	String url;
	ExplicitlyWait ew;

	@BeforeEach
	void setUp() throws Exception {
		driver = Repo.getChromeDriver();
		driver.manage().window().maximize();
		ew = new ExplicitlyWait(driver);
		System.out.println("Setup complete");
	}

	@Test
	void test() throws InterruptedException {
		url = Repo.getPracticeSite();
		driver.get(url);
		List<WebElement> cars = ew.awaitElements(By.name("cars"));
		String carsRadioXpath = "//input[@name='cars' and @type='radio']";
		List<WebElement> carsRadio = ew.awaitElements(By.xpath(carsRadioXpath));
		String radioMessage = 
				String.format("There are %s radio buttons that have a name attribute of \"cars.\"", carsRadio.size());
		String carsMessage =
				String.format("There are %s objects that have a name attribute of \"cars.\"", cars.size());
		System.out.println(radioMessage);
		System.out.println(carsMessage);
		List<List<WebElement>> superlist = new ArrayList();
		superlist.add(cars);
		superlist.add(carsRadio);
		int counter = 1;
		System.out.println();
		for (int inner = 0; inner < superlist.size(); inner++) {
			for (int item = 0; item < superlist.get(inner).size(); item++) {
				superlist.get(inner).get(item).click();
				System.out.println("Item clicked");
				System.out.println(counter + " object(s) clicked.");
				System.out.println();
				counter++;
				Thread.sleep(1000);
			}
			
		}
		System.out.println("Test complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Teardown complete");
	}

}
