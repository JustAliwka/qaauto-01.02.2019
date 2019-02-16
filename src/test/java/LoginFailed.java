import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class LoginFailed {

    private WebDriver driver;
    WebElement errorLogin;


    public LoginFailed (WebDriver driver){
        this.driver = driver;
        initLoad();

    }
    private void initLoad () {
        errorLogin = driver.findElement(By.id("error-for-username"));
    }


    public boolean isPageLoaded() {
        return
                driver.getCurrentUrl().contains("login-submit")
                && driver.getTitle().contains("Войти в LinkedIn");
    }







}
