import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;


public class LandingPage {

    private WebDriver driver;
    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement signInButton;
    private String title;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        signInButton = driver.findElement(By.xpath("//input[@class='login submit-button']"));
        userEmailField = driver.findElement(By.name("session_key"));
        userPasswordField = driver.findElement(By.name("session_password"));
        title = driver.getTitle();
    }

    public void login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }


    public boolean isPageLoaded() {

        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals(title);
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
