import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginFailed {

    private WebDriver driver;
    private WebElement errorLogin;
    private WebElement passwordValidationMessage;
    private WebElement getEmailValidationMessageText;
    private WebElement loginForm;

    public LoginFailed (WebDriver driver){
        this.driver = driver;
        initLoad();
    }
    private void initLoad () {
        loginForm = driver.findElement(By.xpath("//form[@class='login__form']"));
        errorLogin = driver.findElement(By.name("session_key"));
        passwordValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        getEmailValidationMessageText = driver.findElement(By.xpath("//div[@id='error-for-username']"));
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
