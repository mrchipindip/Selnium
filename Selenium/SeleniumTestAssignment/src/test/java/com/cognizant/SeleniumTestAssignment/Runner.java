package com.cognizant.SeleniumTestAssignment;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "C:\\Users\\Admin\\Desktop\\EclipseWorkspace\\CucumberFirst\\src\\test\\java\\com\\cognizant\\CucumberFirst\\Parametisation.feature")
public class Runner {
	
	static WebDriver driver;
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		start();
		driver.quit();
	}
	
	public static void start()
	{
		Result result = JUnitCore.runClasses(ClickerTest.class); 
	}
}
