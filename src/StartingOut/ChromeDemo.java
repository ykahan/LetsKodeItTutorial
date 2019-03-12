package StartingOut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {

	public static void main(String[] args) {
		String chromeProperty = "webdriver.chrome.driver";
		String chromePath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\chromedriver.exe";
		System.setProperty(chromeProperty, chromePath);

		WebDriver cd = new ChromeDriver();
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cd.manage().window().maximize();

		String google = "http://www.google.com";
		String nro = "https://www.nationalreview.com/";

		cd.get(google);

	}

}
