import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginFailed {

    private WebDriver driver;
    @FindBy (xpath = "//div[@id='error-for-password']")
    private WebElement passwordValidationMessage;

    @FindBy (xpath = "//div[@id='error-for-username']")
    private WebElement getEmailValidationMessageText;

    @FindBy (xpath = "//form[@class='login__form']")
    private WebElement loginForm;

    public LoginFailed (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
      }


    public boolean isPageLoaded() {
        return  loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("login-submit")
                && driver.getTitle().contains("Войти в LinkedIn");
    }

    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }

    public String getEmailValidationMessageText() {
        return getEmailValidationMessageText.getText();

    }

}
