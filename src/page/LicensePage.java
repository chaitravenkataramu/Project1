package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LicensePage {
	
	@FindBy(xpath="//b[contains(.,'actiTIME')]")
	private WebElement productEdition;
	
	@FindBy(xpath = "//nobr[.='Issue Date:']/../../td[2]")
	private WebElement issueDate;

	@FindBy(id = "logoutLink")
	private WebElement logoutLink;

	public LicensePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		logoutLink.click();

	}

	public void verifyIssueDate(String expected) {
		String actual = issueDate.getText();
		Reporter.log("Actual IssueDate;" + actual, true);
		Reporter.log("expected IssueDate:" + expected, true);
		Assert.assertEquals(actual, expected);

	}
	public void verifyProductEdition(String expected) {
		String actual = productEdition.getText();
		Reporter.log("Actual ProductEdition:" + actual,true);
		Reporter.log("expected ProductEdition:" + expected, true);
		Assert.assertEquals(actual, expected);
	}
}
