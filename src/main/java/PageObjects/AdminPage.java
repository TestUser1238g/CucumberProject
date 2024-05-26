package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.Common;

public class AdminPage extends Common{

	WebDriver driver;
	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By dashboardInvisibleEle = By.xpath("//h6[text()='Dashboard']");
	
	@FindBy(xpath="//h6[text()='Admin']")
	private WebElement adminPageTitle;
	
	@FindBy(xpath="//input[@fdprocessedid='nakle8']")
	private WebElement enterUserField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickOnSubmitBtn;
	
	
	public String verifyAdminPageTitle() throws InterruptedException {
		waitForElementInvisible(dashboardInvisibleEle);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		return adminPageTitle.getText();
		
	}
	
	public void enterUserNamefield(String user) {
		enterUserField.sendKeys(user);
	}
	
	public void clickSubmitBtn() {
		clickOnSubmitBtn.click();
	}
}
