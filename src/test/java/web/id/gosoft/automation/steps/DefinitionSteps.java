package web.id.gosoft.automation.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import web.id.gosoft.automation.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUserSteps;

    @Given("user in bukalapak apps")
    public void givenUserInBukalapakApps(){
        endUserSteps.openApps();
    }
    @When("user type '$productName' in bukalapak apps")
    public void whenUserTypeTelevisiInBukalapakApps(String productName){
        endUserSteps.searchBarang(productName);
    }

    @Then("i got list of '$productName' in search result")
    public void thenIGotListOfTelevisiInSearchResult(String productName){

    }


}
