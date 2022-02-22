package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import Utils.Utilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	
	public static AndroidDriver driver;
    static Properties config ;
    static{
		config= Utilities.readProperties(System.getProperty("user.dir")+"/src/test/resources/Config.properties");
	}

	@BeforeClass
	public static void Android_Setup() throws MalformedURLException {


		//DesiredCapabilities caps= new DesiredCapabilities((Map<String,String>)config.entrySet());
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("platformName", config.getProperty("platformName"));
		caps.setCapability("platformVersion", config.getProperty("platformVersion"));
		caps.setCapability("deviceName", config.getProperty("deviceName"));
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability("appPackage",config.getProperty("appPackage"));
		caps.setCapability("appActivity",config.getProperty("appActivity"));
		caps.setCapability("noReset", config.getProperty("noReset"));
		caps.setCapability("fullReset", config.getProperty("fullReset"));

		driver= new AndroidDriver( new URL("http://localhost:4723/wd/hub"), caps);

	}
	@AfterClass
	public static void TearDown() {

		driver.close();
        driver.quit();

	}
}
