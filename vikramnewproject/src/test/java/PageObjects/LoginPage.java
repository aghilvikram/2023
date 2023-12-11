package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="input-email")
	WebElement emailAddressField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,LoginPage.class);
	}
	
	public void enterEmail(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public void enterPass(String pass) {
		passwordField.sendKeys(pass);
	}
	
	public void clickLoginbtn() {
		loginButton.click();
	}
	
	

}
