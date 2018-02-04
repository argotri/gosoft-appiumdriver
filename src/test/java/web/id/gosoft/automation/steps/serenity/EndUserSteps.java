package web.id.gosoft.automation.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import web.id.gosoft.automation.pages.BukalapakApps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps{

    BukalapakApps bukalapakApps;

    @Step
    public void openApps(){
        bukalapakApps.allowApps();
    }
    @Step
    public void searchBarang(String text){
        bukalapakApps.search(text);
    }

}