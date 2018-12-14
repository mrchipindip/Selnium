package com.cognizant.SeleTest;

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

public class FirstSelenium{

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
		Thread.sleep(1000);
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
	public void gettingElements() throws InterruptedException {
		System.out.println("Test3");
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/search?q=selenium&qs=n&form=QBLH&sp=-1&pq=selenium&sc=8-8&sk=&cvid=F74BC8DFD90B40A2B495EA8513D74FD6");
		
		WebElement textTest = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[2]/div/div[1]/h2"));
		assertEquals("Selenium not displayed", true, textTest.isDisplayed());
	}
	
	@Test
	public void seleniumTest() {
		System.out.println("Test2");
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		WebElement textBox = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		textBox.sendKeys("Dogs");
		textBox.submit();
	}
	
	@Test
	public void testy() {
		System.out.println("Test1");
	}
	
}
