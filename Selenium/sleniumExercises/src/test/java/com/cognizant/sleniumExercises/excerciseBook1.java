package com.cognizant.sleniumExercises;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.ArrayList;

public class excerciseBook1 {

	WebDriver driver;
	static ExtentReports reports;
	ExtentTest test;
	 static ArrayList<String> userData= new ArrayList<String>();
	 static XSSFSheet sheet;
	 static FileInputStream file;
	 static XSSFWorkbook workbook;
	
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
		reports.endTest(test);
		reports.flush();
		
	}
	
	@BeforeClass
	public static void initial() throws IOException {
		System.out.println("LadsLadsLads");
		
		reports = new ExtentReports("C:/Users/Admin/Desktop/Foldery/Reporty.html", true);
		
		file = new FileInputStream("C:/Users/Admin/Desktop/DemoSiteDDT.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		

		
		for(int i = 1;i < sheet.getPhysicalNumberOfRows(); i++)
		{
			for(int j = 0; j<sheet.getRow(i).getPhysicalNumberOfCells(); j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				userData.add(cell.getStringCellValue());
			}
		}
		for(int i = 0; i < userData.size(); i++)
		{
			System.out.println(userData.get(i));
		}
		
		
	}
	
	@AfterClass
	public static void AtTheEnd() {
		System.out.println("Wooo");
	}
	
	@Test
	public void addUser() throws InterruptedException, IOException {
		
		for(int i = 0; i < userData.size() /3; i++)
		{
			test = reports.startTest("Adding a User and Logging in");
			System.out.println("Test3");
			driver.manage().window().maximize();
			driver.get("http://thedemosite.co.uk/savedata.php");
			WebElement textBoxUser = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
			textBoxUser.sendKeys(userData.get(i * 3));
			test.log(LogStatus.INFO, "Username entered");
			WebElement textBoxPass = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
			textBoxPass.sendKeys(userData.get(i * 3 + 1));
			test.log(LogStatus.INFO, "Password entered");

			Thread.sleep(500);
			
			WebElement buttonSubmit = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
			buttonSubmit.click();
			
			WebElement savedDetails = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]"));
			String[] temp = savedDetails.getText().split(" ");
			System.out.println("----");
			System.out.println(temp[temp.length - 1]);
			System.out.println(userData.get(i * 3 + 1));
			System.out.println("----");
			if(!temp[temp.length - 1].equals(userData.get(i * 3 + 1)))
			{
				test.log(LogStatus.FAIL, "Password used not full");
			}
			
			System.out.println(temp[temp.length - 1]);
			
			
			test.log(LogStatus.INFO, "Details saved");
			Thread.sleep(500);
			
			WebElement buttonLoginPage = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
			buttonLoginPage.click();
			
			WebElement textLoginUser = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
			textLoginUser.sendKeys(userData.get(i * 3));
			
			WebElement textLoginPass = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
			textLoginPass.sendKeys(userData.get(i * 3 + 1));

			Thread.sleep(500);
			
			WebElement buttonLoginSubmit = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
			buttonLoginSubmit.click();
			test.log(LogStatus.INFO, "Login attempt made");
			Thread.sleep(500);
			
			WebElement textSuccess = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
			//assertEquals("Checking", "**Successful Login**", textSuccess.getText());
			
			XSSFRow row = sheet.getRow(i + 1);
			XSSFCell cell = row.createCell(3);
			cell.setCellValue(textSuccess.getText());
			
			if(textSuccess.getText().equals(userData.get(i * 3 + 2))) {
				test.log(LogStatus.PASS, "Login Successful");
			}
			else {
				test.log(LogStatus.FAIL, "Login Failed");
				fail();
			}
			Thread.sleep(500);
		}
		
		file.close();
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDTN.xlsx");
		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	@Test
	public void seleniumTest() {
		test = reports.startTest("SECOND REPORT TEST");
		test.log(LogStatus.PASS, "IT WORKS");
	}
//	
//	@Test
//	public void testy() {
//		System.out.println("Test1");
//	}
	
}
