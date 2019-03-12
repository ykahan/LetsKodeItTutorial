package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class BasicActions {
	WebDriver driver = StartingOut.Repo.getChromeDriver();
	String url = "https://learn.letskodeit.com/";

	@BeforeEach
	void setUp() throws Exception {
		driver.manage().window().maximize();
		System.out.println("Window maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Implicit Wait initialized to 10 seconds");
		
	}
	
	@Test
	void test() {
		System.out.println("Test beginning");
		driver.get(url);
		System.out.println("URL retrieved");
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("Login found and clicked");
		driver.findElement(By.id("user_email")).clear();
		System.out.println("Email text area cleared");
		driver.findElement(By.id("user_email")).sendKeys("me@gmail.com");
		System.out.println("Email address sent");
		driver.findElement(By.id("user_password")).clear();
		System.out.println("Password area cleared");
		driver.findElement(By.id("user_password")).sendKeys("12345");
		System.out.println("Password sent");
		driver.findElement(By.xpath("//form[@id='new_user']//input[@name='commit']")).click();
		System.out.println("Submit button clicked");
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Driver teardown complete");
	}
}
