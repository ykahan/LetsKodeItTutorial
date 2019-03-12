package WaitTypes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class ImplicitWaitDemo {
	private WebDriver driver;
	private String base;

	@BeforeEach
	void setUp() throws Exception {
		driver = StartingOut.Repo.getChromeDriver();
//		StartingOut.Repo.setup(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		base = StartingOut.Repo.getPracticeSite();
		System.out.println("Setup method complete");
	}

	@Test
	void test() {
		driver.navigate().to(base);
		System.out.println("Base URL found");

		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		System.out.println("Login link clicked");

		driver.findElement(By.id("user_email")).sendKeys("test");
		System.out.println("Dummy text sent");

		System.out.println("Test method complete");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Teardown method complete");
	}

}
