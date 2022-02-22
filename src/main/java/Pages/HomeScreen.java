package Pages;

import Base.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class HomeScreen extends PageBase {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Television\"]")
    public MobileElement Television;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Devices & Electronics']")
    public MobileElement ElctronicsCard;


    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Menu. Contains your orders, your account," +
            " shop by department, programs and features, settings, and customer service Tab 4 of 4\"]")
    public MobileElement MenuBurgerIcon;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
    public void ClickOnMenuBurger() {

        waitForVisibility(MenuBurgerIcon);
        MenuBurgerIcon.click();

    }
    public void ClickOnElctronics(){

        waitForVisibility(ElctronicsCard);
        ElctronicsCard.click();

    }
    public void ChooseTVCategory(){
        ScrollToElement(Television,"down",1);
        waitForVisibility(Television);
        Television.click();

    }





}
