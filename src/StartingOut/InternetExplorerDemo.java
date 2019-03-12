package StartingOut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDemo {

	public static void main(String[] args) {
		String ieProperty = "webdriver.ie.driver";
		String iePath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\IEDriverServer.exe";
		System.setProperty(ieProperty, iePath);

		WebDriver ied = new InternetExplorerDriver();
		ied.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ied.manage().window().maximize();

		String google = "http://www.google.com";
		String nro = "https://www.nationalreview.com/";

		ied.get(nro);

	}
}
