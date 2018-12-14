package com.cognizant.CucumberFirst;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	
	WebDriver driver;
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) throws Throwable {
		driver.get(arg1);
		Thread.sleep(1000);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		searchBar.sendKeys(arg1);
		Thread.sleep(100);
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"sb_form_go\"]"));
		searchButton.click();
		Thread.sleep(1000);
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	

	@Before
	public void setup() {
		System.out.println("Before");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		System.out.println("After");
		driver.quit();
		
	}
//	
//	@BeforeClass
//	public static void initial() {
//		System.out.println("LadsLadsLads");
//	}
//	
//	@AfterClass
//	public static void AtTheEnd() {
//		System.out.println("Wooo");
//	}
//	
//	
//	@Given("^the correct web address$")
//	public void the_correct_web_address() throws Throwable {
//		driver.get("http://automationpractice.com/index.php");
//		Thread.sleep(1000);
//		Assert.assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
//	}
//
//	@When("^I navigate to the 'Menu' page$")
//	public void i_navigate_to_the_Menu_page() throws Throwable {
//		WebElement menuBar = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"));
//		menuBar.click();
//		Thread.sleep(1000);
//		Assert.assertEquals("http://automationpractice.com/index.php?id_category=3&controller=category", driver.getCurrentUrl());
//	}
//
//	@Then("^I can browse a list of the available products\\.$")
//	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
//		List<WebElement> items = driver.findElements(By.cssSelector("ul[class='product_list grid row']"));
//		Assert.assertEquals(1, items.size());
//	}
//
//	@When("^I click the checkout button$")
//	public void i_click_the_checkout_button() throws Throwable {
//		WebElement checkOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
//		checkOut.click();
//	}
//
//	@Then("^I am taken to the checkout page$")
//	public void i_am_taken_to_the_checkout_page() throws Throwable {
//		Assert.assertEquals("http://automationpractice.com/index.php?controller=order", driver.getCurrentUrl());
//	}

	
}
