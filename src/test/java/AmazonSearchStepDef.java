import Base.PageBase;
import Base.TestBase;
import Pages.HomeScreen;
import Pages.TVScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class AmazonSearchStepDef extends TestBase {
    HomeScreen home ;
    TVScreen tvScreen;

    @When("User Click on Shop by Department from burger menu")
    public void clickOnShopByDepartmentFromBurgerMenu() {
        home.ClickOnMenuBurger();
    }

    @Given("Home Page is Loaded")
    public void homePageIsLoaded() {
        home = new HomeScreen(driver);
    }

    @And("User Select category ‘Electronics’")
    public void userSelectCategoryElectronics() {
        home.ClickOnElctronics();
    }

    @And("User Choose sub-category ’TV & VIDEO’")
    public void userChooseSubCategoryTVVIDEO() {
        home.ChooseTVCategory();
    }

    @And("User Filter with ’HD Format’ and click show results")
    public void userFilterWithHDFormatAndClickShowResults() {
        tvScreen = new TVScreen(driver);
        tvScreen.SmartTVFilter();
    }

    @Then("^the total number of results match the (.+) displayed in filter$")
    public void theTotalNumberOfResultsMatchTheTotalDisplayedInFilter(String Total) {
        tvScreen.TotalNumberOfResultValidation(Total);
    }

    @Given("App is lunched")
    public void appIsLunched() throws MalformedURLException {
        Android_Setup();
    }
}
