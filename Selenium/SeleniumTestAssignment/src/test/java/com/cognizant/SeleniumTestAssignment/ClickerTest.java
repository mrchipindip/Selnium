package com.cognizant.SeleniumTestAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ClickerTest {
	
//	static //static WebDriver driver;
//	WebDriver driver = Runner.driver;
//	
	@Before
	public void setup() {
		System.out.println("Before");
		//System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/Chromedriver.exe");
		//driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		System.out.println("After");
		
	}
	
	@BeforeClass
	public static void initial() {
		System.out.println("LadsLadsLads");
	}
	
	@AfterClass
	public static void AtTheEnd() {
		System.out.println("Wooo");
		Runner.driver.quit();
	}
	
	@Test
	public void cheatGame() throws InterruptedException, IOException
	{
		
		int count = 0, routeNum = 1;
		String[] split;
		Action action;
		Runner.driver.get("https://ishadijcks.github.io/");
		Thread.sleep(2000);
		WebElement starter = Runner.driver.findElement(By.xpath("//*[@id=\"Charmander\"]")); 
		starter.click();
		WebElement starterBut = Runner.driver.findElement(By.xpath("//*[@id=\"startAdventure\"]"));
		starterBut.click();
		
		WebElement curRouteKilled = Runner.driver.findElement(By.xpath("//*[@id=\"currentRoute\"]"));
		WebElement nexRoute = Runner.driver.findElement(By.xpath("//*[@id=\"route_2\"]"));
		
		WebElement enemy = Runner.driver.findElement(By.xpath("//*[@id=\"currentEnemy\"]"));
		Thread.sleep(2000);
		
		
		
		for(int i = 0; i < Integer.MAX_VALUE; i++)
		{
			split = curRouteKilled.getText().split(" ")[curRouteKilled.getText().split(" ").length - 1].split("/");
			
			
			if(Integer.parseInt(split[0].substring(2, split[0].length())) != Integer.parseInt(split[1]))
			{
				System.out.println(Integer.parseInt(split[0].substring(2, split[0].length())));
				System.out.println(Integer.parseInt(split[1]));
				enemy.click();
			}
			else
			{

				//new Actions(driver).moveByOffset(100, 100).click().perform();
				System.out.println("hi");
				Thread.sleep(100);				
				((JavascriptExecutor)Runner.driver).executeScript("document.getElementById(\"rightColumn\").removeChild(document.getElementById(\"oakModal\"));");
				Thread.sleep(1000);
				System.out.println("hi");
				((JavascriptExecutor)Runner.driver).executeScript("document.body.removeChild(document.getElementByClassName(\"modal-backdrop fade in\"));");
				Thread.sleep(100);
				Thread.sleep(100000000);
//				nexRoute = driver.findElement(By.id("route_2"));
//				System.out.println("him");
//				nexRoute.click();
//				Thread.sleep(10000);
//				System.out.println("helllo");

			}
			
			
			
			
//			if(count > 10)
//			{
//				count = 0;
//				System.out.println(split[0].substring(2, split[0].length()));
//			}
//			else
//			{
//				System.out.println(split[0].substring(2, split[0].length()));
//				enemy.click();
//				count++;
//			}
		}
		
		Thread.sleep(12000);
		
	}
//		File newFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		System.out.println(newFile.getAbsolutePath());
//		
//		copy(newFile.getAbsolutePath(), "C//Users//Admin//Desktop//pic.png");
//		Thread.sleep(60000);
//		
//	}
//	
//	public static void copy(String inFile, String outFile) throws IOException
//	{
//		byte[] bytes = new byte[128];
//		
//		FileInputStream fis = new FileInputStream(inFile);
//		FileOutputStream fos = new FileOutputStream(outFile);
//		int count = 0, read = 0;
//		
//		while((read = fis.read(bytes)) != -1)
//		{
//			fos.write(bytes, 0, read);
//			count += read;
//		}
//		fis.close();
//		fos.close();
//	}

	
}
