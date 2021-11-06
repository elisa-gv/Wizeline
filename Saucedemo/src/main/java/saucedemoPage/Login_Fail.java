package saucedemoPage;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Login_Fail {
	@Test
	public void testNGAsserts() throws Exception{
		// Source file (spreadsheet)
		FileInputStream fs = new FileInputStream("./src/test/resources/LoginWrongCredentials.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		DataFormatter df = new DataFormatter();
		String user = df.formatCellValue(sheet.getRow(1).getCell(0));
		String password = df.formatCellValue(sheet.getRow(1).getCell(1));
		
		// Chrome and Firefox to make it work for multiple browsers
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
		WebDriver driver = new ChromeDriver();	
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver");
		WebDriver driver2 = new FirefoxDriver();
		
		// ExtentReports
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Login.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest logStep = extent.createTest("Login", "Login with a valid user");
		
	logStep.info("Step 1: Open website (Firefox and Chrome)");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Swag Labs");
		driver2.get("https://www.saucedemo.com/");
		driver2.manage().window().maximize();
		System.out.println(title);
		Assert.assertEquals(title, "Swag Labs");
        System.out.println("AssertEquals Test Passed, initial URL is correct");
		Thread.sleep(1000);
		
	logStep.info("Step 2: Enter the credentials and click login button");		
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(user);
		driver2.findElement(By.xpath("//*[@id='user-name']")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver2.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		driver2.findElement(By.xpath("//*[@id='login-button']")).click();
		Thread.sleep(1000);
		
	logStep.info("Step 3: Asserting if login failed and expected error is displayed");		
        String expText = "Epic sadface: Username and password do not match any user in this service";
        String expText2 = "Epic sadface: Username and password do not match any user in this service";
		String errorMessage = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']")).getText();
		String errorMessage2 = driver2.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']")).getText();
        Assert.assertEquals(errorMessage, expText);
        Assert.assertEquals(errorMessage2, expText2);
        System.out.println(errorMessage);
        System.out.println(errorMessage2);
        logStep.pass("Login failed"); 
		driver.close();
		driver2.close();
	logStep.info("End of the test");
	extent.flush();
	

	}
}