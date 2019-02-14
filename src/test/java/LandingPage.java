import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    WebDriver driver;

    WebElement signInButton;
    WebElement userEmailField;
    WebElement userPasswordField;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();


    }

    public void initElements() {
        signInButton = driver.findElement(By.xpath("//input[@class='login submit-button']"));
        userEmailField = driver.findElement(By.name("session_key"));
        userPasswordField = driver.findElement(By.name("session_password"));

    }

    public void login(String userEmail, String userPassword){
        userEmailField.sendKeys("abc.c");
        userPasswordField.sendKeys("");
        signInButton.click();
    }



}
