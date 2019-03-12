package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.support.ui.Select;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.Repo;
import WaitTypes.ExplicitlyWait;

class SelectTag {
	WebDriver driver;
	String url;
	ExplicitlyWait ew;

	@BeforeEach
	void setUp() throws Exception {
		driver = Repo.getChromeDriver();
		url = Repo.getPracticeSite();
		driver.manage().window().maximize();
		ew = new ExplicitlyWait(driver);
		
		System.out.println("Setup complete");
	}

	@Test
	void test() throws InterruptedException {
		driver.get(url);
		WebElement carsDropdown = ew.awaitElement(By.id("carselect"));
		Select sel = new Select(carsDropdown);
		System.out.println("Cars dropdown found");
		
		sel.selectByValue("benz");
		Thread.sleep(1500);
		
		sel.selectByIndex(2);
		Thread.sleep(1500);
		
		sel.selectByVisibleText("BMW");
		Thread.sleep(1500);
		
		sel.selectByIndex(2);
		Thread.sleep(1500);
		
		List<WebElement> selOptions = sel.getOptions();
		
		for (int index = 0; index < selOptions.size(); index++) {
			sel.selectByIndex(index);
			String optionName = selOptions.get(index).getText();
			System.out.println(String.format("Found %s", optionName));
			Thread.sleep(1500);
		}

		
		System.out.println("Test complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Teardown complete");
	}

}
