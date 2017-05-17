package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginSteps extends BaseSteps{

    @Given("^I start Kik and choose to login$")
    public void iStartKikApplicationOnMyPhone(){
        new LoginPage(getDriverForUser1()).tapOnLogin();
        new LoginPage(getDriverForUser2()).tapOnLogin();
    }

    @When("^I log into my account$")
    public void iLogIntoMyAccountWithEmailAndPasswordAs(){
      loginAsUser1();
      loginAsUser2();
    }
}
