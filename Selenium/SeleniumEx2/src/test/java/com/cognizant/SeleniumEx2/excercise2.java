package com.cognizant.SeleniumEx2;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class excercise2 {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.out.println("Before");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/Chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		System.out.println("After");
		driver.quit();
		
	}
	
	@BeforeClass
	public static void initial() {
		System.out.println("LadsLadsLads");
	}
	
	@AfterClass
	public static void AtTheEnd() {
		System.out.println("Wooo");
	}
	
	@Test
	public void addUser() throws InterruptedException {
		System.out.println("Test3");
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement textBoxSearch = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		textBoxSearch.sendKeys("Dress");
		Thread.sleep(500);
		WebElement buttonSearch = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		buttonSearch.click();

		Thread.sleep(500);
		
		WebElement textItems = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]"));
		assertFalse("Check", (textItems.getText() == "            0 results have been found.        "));
		
	}
	
//	@Test
//	public void seleniumTest() {
//		System.out.println("Test2");
//	}
//	
//	@Test
//	public void testy() {
//		System.out.println("Test1");
//	}
	
}
