package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test(priority = 2)
	public void testInvalidLogin() throws InterruptedException {
		int rc = FWUtil.getXLRowCount(XL_PATH, "InvalidLogin");
		Reporter.log("RC:" +rc,true);
		for (int i = 1; i < rc; i++) {
			String un = FWUtil.getXLData(XL_PATH, "InvalidLogin", i, 0);
			String pw = FWUtil.getXLData(XL_PATH, "InvalidLogin", i, 1);
			//Enter invalid user name
			LoginPage l = new LoginPage(driver);
			l.setUserName(un);
			//Enter invalid password
			l.setPassword(pw);
			//Click login button
			l.clickLogin();
			Thread.sleep(2000);
			//verify Err msg is displayed___3
			l.verifyErrMsgDisplayed();
			
		}
		
	}

}
