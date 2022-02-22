package Pages;

import Base.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class TVScreen extends PageBase {
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"results\")]//android.widget.TextView")
    public MobileElement Results;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"HD Format\"]/android.view.View")
    public MobileElement HDFormat;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"1080p\"]/android.view.View")
    public MobileElement ScreenResolution;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Filter\")]")
    public MobileElement TVFilterResult;

    public TVScreen(AndroidDriver driver) {
        super(driver);
    }

    public void SmartTVFilter(){
        ScrollToElement(TVFilterResult,"down",11);
        waitForVisibility(TVFilterResult);
        TVFilterResult.click();
        waitForVisibility(HDFormat);
        HDFormat.click();
        waitForVisibility(ScreenResolution);
        ScreenResolution.click();

    }
    public void TotalNumberOfResultValidation(String NumberOfResult){
        waitForVisibility(TVFilterResult);
        TVFilterResult.click();
        waitForVisibility(Results);
        Assert.assertTrue(Results.getText().contains(NumberOfResult));

    }
}
