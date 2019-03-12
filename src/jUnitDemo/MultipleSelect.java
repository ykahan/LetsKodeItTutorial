package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import StartingOut.Repo;
import WaitTypes.ExplicitlyWait;

class MultipleSelect {
	WebDriver driver;
	WaitTypes.ExplicitlyWait ew;
	String url;

	@BeforeEach
	void setUp() throws Exception {
		url = Repo.getPracticeSite();
		driver = Repo.getChromeDriver();
		driver.manage().window().maximize();
		ew = new ExplicitlyWait(driver);
		System.out.println("Setup complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Teardown complete");
	}

	@Test
	void test() throws InterruptedException {
		driver.get(url);
		System.out.println("Site acquired");
		int wait = 2000;

		String elementName = "multiple-select-example";
		WebElement element = ew.awaitElement(By.id(elementName));
		Select select = new Select(element);
		
		select.selectByValue("orange");
		System.out.println("Orange selected by value");
		Thread.sleep(wait);
		
		select.deselectByValue("orange");
		System.out.println("Orange deselected by value");
		Thread.sleep(wait);
		
		select.selectByIndex(2);
		System.out.println("3rd item selected by index");
		Thread.sleep(wait);
		
		select.deselectAll();
		System.out.println("All items deselected");
		Thread.sleep(wait);
		
		for(int index = 0; index < select.getOptions().size(); index++) {
			select.selectByIndex(index);
		}
		
		System.out.println("All items selected by index");
		Thread.sleep(wait);
		
		for(int index = 0; index < select.getAllSelectedOptions().size(); index++) {
			System.out.println(select.getAllSelectedOptions().get(index).getText());
		};
	}
		

}
