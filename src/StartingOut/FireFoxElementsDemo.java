package StartingOut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxElementsDemo {

	public static void main(String[] args) {
		String firefoxProperty = "webdriver.gecko.driver";
		String firefoxPath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\geckodriver.exe";
		System.setProperty(firefoxProperty, firefoxPath);
		
		WebDriver ffD = new FirefoxDriver();
		ffD.manage().window().maximize();
		ffD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String letskodeit = "https://learn.letskodeit.com/";
		String nro = "https://www.nationalreview.com/";
		
		ffD.manage().window().maximize();		
		ffD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ffD.get(letskodeit);
//		driver.findElement(By.linkText("Practice")).click();
		
		System.out.println("Random click coming up");
		ffD.findElement(By.tagName("a")).click(); 
		// the above seems to just get ignored, except that it stops ffD.close() from working
		System.out.println("After random click");
		
		ffD.close();
	}

}
