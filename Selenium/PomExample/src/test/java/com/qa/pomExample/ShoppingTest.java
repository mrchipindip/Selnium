package com.qa.pomExample;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingTest {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Chris/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void shopping() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
//		OLD WAY
//		WebElement searchBar = driver.findElement(By.id("search_query_top"));
//		searchBar.sendKeys("Dress");
//		searchBar.submit();
		
//		BETTER WAY
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.search("Skirt");
		
		SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
//		WebElement element2 = driver.findElement(By.cssSelector("ul[class='product_list grid row']"));
//		WebElement element2 = searchPage.unorderList;
		
//		List<WebElement> listy = element2.findElements(By.tagName("li"));
//		List<WebElement> listy = searchPage.items;
		
		if (searchPage.find("Printed Chiffon Dress")) {
		}
		else {
			fail();
		}
	}
}
