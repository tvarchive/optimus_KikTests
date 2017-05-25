package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginSteps extends BaseSteps{

    @Given("^I start Kik and choose to login$")
    public void iStartKikApplicationOnMyPhone(){
        new LoginPage(getDriverForUser1()).tapOnLogin();
        new LoginPage(getDriverForUser2()).tapOnLogin();
    }

    @When("^I log into my account$")
    public void iLogIntoMyAccountWithEmailAndPasswordAs(DataTable table){
        final List<Map<String,String>> rows = table.asMaps(String.class,String.class);
        final Map<String,String> dataForUser1 = rows.get(0);
        final Map<String,String> dataForUser2 = rows.get(1);
        loginAsUser1(dataForUser1.get("username"),dataForUser1.get("password"));
        loginAsUser2(dataForUser2.get("username"),dataForUser2.get("password"));
     }

    @When("^I log into my account with ([^\"]*)$")
    public void iLogIntoMyAccountWithUsernameAndPasswordAs(String userDetails){
        loginAsUser1(userDetails);
        loginAsUser2(userDetails);
    }
}
