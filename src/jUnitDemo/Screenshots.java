package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import StartingOut.ExplicitlyWait;
import StartingOut.Repo;

class Screenshots {
	static WebDriver driver;
	static String url;
	static ExplicitlyWait ew;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = Repo.getChromeDriver();
		Repo.setup(driver);
		url = "https://www.southwest.com/air/booking/index.html?clk=GSUBNAV-AIR-BOOK";
		ew = new ExplicitlyWait(driver);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		driver.quit();
	}

	@Test
	void test() throws IOException {
		driver.get(url);
		String fileName = "southwestScreenshot2.png";
		String directory = "C:\\Users\\USER\\Desktop\\";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}

}
