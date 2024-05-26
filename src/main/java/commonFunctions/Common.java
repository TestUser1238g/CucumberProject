package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	public WebDriver driver;
	WebDriverWait wait;
	
	
	public Common(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void waitForElementInvisible(By elementInvisible) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementInvisible));
	}

}
