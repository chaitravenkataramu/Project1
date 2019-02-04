package generic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst {

	public WebDriver driver;
	public static int passcount = 0, failcount = 0;

	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	@BeforeMethod
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/");
	}

@AfterMethod 
public void closeApp(ITestResult res) {
	String testName = res.getName();
	int  status = res.getStatus();
	if(status==1) {
		passcount++;
	}
	else {
		failcount++;	
		String path = PHOTO_PATH +testName +".png";
		Reporter.log("photopath:"+ path,true);
		FWUtil.getPhoto(driver,path);
	}
	driver.close();
}
@AfterSuite
public void print() {
	FWUtil.setXLData(REPORT_PATH, "sheet1", 1, 0, passcount);
	FWUtil.setXLData(REPORT_PATH, "sheet1", 1, 1, failcount);
}



}
