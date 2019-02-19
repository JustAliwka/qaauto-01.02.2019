import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginFailed {

    private WebDriver driver;
    WebElement errorLogin;


    public LoginFailed (WebDriver driver){
        this.driver = driver;
        initLoad();

    }
    private void initLoad () {
        errorLogin = driver.findElement(By.name("session_key"));
    }


    public boolean isPageLoaded() {
        return  errorLogin.isDisplayed()
                && driver.getCurrentUrl().contains("login-submit")
                && driver.getTitle().contains("Войти в LinkedIn");


    }







}
