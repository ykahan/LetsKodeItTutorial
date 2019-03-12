package StartingOut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedXpaths {

	public static void main(String[] args) throws InterruptedException {
		String practiceSite = "https://learn.letskodeit.com/p/practice";
		String dhtmlxSite = "https://dhtmlx.com/docs/products/dhtmlxGrid/";
		long waitTime = 1000;
//		WebDriver cd = openSite(practiceSite);
//		containsAndStartsWithKeywords(cd, waitTime);
//		siblings(cd, waitTime);
//		System.out.println("Python course costs $" + exercise1(cd, 1000));
//		end(cd);
		
		WebDriver cd = openSite(dhtmlxSite);
		System.out.println("Jeffery's address is " + exercise2(cd, 1000));
		System.out.println("Done");
		end(cd);

	}
	
	public static void siblings(WebDriver cd, long waitTime) throws InterruptedException{
		String practiceLI = "//div[contains(@class, 'scrolling')]//a[@href='/sign_in']//parent::li//following-sibling::li//preceding-sibling::li[2]";
		String loginLI = "//div[contains(@class, 'scrolling')]//a[@href='/sign_in']//parent::li";
		String signupLI = "//div[contains(@class, 'scrolling')]//a[@href='/sign_in']//parent::li//following-sibling::li";
		
	
		cd.findElement(By.xpath(loginLI)).click();
		Thread.sleep(waitTime * 5);
		cd.navigate().back();
		Thread.sleep(waitTime * 5);
		cd.findElement(By.xpath(signupLI)).click();
		
	}

	private static void end(WebDriver cd) throws InterruptedException {
		Thread.sleep(5000);
		cd.quit();
	}

	public static void containsAndStartsWithKeywords(WebDriver cd, long waitTime) throws InterruptedException {
		String bmwRadioButton = "//input[contains(@id, 'bmwrad')]";
		String benzRadioButton = "//input[contains(@id, 'benzrad')]";
		String hondaRadioButton = "//input[contains(@id, 'hondarad')]";
		String carsDropDown = "//select[contains(@name, 'ars')]";
		String benzDropDown = "//option[@value=\"benz\"]";
		String switchWindowButton = "//button[starts-with(@id, 'open')]";
		String hover = "//button[@id='mousehover']";


		cd.findElement(By.xpath(bmwRadioButton)).click();
		Thread.sleep(waitTime);
		cd.findElement(By.xpath(benzRadioButton)).click();
		Thread.sleep(waitTime);
		cd.findElement(By.xpath(hondaRadioButton)).click();
		Thread.sleep(waitTime);
		cd.findElement(By.xpath(carsDropDown)).click();
		Thread.sleep(waitTime);
		cd.findElement(By.xpath(benzDropDown)).click();
		Thread.sleep(waitTime);
		cd.findElement(By.xpath(hover)).click();
//		cd.findElement(By.xpath(switchWindowButton)).click();
		Thread.sleep(waitTime);
//		cd.close();
	}
	
	private static String exercise2(WebDriver cd, long waitTime) {
		String address = "//div[contains(@id, 'cgrid')]//td[contains(text(), 'Jeffery')]//following-sibling::td[1]";
		return cd.findElement(By.xpath(address)).getText();
	}

	private static String exercise1(WebDriver cd, long waitTime) {
		String pythonPrice = "//table[@id='product']//td[contains(text(), 'Python')]//following-sibling::td";
		
		return cd.findElement(By.xpath(pythonPrice)).getText();
	}
	private static WebDriver openSite( String url) {
		String chromeProperty = "webdriver.chrome.driver";
		String chromePath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\chromedriver.exe";

		System.setProperty(chromeProperty, chromePath);

		WebDriver cd = new ChromeDriver();
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cd.manage().window().maximize();
		cd.get(url);

		return cd;
	}
	

}
