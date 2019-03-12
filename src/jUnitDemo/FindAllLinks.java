package jUnitDemo;

//import static org.junit.jupiter.api.Assertions.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StartingOut.ExplicitlyWait;
import StartingOut.Repo;
import page.classes.SearchPage;

class FindAllLinks {
	static WebDriver driver;
	static String url;
	static ExplicitlyWait ew;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = Repo.getChromeDriver();
		Repo.setup(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		url = "https://www.expedia.com/";
		ew = new ExplicitlyWait(driver);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	void findAllLinks() throws MalformedURLException {
		driver.get(url);
		SearchPage.clickFlightsTab(ew);
		List<WebElement> clickables = getClickableLinks();
//		List<WebElement> unclickables = getUnclickableLinks();
		int index = 0;
		for (WebElement clickable : clickables) {
			try {
				String href = clickable.getAttribute("href");
				URL url = new URL(href);
				System.out.println("URL " + index + ": " + href + "\nReturned Value: " + getLinkStatus(url));
				index++;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
//	}

	private List<WebElement> getClickableLinks() {
		List<WebElement> clickables = new ArrayList<WebElement>();
		List<WebElement> clickableElements = driver.findElements(By.tagName("div"));
		System.out.println("ClickableElements Size: " + clickableElements.size());
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Images size: " + images.size());
		clickables.addAll(clickableElements);
		clickables.addAll(images);
//		for (int index = 0; index < images.size(); index++) {
//			clickableElements.add(images.get(index));
//		}
//		for (WebElement e : clickableElements) {
//			if (e.getAttribute("href") != null) {
//				clickables.add(e);
//			}
//		}
		for (WebElement e : images) {
			if (e.getAttribute("href") != null) {
				clickables.add(e);
			}
		}
		System.out.println("Clickables size: " + clickables.size());
		return clickables;
	}

//	private List<WebElement> getUnclickableLinks() {
//		List<WebElement> unclickables = new ArrayList<WebElement>();
//		List<WebElement> elements = ew.awaitElements(By.tagName("a"), 10);
//		elements.addAll(ew.awaitElements(By.tagName("img")));
//		for (WebElement e : elements) {
//			if (e.getAttribute("href") == null) {
//				unclickables.add(e);
//			}
//		}
//
//		return unclickables;
//	}

	private static String getLinkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String message = http.getResponseMessage();
			http.disconnect();
			return message;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
