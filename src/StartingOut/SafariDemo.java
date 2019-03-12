package StartingOut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDemo {

	public static void main(String[] args) throws InterruptedException {
		String safariProperty = "webdriver.edge.driver";
		String safariPath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\MicrosoftWebDriver.exe";
		System.setProperty(safariProperty, safariPath);

//		WebDriver sd = Drivers.getSafariDriver();
		WebDriver sd = new SafariDriver();
		sd.get("http://www.google.com");
		Thread.sleep(2000);
//		sd.close();
	}

}
