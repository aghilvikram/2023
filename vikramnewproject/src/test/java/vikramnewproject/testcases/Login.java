package vikramnewproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.HomePageObject;
import PageObjects.LoginPage;
import Utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import vikramnewproject.base.BaseClass;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login extends BaseClass{
	public Login() throws Throwable {
		super();
		
	}

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	    driver = initializeBrowser(prop.getProperty("browser"));
	    HomePageObject hp=new HomePageObject(driver);
	    hp.clickOnMyAccount();
	    hp.clickOnLogin();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.xpath("//a[text()='Login']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@DataProvider(name="datas")
	public Object[][] supplyData() {
		Object[][] data= {{"vikram@gmail.com","12345"},
				          {"devi@gmail.com","12345"},
				          {"aghil@gmail.com","12345"}};
		return data;
	}
	@DataProvider(name="exceldatas")
	public Object[][] supplyDataExcel() throws Throwable {
		Object[][] data=Utilities.getTestDataFromExcel("Login") ;
		//System.out.println(data);
		return data;
	}
	
	
	
	@Test(priority=1, dataProvider="exceldatas")
	public void verifyLoginCredentials(String uname,String Password ) throws Exception {
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(uname);
		lp.enterPass(Password);
		lp.clickLoginbtn();
		//driver.findElement(By.id("input-email")).sendKeys(uname);
		//driver.findElement(By.id("input-password")).sendKeys(Password);
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		AccountPage ap=new AccountPage(driver);
		boolean actualValue = ap.displayAccountInfo();
		//String actualValue = driver.findElement(By.linkText("Edit your account information")).getText();
		Assert.assertTrue(actualValue);
		//Assert.assertEquals(actualValue, "Edit your account information");
		//Thread.sleep(4000);
		//driver.close();
		
	}
	
	
	/*@Test(priority=1)
	public void verifyLoginCredentials() throws Exception {
		
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpass"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.linkText("Edit your account information")).getText();
		Assert.assertEquals(actualValue, "Edit your account information");
		//Thread.sleep(4000);
		//driver.close();
		
	}*/
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidemailValidPassCredentials() throws Exception {
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpass"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actual = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(actual);
		String expected=dataProp.getProperty("expectedWarningMsg");
		Assert.assertTrue(actual.contains(expected), "success");
		//Thread.sleep(4000);
		//driver.close();
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidpassvalidemailCredentials() throws Exception {
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actual = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(actual);
		String expected=dataProp.getProperty("expectedWarningMsg");
		Assert.assertTrue(actual.contains(expected), "success");
		//Thread.sleep(4000);
		//driver.close();
	}
	
	@Test(priority=4)
	public void verifyLoginWithInvalidpassinvalidemailCredentials() throws Exception {
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actual = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(actual);
		String expected=dataProp.getProperty("expectedWarningMsg");
		Assert.assertTrue(actual.contains(expected), "success");
		//Thread.sleep(4000);
		//driver.close();
	}
	
	public static String generateTimeStamp() {
		Date date=new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return timeStamp;
	}

}
