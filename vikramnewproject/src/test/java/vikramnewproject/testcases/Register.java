package vikramnewproject.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Utils.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import vikramnewproject.base.BaseClass;

public class Register extends BaseClass {
	public Register() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	    driver = initializeBrowser(prop.getProperty("browser"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisterAnAccountwithMandatoryFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys( Utilities.getTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpass"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpass"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	@Test(priority=2)
	public void verifyRegisterAnAccountwithEmptyFields() {
		
		/*driver.findElement(By.id("input-firstname")).sendKeys();
		driver.findElement(By.id("input-lastname")).sendKeys();
		driver.findElement(By.id("input-email")).sendKeys();
		driver.findElement(By.id("input-telephone")).sendKeys();
		driver.findElement(By.id("input-password")).sendKeys();
		driver.findElement(By.id("input-confirm")).sendKeys();
		driver.findElement(By.xpath("//input[@name='agree']")).click();*/
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//String actualPrivacyWarning="";
	}
	
	@Test(priority=3)
	public void verifyRegisterAnAccountwithSubscribeMandatoryFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys( Utilities.getTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpass"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpass"));
		driver.findElement(By.xpath("//input[@value='1'][@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

}
