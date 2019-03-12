package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import StartingOut.Repo;

class SliderActions {

		WebDriver driver;
		StartingOut.ExplicitlyWait ew;
		String practiceSite;
		String dicta;
		String jQuerySlider;

		@BeforeEach
		void setUpBeforeClass() throws Exception {
			practiceSite = Repo.getPracticeSite();
			dicta = Repo.getDicta();
			jQuerySlider = "http://jqueryui.com/slider/";
			driver = Repo.getChromeDriver();
			driver.manage().window().maximize();
			ew = new StartingOut.ExplicitlyWait(driver);
			System.out.println("Setup complete");
		}

		@AfterEach
		void tearDownAfterClass() throws Exception {
			Thread.sleep(2000);
//			driver.quit();
			System.out.println("Teardown complete");
		}

		@Test
		void test() {
			driver.get(jQuerySlider);
			driver.switchTo().frame(0);
			
			WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
			Actions actions = new Actions(driver);
			int offset = 0;
			while(offset < 250) {
				actions.dragAndDropBy(slider, 10, 0).perform();
				offset += 10;
				System.out.println("Slider moved to " + offset);				
			}

		}


}
