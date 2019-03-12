package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import StartingOut.Repo;
import WaitTypes.ExplicitlyWait;

class ElementDisplayed2 {
	static WebDriver driver;
	static WaitTypes.ExplicitlyWait ew;
	static String practiceSite;
	static String dicta;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		practiceSite = Repo.getPracticeSite();
		dicta = Repo.getDicta();
		driver = Repo.getChromeDriver();
		driver.manage().window().maximize();
		ew = new ExplicitlyWait(driver);
		System.out.println("Setup complete");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Teardown complete");
	}

	@Test
	void test() {
		driver.get(practiceSite);
		System.out.println("Practice site acquired");
	}
	
	@Test
	void test2() {
		driver.get(dicta);
		System.out.println("Dicta acquired");
	}

}
