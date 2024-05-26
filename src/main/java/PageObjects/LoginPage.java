package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.Common;

public class LoginPage extends Common{
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name= "username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement dashboardBtn;
	
	
	public DashboardPage loginToApplication() {
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		submit.click();
		dashboardBtn.click();
		return new DashboardPage(driver);
	}
	
	

}
