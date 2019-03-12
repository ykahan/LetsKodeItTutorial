package pageObjectModelPractice;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.ExplicitlyWait;
import StartingOut.Repo;
import page.classes.SearchPage;

class debugExpediaTestCase {
	static WebDriver driver;
	static String url = "https://www.expedia.com/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = Repo.getChromeDriver();
		Repo.setup(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		driver.get(url);

		// click on the Flights Tab
		driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']")).click();

		// clear and send keys to the flight origin input box
		driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']")).clear();
		driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']")).sendKeys("Chicago");

		// clear and send keys to the flight destination input box
		driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']")).clear();
		driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']")).sendKeys("Texarkana");

		// clear and send keys to the departure date input box
		driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']")).clear();
		driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']")).sendKeys("3/8/2019");

		// clear and send keys to the return date input box
		WebElement returnDate = driver.findElement(By.xpath("//input[@id='flight-returning-hp-flight']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = ''; ", returnDate);
		returnDate.sendKeys("4/15/2019");

		Thread.sleep(5000);

		// click on the submit/search button
		driver.findElement(By.xpath("//button[@class='btn-primary btn-action gcw-submit']")).click();
		Thread.sleep(5000);
	}

}
