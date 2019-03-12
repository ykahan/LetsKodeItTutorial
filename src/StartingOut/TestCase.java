package StartingOut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestCase {
	
	public static void main(String[] args){
		System.out.println("Hello Test World with WebDrivers");
		WebDriver firefox = new FirefoxDriver();
		WebDriver chrome = new ChromeDriver();
		WebElement element = chrome.findElement(By.id(""));
		WebDriver opera = new OperaDriver();
	}

}
