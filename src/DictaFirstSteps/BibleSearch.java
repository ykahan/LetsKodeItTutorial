package DictaFirstSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BibleSearch {

	public static void main(String[] args) throws InterruptedException {
		String chromeProperty = "webdriver.chrome.driver";
		String chromePath = "C:\\Users\\USER\\Java_Workspace_Yehoshua\\Selenium Dependencies\\chromedriver.exe";
		System.setProperty(chromeProperty, chromePath);
		
		WebDriver cd = new ChromeDriver();
		
		String bibleSearch = "https://experintsol--cranky-banach-377068.netlify.com/";
		String searchBox = "//div[@id='home']/div[@class='container']//form[@class='home-search-form']/input[@class='form-control home-search-fControl']";
		String searchButton = "//div[@id='home']/div[@class='container']//form[@class='home-search-form']/button[2]";
		String meaningsAndSyns = "//div[@id='app']//div[@class='result-main']/div[2]/div[@class='main-contant']/div[@class='list-holder']//div[@class='sidebar']//ul[@class='desktop-sidebar-accordion']/li[@class='accordion-li']//span[.='Meanings and synonyms']";
		String meaningsSelectAll = "//div[@id='app']//div[@class='result-main']/div[2]/div[@class='main-contant']/div[@class='list-holder']/div[@class='row']//div[@class='sidebar']//ul[@class='desktop-sidebar-accordion']/li[@class='accordion-li']//ul[@class='inner-accordion']//ul[@class='inner-ul']//label[@class='control control--checkbox selectAll']/div/div";
		String davidProperName = "//div[@id='app']//div[@class='result-main']/div[2]/div[@class='main-contant']/div[@class='list-holder']//div[@class='sidebar']//ul[@class='desktop-sidebar-accordion']/li[@class='accordion-li']//ul[@class='inner-accordion']//ul[@class='inner-ul']//ul[@class='slide-list']/li[1]/label[@class='control control--checkbox']/p/span[@class='f-narkis']";
		long waitTime = 2000;
		
		cd.manage().window().maximize();
		cd.get(bibleSearch);
		
		cd.findElement(By.xpath(searchBox)).sendKeys("sus");
		cd.findElement(By.xpath(searchButton)).click();
		cd.findElement(By.xpath(meaningsAndSyns)).click();
//		cd.wait(waitTime);
		cd.findElement(By.xpath(meaningsSelectAll)).click();
//		cd.wait(waitTime);
		cd.findElement(By.xpath(davidProperName)).click();
//		cd.wait(waitTime);
//		cd.close();
	}

}
