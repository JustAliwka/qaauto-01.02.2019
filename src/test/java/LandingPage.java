import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage {

    WebDriver driver;
    WebElement userEmailField;
    WebElement userPasswordField;
    WebElement signInButton;
    String currentURL;
    String currentTitle;




    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
        initTitlURL();

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
    public void initTitlURL() {
        currentURL = driver.getCurrentUrl();
        currentTitle = driver.getTitle();
    }

    public boolean isPageLoaded(String siteURL, String siteTitle,  WebElement verificationElement){

        boolean siteLoaded = (siteTitle == currentTitle &&
                siteURL == currentURL &&
                verificationElement.isDisplayed());

        return siteLoaded;
    }

}
