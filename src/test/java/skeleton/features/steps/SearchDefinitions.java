package skeleton.features.steps;

import org.junit.Assert;
import skeleton.features.steps.serenity.SearchSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;

public class SearchDefinitions {

    @Steps
    SearchSteps searchSteps;


    /*START: Scenario: Checking a search result on a given position.*/
    @Given("User searches for <searchWord>")
    public void givenUserSearchesFor(String searchWord) {

        searchSteps.open();
        searchSteps.connect(searchWord);
    }

    @When("User gets results")
    public void userGetsResults(){

    }

    @When("User clicks on result number <resultNumber>")
    public void userClicksOnResultNumber(int resultNumber){
        searchSteps.getSearchResultOnPosition(resultNumber);
    }

    @Then("User goes to a new website")
    public void userGoesToANewWebsite(){
        String currentURL = searchSteps.getCurrentURL();
        Assert.assertNotEquals("https://google.fr", currentURL);
    }
    /*END: Scenario: Checking a search result on a given position.*/



}
