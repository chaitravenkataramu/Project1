package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.LicensePage;

public class CheckProductEdition extends BaseTest {
	
	@Test(priority=3)
	public void testCheckProductEdition() {
		String un = FWUtil.getXLData(XL_PATH, "CheckProductEdition", 1, 0);
		String pw = FWUtil.getXLData(XL_PATH, "CheckProductEdition", 1, 2);
		
		//verify product edition
		LicensePage c = new LicensePage(driver);
		c.verifyProductEdition(productEdition);
		//click logout
		c.clickLogout();
	}

}
