package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.Repo;
import WaitTypes.ExplicitlyWait;

class RadioButtonsAndCheckboxes {
	WebDriver driver;
	String url;
	ExplicitlyWait ew;

	@BeforeEach
	void setUp() throws Exception {
		driver = Repo.getEdgeDriver();
		url = Repo.getPracticeSite();
		driver.manage().window().maximize();
		ew = new WaitTypes.ExplicitlyWait(driver);
		System.out.println("Setup complete");
	}

	@Test
	void test() throws InterruptedException {
		driver.get(url);
		WebElement bmwRadio = ew.clickWhenReady(By.id("bmwradio"));
		System.out.println("Bmw Radio button selected: " + bmwRadio.isSelected());
		Thread.sleep(1500);
		
		WebElement benzRadio = ew.clickWhenReady(By.id("benzradio"));
		System.out.println("\nBmw Radio button selected: " + bmwRadio.isSelected());
		System.out.println("Benz Radio button selected: " + benzRadio.isSelected());
		Thread.sleep(1500);
		
		WebElement bmwCheck = ew.clickWhenReady(By.id("bmwcheck"));		
		System.out.println("\nBmw Radio button selected: " + bmwRadio.isSelected());
		System.out.println("Benz Radio button selected: " + benzRadio.isSelected());
		System.out.println("Bmw checkbox selected: " + bmwCheck.isSelected());
		Thread.sleep(1500);
		
		WebElement benzCheck = ew.clickWhenReady(By.id("benzcheck"));
		System.out.println("\nBmw Radio button selected: " + bmwRadio.isSelected());
		System.out.println("Benz Radio button selected: " + benzRadio.isSelected());
		System.out.println("Bmw checkbox selected: " + bmwCheck.isSelected());
		System.out.println("Benz checkbox selected: " + benzCheck.isSelected());
		Thread.sleep(1500);
		
		System.out.println("Test complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(1500);
		driver.quit();
		System.out.println("Teardown complete");
	}

}
