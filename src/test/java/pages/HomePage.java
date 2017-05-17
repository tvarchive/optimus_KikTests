package pages;

import builders.ContactBuilder;
import entities.Contact;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "conversation_list_item")
    private List<WebElement> conversationList;

    @FindBy(id = "floating_action_button")
    private WebElement moreOptionsButton;

    @FindBy(id = "button_settings")
    private WebElement settings;

    private AppiumDriver driver;

    private Contact contact;


    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void chooseContact() {
        System.out.println("Finding a contact...");
        contact = findAContact();
        System.out.println("Found a contact with name -- " + contact.getName());
    }

    public void tapOnSelectedContact() {
        getChildElement(conversationList.get(0), Bys.name).click();
    }

    private Contact findAContact() {
        WebElement contactPerson = getContactElement();
        return buildContact(contactPerson);
    }

    private Contact buildContact(WebElement contactPerson) {
        try {
            waitForInvisibilityOfElementByText(Bys.name, "Retrieving...");
            return new ContactBuilder().
                    withName(getElementText(contactPerson, Bys.name)).
                    build();
        } catch (Exception e) {
            return new ContactBuilder().
                    withName(getElementText(contactPerson, Bys.name)).
                    build();
        }
    }

    private WebElement getContactElement() {
        waitForElementsToBeVisible(conversationList);
        return conversationList.stream().findFirst().get();
    }

    protected interface Bys {
        By name = By.xpath("//android.widget.TextView[@index=0]");
    }
}
