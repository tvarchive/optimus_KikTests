package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "login_button")
    private WebElement loginButton;

    @FindBy(xpath = "//android.widget.EditText[@text='Email or Kik Username']")
    private WebElement email;

    @FindBy(id = "validateable_text_view")
    private List<WebElement> password;

    private By notNowButton = By.id("not_now_sync_button");
    private By confirm = By.id("button_confirm");
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void tapOnLogin() {
        waitForElementToBeVisible(loginButton);
        loginButton.click();
    }

    public void enterUsername(String username) {
        waitForElementToBeVisible(this.email);
        this.email.sendKeys(username);

    }

    public void enterPassword(String password) {
        waitForElementToBeVisible(this.password.get(1));
        this.password.get(1).sendKeys(password);
    }

    public void tapOnNotNowButton(){
        waitForElementToBeVisible(notNowButton,1);
        clickBy(notNowButton);
    }

    public void tapOnConfirmButton(){
        waitForElementToBeVisible(confirm,1);
        clickBy(confirm);
    }
}
