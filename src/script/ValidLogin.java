package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {

	@Test(priority = 1)
	public void testValidLogin() {
		String un = FWUtil.getXLData(XL_PATH, "ValidLogin", 1, 0);
		String pw = FWUtil.getXLData(XL_PATH, "ValidLogin", 1, 1);
		String Title = FWUtil.getXLData(XL_PATH, "ValidLogin", 1, 2);
		// Enter Valid User Name
		LoginPage l = new LoginPage(driver);
		l.setUserName(un);
		// Enter Valid Password
		l.setPassword(pw);
		// click on Login button
		l.clickLogin();
		// verify home page is displayed
		EnterTimeTrackPage e = new EnterTimeTrackPage();
		e.verifyHomePageIsDisplayed(driver, ETO, Title);

	}

}
