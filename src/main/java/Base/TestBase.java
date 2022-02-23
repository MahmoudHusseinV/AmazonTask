package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	
	public static AndroidDriver driver;
    static Properties config ;
    static{
		config= readProperties(System.getProperty("user.dir")+"/src/test/resources/Config.properties");
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

	public static Properties readProperties(String filePath) {

		try (FileInputStream testProperties = new FileInputStream(filePath)) {
			Properties tempProp = new Properties();
			tempProp.load(testProperties);
			System.out.println("Properties file reading done: " + filePath);
			return tempProp;
		} catch (IOException e) {
			System.out.println("Properties file error: " + e.getMessage());
		}
		return null;
	}
}
