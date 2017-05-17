package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;

public class ContactSelectSteps extends BaseSteps {

    @Then("^I should be shown the list of people that I chat with$")
    public void iShouldBeShownTheListOfPeopleThatICanChatWith() {
        new HomePage(getDriverForUser1()).chooseContact();
        new HomePage(getDriverForUser2()).chooseContact();
    }

    @Given("^I tap on the name of the person to talk with$")
    public void iAmOnTheChatLogsPage() {
        new HomePage(getDriverForUser1()).tapOnSelectedContact();
        new HomePage(getDriverForUser2()).tapOnSelectedContact();
    }
}
