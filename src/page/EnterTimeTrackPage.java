package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EnterTimeTrackPage {
		
	
	
	public void verifyHomePageIsDisplayed(WebDriver driver,long ETO,String eTitle) {
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleIs(eTitle));
		String aTitle = driver.getTitle();
		Assert.assertEquals(aTitle, eTitle);
	}

}
 