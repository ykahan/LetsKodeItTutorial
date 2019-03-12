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

class ElementState {
	WebDriver driver;
	String url;

	@BeforeEach
	void setUp() throws Exception {
		driver = Repo.getFireFoxDriver();
		url = Repo.getGoogle();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test
	void test() {
		ExplicitlyWait ew = new WaitTypes.ExplicitlyWait(driver);
		WebElement el1 = ew.sendKeys(By.id("q"), "letskodeit");
		System.out.println(String.format("The element is enabled: %b", el1.isEnabled()));

	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
