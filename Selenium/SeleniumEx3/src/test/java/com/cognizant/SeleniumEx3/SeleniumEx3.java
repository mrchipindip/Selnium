package com.cognizant.SeleniumEx3;


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

public class SeleniumEx3 {

WebDriver driver;
	
public static String padRight(String s, String n) {
	String temp = s;
	for (int i = s.length(); i < 7; i++)
	{
		temp = temp + "" + n;
	}
	
    return temp;  
}

	public String doReplace(String toBeC) {
		
		String temp = toBeC;
		
		if(toBeC.contains("."))
		{
			temp = temp.replace(".", "");
			temp = temp + "000";
		}
		
		if(toBeC.contains(","))
		{
			temp = temp.replace(",", "");
		}
		
		if(toBeC.contains(" million"))
		{
			temp = temp.replace(" million", "");
			temp = padRight(temp, "0");
		}
		return temp;
	}

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
	
//	@Test
//	public void cheatGame() throws InterruptedException
//	{
//		boolean temp1 = false;
//		boolean temp2 = false;
//		boolean temp3 = false;
//		int buildingsEnabled = 0;
//		driver.manage().window().maximize();
//		driver.get("http://orteil.dashnet.org/cookieclicker/");
//		Thread.sleep(1500);
//		WebElement cookie = driver.findElement(By.xpath("//*[@id=\"cookieAnchor\"]"));
//		int count = 0;
//		int gWorth = 8;
//		int fWorth = 6;
//		int upgTimes = 0;
//		WebElement buttonssBookNow = driver.findElement(By.xpath("//*[@id=\"cookies\"]"));
//		//*[@id="product0"]
//		WebElement clickersUpg = driver.findElement(By.xpath("//*[@id=\"product0\"]"));
//		WebElement grannyUpg = driver.findElement(By.xpath("//*[@id=\"productPrice1\"]"));
//		WebElement grannyUpgCont = driver.findElement(By.xpath("//*[@id=\"product1\"]"));
//		WebElement farmUpg = driver.findElement(By.xpath("//*[@id=\"productPrice2\"]"));
//		WebElement farmUpgCont = driver.findElement(By.xpath("//*[@id=\"product2\"]"));
//		WebElement buttonsBookNow = driver.findElement(By.xpath("//*[@id=\"productPrice0\"]"));
//		WebElement mineUpg = driver.findElement(By.xpath("//*[@id=\"productPrice3\"]"));
//		WebElement mineUpgCont = driver.findElement(By.xpath("//*[@id=\"product3\"]"));
//
//
//		WebElement factoryUpgCont = driver.findElement(By.xpath("//*[@id=\"product4\"]"));
//		WebElement factoryUpg = driver.findElement(By.xpath("//*[@id=\"productPrice4\"]"));
//		WebElement bankUpgCont = driver.findElement(By.xpath("//*[@id=\"product5\"]"));
//		WebElement bankUpg = driver.findElement(By.xpath("//*[@id=\"productPrice5\"]"));
//		
//		
//		
//		//*[@id="upgrade0"]
//		//*[@id="upgrade0"]
//		
//		for (int i = 0; i < Integer.MAX_VALUE; i++)
//		{
//			
//			if(count >=10) {
//				
//				
//				
//				String[] parts = buttonssBookNow.getText().split(" ");
//				if(temp1 == true)
//				{
//					if(buildingsEnabled == 1)
//					{
//						if(driver.findElements(By.id("upgrade0")).size() != 0 && driver.findElement(By.id("upgrade0")).getAttribute("class").equals("crate upgrade enabled"))
//						{
//							upgTimes++;
//							driver.findElement(By.id("upgrade0")).click();
//							if(upgTimes == 3)
//							{
//								gWorth = gWorth/2;
//							}
//							else if(upgTimes == 4)
//							{
//								gWorth = gWorth/2;
//							}
//							else if(upgTimes == 7)
//							{
//								fWorth = fWorth/2;
//								System.out.println("Done");
//								gWorth = 4;
//							}
//						}
//						
//						if(Integer.parseInt(doReplace(buttonsBookNow.getText())) < Integer.parseInt(doReplace(parts[0])) && 10 * Integer.parseInt(doReplace(buttonsBookNow.getText())) < Integer.parseInt(doReplace(grannyUpg.getText()))) {
//							
//							clickersUpg.click();
//						}
//						else if(Integer.parseInt(grannyUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")) && gWorth * Integer.parseInt(grannyUpg.getText().replace(",", "")) < Integer.parseInt(farmUpg.getText().replace(",", "")))
//						{
//							grannyUpgCont.click();
//						}
//						else if(Integer.parseInt(farmUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")) && fWorth * Integer.parseInt(farmUpg.getText().replace(",", "")) < Integer.parseInt(mineUpg.getText().replace(",", "")))
//						{
//							farmUpgCont.click();
//						}
//						else if(Integer.parseInt(mineUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")) && 6 * Integer.parseInt(mineUpg.getText().replace(",", "")) < Integer.parseInt(factoryUpg.getText().replace(",", "")))
//						{
//							mineUpgCont.click();
//						}
//						else if(Integer.parseInt(factoryUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")))
//						{
//							factoryUpgCont.click();
//							buildingsEnabled = 2;
//							
//							bankUpgCont = driver.findElement(By.xpath("//*[@id=\"product5\"]"));
//							bankUpg = driver.findElement(By.xpath("//*[@id=\"productPrice5\"]"));
//						}
//						else
//						{
//							cookie.click();
//						}
//						count = 0;
//					}
//					else if(buildingsEnabled == 2)
//					{
//						if(driver.findElements(By.id("upgrade0")).size() != 0 && driver.findElement(By.id("upgrade0")).getAttribute("class").equals("crate upgrade enabled"))
//						{
//							upgTimes++;
//							driver.findElement(By.id("upgrade0")).click();
//							if(upgTimes == 3)
//							{
//								gWorth = gWorth/2;
//							}
//							else if(upgTimes == 4)
//							{
//								gWorth = gWorth/2;
//							}
//							else if(upgTimes == 7)
//							{
//								if(fWorth!=3)
//								{
//									fWorth = fWorth/2;
//									System.out.println("Done");
//									gWorth = 4;
//								}
//
//							}
//						}
//						
//						if(Integer.parseInt(doReplace(buttonsBookNow.getText())) < Integer.parseInt(doReplace(parts[0])) && 10 * Integer.parseInt(doReplace(buttonsBookNow.getText())) < Integer.parseInt(doReplace(grannyUpg.getText()))) {
//							
//							clickersUpg.click();
//						}
//						else if(Integer.parseInt(doReplace(grannyUpg.getText())) < Integer.parseInt(doReplace(parts[0])) && gWorth * Integer.parseInt(doReplace(grannyUpg.getText())) < Integer.parseInt(doReplace(farmUpg.getText())))
//						{
//							grannyUpgCont.click();
//						}
//						else if(Integer.parseInt(doReplace(farmUpg.getText())) < Integer.parseInt(doReplace(parts[0])) && fWorth * Integer.parseInt(doReplace(farmUpg.getText())) < Integer.parseInt(doReplace(mineUpg.getText())))
//						{
//							farmUpgCont.click();
//						}
//						else if(Integer.parseInt(doReplace(mineUpg.getText())) < Integer.parseInt(doReplace(parts[0])) && 6 * Integer.parseInt(doReplace(mineUpg.getText())) < Integer.parseInt(doReplace(factoryUpg.getText())))
//						{
//							mineUpgCont.click();
//						}
//						else if(Integer.parseInt(doReplace(factoryUpg.getText())) < Integer.parseInt(doReplace(parts[0])) && 6 * Integer.parseInt(doReplace(factoryUpg.getText())) < Integer.parseInt(doReplace(bankUpg.getText())))
//						{
//							factoryUpgCont.click();
//						}
//						else if(Integer.parseInt(doReplace(bankUpg.getText())) < Integer.parseInt(doReplace(parts[0]))) {
//							bankUpgCont.click();
//						}
//						else
//						{
//							cookie.click();
//						}
//						count = 0;
//					}
//					else
//					{
//						if(driver.findElements(By.id("upgrade0")).size() != 0 && driver.findElement(By.id("upgrade0")).getAttribute("class").equals("crate upgrade enabled"))
//						{
//							upgTimes++;
//							driver.findElement(By.id("upgrade0")).click();
//							if(upgTimes == 3)
//							{
//								gWorth = gWorth/2;
//							}
//							else if(upgTimes == 4)
//							{
//								gWorth = gWorth/2;
//							}
//							else if(upgTimes == 5)
//							{
//								if(fWorth!=3)
//								{
//									fWorth = fWorth/2;
//									System.out.println("Done");
//									gWorth = 4;
//								}
//							}
//							else
//							{
//								
//							}
//						}
//						
//						if(Integer.parseInt(doReplace(buttonsBookNow.getText())) < Integer.parseInt(doReplace(parts[0])) && 10 * Integer.parseInt(buttonsBookNow.getText().replace(",", "")) < Integer.parseInt(grannyUpg.getText().replace(",", ""))) {
//							
//							clickersUpg.click();
//						}
//						else if(Integer.parseInt(grannyUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")) && gWorth * Integer.parseInt(grannyUpg.getText().replace(",", "")) < Integer.parseInt(farmUpg.getText().replace(",", "")))
//						{
//							grannyUpgCont.click();
//						}
//						else if(Integer.parseInt(farmUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")) && fWorth * Integer.parseInt(farmUpg.getText().replace(",", "")) < Integer.parseInt(mineUpg.getText().replace(",", "")))
//						{
//							farmUpgCont.click();
//						}
//						else if(Integer.parseInt(mineUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")))
//						{
//							mineUpgCont.click();
//							buildingsEnabled = 1;
//
//							factoryUpgCont = driver.findElement(By.xpath("//*[@id=\"product4\"]"));
//							factoryUpg = driver.findElement(By.xpath("//*[@id=\"productPrice4\"]"));
//						}
////						else if(Integer.parseInt(factoryUpg.getText().replace(",", "")) < Integer.parseInt(parts[0].replace(",", "")))
////						{
////							factoryUpgCont.click();
////						}
//						else
//						{
//							cookie.click();
//						}
//						count = 0;
//					}
//					
//				}
//				else
//				{
//					if(Integer.parseInt(parts[0]) > 100)
//					{
//						if(temp2 == false)
//						{
//							//Do 100 upg
//							Thread.sleep(100);
//							WebElement bigClick = driver.findElement(By.xpath("//*[@id=\"upgrade0\"]"));
//							Thread.sleep(100);
//							bigClick.click();
//							upgTimes++;
//							temp2 = true;
//							
//						}
//						else if (Integer.parseInt(parts[0]) > 500)
//						{
//							Thread.sleep(100);
//							WebElement biggestClick = driver.findElement(By.xpath("//*[@id=\"upgrade0\"]"));
//							Thread.sleep(100);
//							biggestClick.click();
//							upgTimes++;
//							temp1 = true;
//							
//						}
//						else
//						{
//							cookie.click();
//						}
//					}
//					else if(Integer.parseInt(parts[0]) > 15 && temp3 == false)
//					{
//						clickersUpg.click();
//						temp3 = true;
//					}
//					else
//					{
//						cookie.click();
//					}
//					
//					count = 0;
//					
//				}
//			}
//			else
//			{
//				cookie.click();
//				count++;
//			}
//
//		}
//		Thread.sleep(1500);
//	}
	
