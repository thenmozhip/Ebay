package cucumber.prjname.java.tests.web;

import com.companyname.prjname.qa.pageobjects.HomePageInterface;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.companyname.prjname.qa.functionlibrary.WebNavigation.*;

public class SearchOnEBayStepdefs {

    @Given("^when am on EBay home page$")
    public static void onEBayPage(){

        openWebPage("http://www.ebay.co.uk/");
    }

    @When("^I enter the text to search : (.*)$")
    public static void enterTextToSearch(String enterSearchText){

        enterAnyTextInAField(HomePageInterface.searchText, enterSearchText);
        System.out.println("Search text entered");
    }

    @And("^click the search button$")
    public static void clickSearchBtn(){

        clickALinkWithCssLocator(HomePageInterface.searchBtn);
        System.out.println("Search button clicked successfully");
    }

    @And("^the (.*) is selected$")
    public static void tabSelected(String tab){

        if(tab.equals("All listings")){
            clickALinkWithCssLocator(HomePageInterface.allListingsBtn);
        }
        else if(tab.equals("Auction")){
            clickALinkWithCssLocator(HomePageInterface.auctionBtn);
        }
        else if(tab.equals("But it now")){
            clickALinkWithCssLocator(HomePageInterface.buyItNowBtn);
        }
    }

    @Then("^the first result has price and postage displayed$")
    public static void verifyDataDisplayed() throws Throwable {
        isElementPresent(HomePageInterface.firstResultAllListingsTabPrice);
        System.out.println("All listings price displayed");

        isElementPresent(HomePageInterface.firstResultAllListingsTabPostage);
        System.out.println("All listings postage displayed");

        closeBrowser();
    }


    @And("^Buy it now tab is selected$")
    public static void buyItNowTabSelected(){

        clickALinkWithCssLocator(HomePageInterface.buyItNowBtn);
        System.out.println("BuyItNow button clicked successfully");
    }


    @Then("^the first result has price and butItNow displayed$")
    public static void resultHasInfoDisplayed() throws Throwable {

        isElementPresent(HomePageInterface.firstResultBuyItNowTabPrice);
        System.out.println("BuyItNow price displayed");

        isElementPresent(HomePageInterface.firstResultBuyItNowTabBuyItNowOption);
        System.out.println("BuyItNow option displayed");

        closeBrowser();
    }
    @When("^click on Page (\\d+)$")
    public void click_on_Page(int enterPageNumber) throws Throwable {
        clickALinkWithCssLocator(HomePageInterface.pageTwo);

    }

    @Then("^I should get results in Page (\\d+)$")
    public void i_should_get_results_in_Page(int expectedPageNumber) throws Throwable {
        isElementPresent(HomePageInterface.pageTwo);
    }
}
