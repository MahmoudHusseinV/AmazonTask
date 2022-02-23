package StepDefinations;

import Base.TestBase;
import Pages.DealsScreen;
import Pages.HomeScreen;
import Pages.TVScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TodayDealsStepDef extends TestBase {
    HomeScreen home ;
    DealsScreen deals;
    @When("User Filter Today Deals by Software Department")
    public void userFilterTodayDealsBySoftwareDepartment() {
        deals = new DealsScreen(driver);
        deals.filterDealsBySoftware();
    }

    @Then("Deals should be filtered by Software Departments")
    public void dealsShouldBeFilteredBySoftwareDepartments() {
        Assert.assertTrue(deals.isFilteredbySoftware());
    }
}
