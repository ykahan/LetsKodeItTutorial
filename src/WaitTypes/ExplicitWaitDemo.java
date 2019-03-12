package WaitTypes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ExplicitWaitDemo {
	private WebDriver driver;
	private String base;

	@BeforeEach
	void setUp() throws Exception {
		driver = StartingOut.Repo.getChromeDriver();
		driver.manage().window().maximize();
		base = StartingOut.Repo.getPracticeSite();
		System.out.println("Setup method complete");
	}

	@Test
	void test() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		driver.navigate().to(base);
		System.out.println("Base URL found");

//		WebElement loginLink = driver.findElement(By.xpath("//a[@href='/sign_in']"));
//		loginLink.click();
//		System.out.println("Login link clicked");
//		
//		WebElement email_field = 
//				wait.until(
//						ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
//
//		email_field.sendKeys("test");
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email"))).sendKeys("Scooby Doo")		;
//		System.out.println("Dummy text sent");
//		
//		driver.navigate().back();
//		WaitTypes.clickWhenReady(driver, By.id("opentab"), 3);
		WaitTypes.clickWhenReady(driver, By.xpath("//h1[text()='Practice Page']"), 3);

		System.out.println("Test method complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Teardown method complete");
	}

}
