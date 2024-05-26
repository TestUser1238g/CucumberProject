package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.Common;

public class DashboardPage extends Common{
	
	public WebDriver driver;
	public DashboardPage dashboardPage;
	
	public DashboardPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".oxd-text.oxd-text--h6")
	private WebElement dashBoardTitle;
	
	@FindBy(css=".oxd-userdropdown-name")
	WebElement userIcon;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logOut;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminBtn;
	
	

	public String verifyDashboardTitle() {
		return dashBoardTitle.getText();
	}
	
	
	public void logoutApp() {
		userIcon.click();
		logOut.click();
	}
	
	
	public AdminPage clickOnAdminBtn() throws InterruptedException {
		
		adminBtn.click();
		return new AdminPage(driver); 
	}

}
