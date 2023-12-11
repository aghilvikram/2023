package vikramnewproject.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import Utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;

public class BaseClass {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public WebDriver initializeBrowser(String browserName) {
		WebDriverManager.chromedriver().setup();
		//String browserName="edge";
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.ImplicitWaitTime));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public  BaseClass() throws Throwable  {
	     prop=new Properties();
	     
	     dataProp=new Properties();
	    		 
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		
		File propFiles=new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.properties");
		FileInputStream files=new FileInputStream(propFiles);
		dataProp.load(files);
		
		
	}

}
