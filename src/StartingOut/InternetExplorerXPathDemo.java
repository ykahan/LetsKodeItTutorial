package StartingOut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerXPathDemo {

	public static void main(String[] args) throws InterruptedException {
		String ieProperty = "webdriver.ie.driver";
		String iePath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\IEDriverServer.exe";
		System.setProperty(ieProperty, iePath);

		WebDriver ied = new InternetExplorerDriver();
		ied.manage().window().maximize();
		ied.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String google = "http://www.google.com";
		String nro = "https://www.nationalreview.com/";

		ied.get(google);
//		ied.findElement(By.xpath("//a[@class='language_link']")).click();
		ied.findElement(By.xpath("//input[@id='query_field_2']")).sendKeys("letskodeit");
		ied.findElement(By.className("searchButton")).click();
		ied.findElement(By.linkText("Practice | Let's Kode It")).click();
		ied.findElement(By.id("opentab")).click();
//		ied.findElement(By.xpath("//input[@id='search-courses']")).sendKeys("Calculus");
//		ied.findElement(By.partialLinkText("Log")).click();
//		ied.findElement(By.id("user_email")).sendKeys("GarfieldTheCat");
//		ied.findElement(By.id("user_password")).sendKeys("Lasagna");
//		ied.findElement(By.xpath("//input[@name='commit']")).click();
		
//		ied.findElement(By.xpath("//input[@id='query_field_2']")).click();
//		ied.findElement(By.xpath("//button[@class='searchButton']")).click();
//		ied.findElement(By.xpath("//a[@href='https://learn.letskodeit.com/p/practice' and @class='result_title']")).click();
		
		

	}

}
