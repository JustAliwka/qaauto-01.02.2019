import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage {

    WebDriver driver;
    WebElement userEmailField;
    WebElement userPasswordField;
    WebElement signInButton;

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
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }


    public boolean isPageLoaded(String siteURL, String currentTitle, String siteTitle,
                                String currentURL, WebElement verificationElement){

        boolean siteLoaded = (siteTitle == currentTitle &&
                siteURL == currentURL
                && verificationElement.isDisplayed());

        return siteLoaded;
    }

}
