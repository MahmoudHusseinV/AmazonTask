package Pages;

import Base.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DealsScreen extends PageBase {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Deals\"]/android.widget.TextView[1]")
    public MobileElement TodayDeals;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Departments filter\"]/android.widget.Button")
    public MobileElement departementsFilter;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Computers & Accessories\"]")
    public MobileElement softwareFilter;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Submit\"]")
    public MobileElement finished;

    public DealsScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isFilteredbySoftware(){
        waitForVisibility(departementsFilter);
        click(departementsFilter);
        waitForVisibility(softwareFilter);
        boolean checked =softwareFilter.getAttribute("checked").equals("true");
        finished.click();
        return checked;
    }

    public void filterDealsBySoftware()
    {
        TodayDeals.click();
        waitForVisibility(departementsFilter);
        departementsFilter.click();
        waitForVisibility(softwareFilter);
        softwareFilter.click();
        finished.click();
    }
}
