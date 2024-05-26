package Vibrant.TestAutomation;

import org.testng.annotations.Test;


import PageObjects.AdminPage;
import Vibrant.DriverFactory.BaseTest;
import Vibrant.DriverFactory.Retry;

public class Test2 extends BaseTest{
	
	
	
	@Test(groups= {"smoke"} , retryAnalyzer=Retry.class)
	public void searchUser() throws InterruptedException {
		
		AdminPage adminPage=dashboardPage.clickOnAdminBtn();
		adminPage.enterUserNamefield("Admin");
		adminPage.clickSubmitBtn();
		
	}

}
