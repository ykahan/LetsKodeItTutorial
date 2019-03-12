package StartingOut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDemo {

	public static void main(String[] args) {
		String edgeProperty = "webdriver.edge.driver";
		String edgePath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\MicrosoftWebDriver.exe";
		System.setProperty(edgeProperty, edgePath);

		WebDriver ed = new EdgeDriver();

	}

}
