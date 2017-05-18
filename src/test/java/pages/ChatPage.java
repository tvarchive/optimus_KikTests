package pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage extends BasePage {

    @FindBy(id = "txt_new_message")
    private WebElement textNewMessage;

    @FindBy(id = "bubble")
    private WebElement chatBubble;

    @FindBy(id = "button_send_message")
    private WebElement send;

    private AppiumDriver driver;

    public ChatPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void typeTextMessage(String message) {
        waitForElementToBeVisible(textNewMessage);
        textNewMessage.sendKeys(message);
    }

    public void sendMessage() {
        waitForElementToBeVisible(send);
        send.click();
    }
}
