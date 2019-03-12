package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.Repo;
import WaitTypes.ExplicitlyWait;

class ElementDisplayed {
	WebDriver driver;
	StartingOut.ExplicitlyWait ew;
	String practiceSite;
	String dicta;

	@BeforeEach
	void setUp() throws Exception {
		practiceSite = Repo.getPracticeSite();
		dicta = Repo.getDicta();
		driver = Repo.getChromeDriver();
		driver.manage().window().maximize();
		ew = new StartingOut.ExplicitlyWait(driver);
		System.out.println("Setup complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Teardown complete");
	}
	
	@Test
	void test() {
		driver.get(practiceSite);
		System.out.println("Practice site acquired");
		
		WebElement textbox = ew.awaitElement("//input[@id='displayed-text']");
		System.out.println("Textbox displayed: " + textbox.isDisplayed());
		System.out.println("Textbox enabled: " + textbox.isEnabled());
		
		WebElement hideButton = ew.clickElementWhenReady("//input[@id='hide-textbox']");
		System.out.println("Textbox dislayed: "  + textbox.isDisplayed());
		System.out.println("Textbox enabled: " + textbox.isEnabled());
		
		WebElement showButton = ew.clickElementWhenReady("//input[@id='show-textbox']");
		System.out.println("Textbox dislayed: "  + textbox.isDisplayed());
		System.out.println("Textbox enabled: " + textbox.isEnabled());
		
		System.out.println("LetsKodeIt Practice Successful");
	}
	
	@Test
	void test2() {
		driver.get(dicta);
		System.out.println("Dicta acquired");

		WebElement books = ew.clickElementWhenReady("//a[@id='books']");
		WebElement select = ew.awaitElement("//label[@id='book_section_checkbox']");
		System.out.println("Books Select Checkbox displayed: " + select.isDisplayed());
		System.out.println("Books Select Checkbox enabled: " + select.isEnabled());
		
		books.click();
		System.out.println("Books Select Checkbox displayed: " + select.isDisplayed());
		System.out.println("Books Select Checkbox enabled: " + select.isEnabled());
		
		System.out.println("Dicta Successful");
	}

}
