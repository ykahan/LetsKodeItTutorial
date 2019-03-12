package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class NavigatingPages {
	WebDriver driver = StartingOut.Repo.getChromeDriver();
	String url = StartingOut.Repo.getLetsKodeIt();
	String signIn = "//a[@href='/sign_in']";

	@BeforeEach
	void setUp() throws Exception {
		StartingOut.Repo.setup(driver);
	}
	

	@Test
	void test() throws InterruptedException {
		driver.navigate().to(url);
		String currentURL = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(String.format("URL: %s\nTitle: %s", currentURL, title));
		driver.findElement(By.xpath(signIn)).click();
		System.out.println("Clicked on sign in link");
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("Returned to landing page");
		Thread.sleep(2000);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
		System.out.println("Driver closed");
	}


}
