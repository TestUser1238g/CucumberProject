package test.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import PageObjects.AdminPage;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import Vibrant.DriverFactory.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepDefinition extends BaseTest{
	
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public AdminPage adminPage;
	
	@Given("Login to portal")
	public void Login_to_portal() throws IOException {
		dashboardPage=launchApplication();
	}
	
	@Given("Click on Admin button")
	public void Click_on_Admin() throws InterruptedException {
		Assert.assertEquals("Admin", dashboardPage.verifyDashboardTitle(), "Dashboard Page Fail");
		adminPage = dashboardPage.clickOnAdminBtn();
		

	}
	@Then("^I verify the (.+) of the page$")
	public void I_verify_the_Title_of_the_page(String titleName) throws InterruptedException {
		Assert.assertEquals(titleName, adminPage.verifyAdminPageTitle(), "Admin page Failed");
	}
	
	@And("logout the Application")
	public void logout_the_Application() {
		dashboardPage.logoutApp();
		driver.quit();
	}

}
