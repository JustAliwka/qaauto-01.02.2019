import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;


public class LandingPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@class='login submit-button']")
    private WebElement signInButton;

    @FindBy(name = "session_key")
    private WebElement userEmailField;

    @FindBy(name = "session_password")
    private WebElement userPasswordField;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        return new HomePage(driver);
    }

    public LandingPage loginFailLanding(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        return new LandingPage(driver);
    }

    public LoginFailed loginFail(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        return new LoginFailed(driver);
    }

    public boolean isPageLoaded() {

        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/");
    }

    public static String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }
        return sb.toString();
    }
}
