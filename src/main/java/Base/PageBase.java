package Base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.lang.String.format;

public class PageBase {
protected AndroidDriver driver;
	 public PageBase(AndroidDriver driver) {
	 	this.driver=driver;
		 AppiumFieldDecorator appfieldDecorator=new AppiumFieldDecorator(this.driver, Duration.ofSeconds(30));
			PageFactory.initElements( appfieldDecorator, this);
	    }

	public boolean waitForVisibility(WebElement element) {
	 	try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
	 	catch(Exception e) {
			return false;
		}
	}

	public void WaitForElementStaleness(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}
	public void click(MobileElement element) {

		element.click();
	}

	public void clear(MobileElement element) {

		element.clear();
	}

	public void sendText(MobileElement element , String Text) {

		element.clear();
		element.sendKeys(Text);
	}

	public String getAttribute(MobileElement element , String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public void selectElementFromList(String elementText, MobileElement list)
	{
	
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+elementText+"\").instance(0))").click();

	}
	public void scrollAndClick(String visibleText) {
		String uiSelector = "new UiSelector().textMatches (\"" + visibleText+ "\")";
		String command = "new UiScrollable( new UiSelector().scrollable(true). instance(0)).scrollIntoView("+ uiSelector + ");";
		driver.findElementByAndroidUIAutomator(command);
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	}

	
	public void ScrollDown(MobileElement element)
	{
//		AndroidTouchAction action = new AndroidTouchAction(driver);
//
//		action.press(PointOption.point(400, 2000))
//		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
//		.moveTo(PointOption.point(400, 6000))
//		.release()
//		.perform();
		TouchActions action = new TouchActions(driver);
		action.scroll(element, 10, 100);
		action.perform();


	}

	protected void ScrollToElement(MobileElement element, String direction,int ScrollCount) {
		int count = 0;
		boolean isDisplayed = false;

		while (!isDisplayed && count++ < ScrollCount) {
			touchScroll(direction);
//			try {
//				isDisplayed = element.isDisplayed();
//
//			} catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
//				touchScroll(direction);
//			}
		}


//		Assert.assertTrue(format("Element was not found after [%s] scrolls", count), isDisplayed);
	}
	private void touchScroll(String scrollDirection) {
		Map<String, Integer> map;
		Dimension dimension = driver.manage().window().getSize();

		int centerX = dimension.width / 2;
		int centerY = dimension.height / 2;
		int topScreen = (int) (dimension.height * .30);
		int bottomScreen = (int) (dimension.height * .60);
		int rightScreen = (int) (dimension.width * .90);
		int leftScreen = (int) (dimension.width * .10);

		switch (scrollDirection) {
			case "up":
				map = setMoveToCOORD(centerX, topScreen, centerX, bottomScreen);
				break;
			case "down":
				map = setMoveToCOORD(centerX, bottomScreen, centerX, topScreen);
				break;
			case "right":
				map = setMoveToCOORD(rightScreen, centerY, leftScreen, centerY);
				break;
			case "left":
				map = setMoveToCOORD(leftScreen, centerY, rightScreen, centerY);
				break;
			default:
				throw new IllegalArgumentException(
						"Incorrect scroll direction given: Direction must be [up], [down], [left], or [right]");
		}

		new TouchAction(driver)
				.longPress(longPressOptions().withPosition(point(map.get("fromX"), map.get("fromY"))))
				.moveTo(point(map.get("toX"), map.get("toY")))
				.release()
				.perform();
	}

	private Map<String, Integer> setMoveToCOORD(int fromX, int fromY, int toX, int toY) {
		Map<String, Integer> coordinates = new HashMap<>();
		coordinates.put("fromX", fromX);
		coordinates.put("fromY", fromY);
		coordinates.put("toX", toX);
		coordinates.put("toY", toY);
		return coordinates;
	}


  
}
