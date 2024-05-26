package Vibrant.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	
	public WebDriver installation() throws IOException {
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Vibrant\\Utilities\\TestData.Properties");
	Properties prop = new Properties();
	prop.load(fis);
	
	String browser =System.getProperty("browserName") != null ? System.getProperty("browserName"): prop.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
	if(browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
	}
    
	@BeforeMethod(alwaysRun=true)
	public DashboardPage launchApplication() throws IOException {
		driver=installation();
		loginPage=new LoginPage(driver);
		dashboardPage = loginPage.loginToApplication();
		return dashboardPage;
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		dashboardPage.logoutApp();
		driver.quit();
	}
	
	public String getScreenshot(WebDriver driver,String str) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\" +str+ ".jpg"));
		 return System.getProperty("user.dir")+"\\Screenshots\\" +str+ ".jpg";
	}
}