	@Test
	public void addUser() throws InterruptedException {
		System.out.println("Test3");
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/hotels/detail/london/grand-plaza-apartments/11-12-2018/15-12-2018/2/0");
		Thread.sleep(1500);
		WebElement cbxRoomSelect = driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/table/tbody/tr[2]/td/div[2]/div[2]/div/div[3]/div/label/div"));
		cbxRoomSelect.click();
		Thread.sleep(1500);
		
		WebElement buttonBookNow = driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/button"));
		buttonBookNow.click();
		Thread.sleep(1500);
		
		WebElement textBoxName = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[1]/div[2]/input"));
		textBoxName.sendKeys("Dress");
		WebElement textBoxName2 = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[1]/div[3]/input"));
		textBoxName2.sendKeys("Dresss");
		
		WebElement textBoxEmail = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[2]/div[2]/input"));
		textBoxEmail.sendKeys("Dress@Dress.com");
		WebElement textBoxEmail2 = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[2]/div[3]/input"));
		textBoxEmail2.sendKeys("Dress@Dress.com");
		Thread.sleep(1500);
		
		WebElement buttonStartDates = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div/div/div[1]/div/div[1]/div[2]/div[4]/button"));
		buttonStartDates.click();
		Thread.sleep(8500);

		WebElement textItems = driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]/tbody/tr[2]/td/div[1]/table/tbody/tr/td/div[3]"));
		assertEquals("Failed to find invoice", "INVOICE", textItems.getText());
		Thread.sleep(1500);

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
