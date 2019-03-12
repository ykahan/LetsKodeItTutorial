package StartingOut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDemo {

	public static void main(String[] args) {
//		String firefoxProperty = "webdriver.gecko.driver";
//		String firefoxPath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\geckodriver.exe";
//		System.setProperty(firefoxProperty, firefoxPath);
//		
//		WebDriver ffd = new FirefoxDriver();
		WebDriver ffd = Repo.getFireFoxDriver();
		ffd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ffd.manage().window().maximize();
		
		String google = "http://www.google.com";
		String nro = "https://www.nationalreview.com/";
		
		ffd.get(nro);

	}

}
