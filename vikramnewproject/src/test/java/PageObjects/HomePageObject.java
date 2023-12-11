package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,HomePageObject.class);
	}
	
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	

}
