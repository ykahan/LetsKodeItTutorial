package StartingOut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class Navigation {
	WebDriver driver = Repo.getChromeDriver();
	String url = Repo.getLetsKodeIt();
	

	@Before
	void setUpBeforeClass() throws Exception {
		Repo.setup(driver);
		System.out.println("Driver setup complete");
	}

	@Test
	void test() {
		driver.get(url);
		String title = driver.getTitle();
		String currentURL = driver.getCurrentUrl();
		System.out.println(String.format("URL: %s\nTitle: %s", currentURL, title));
	}

	@After
	void tearDownAfterClass() throws Exception {
		driver.quit();
		System.out.println("Driver closed.  Test successful.");
	}
}
