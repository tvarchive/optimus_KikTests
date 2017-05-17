package steps;

import cucumber.api.java.en.When;
import pages.ChatPage;

import java.util.Iterator;
import java.util.Map;

public class ChatSteps extends BaseSteps {

    @When("^I send her some message$")
    public void iSendHerSomeMessage() {
        Iterator it = getConversation().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            new ChatPage(getDriverForUser1()).typeTextMessage((String) pair.getKey());
            new ChatPage(getDriverForUser1()).sendMessage();
            new ChatPage(getDriverForUser2()).typeTextMessage((String) pair.getValue());
            new ChatPage(getDriverForUser2()).sendMessage();
            it.remove();
        }
    }
}
