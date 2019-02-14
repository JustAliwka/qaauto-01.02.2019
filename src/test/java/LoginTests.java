import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.JButton;
import java.awt.*;

public class LoginTests {
        @Test
        public void negativeLoginTest(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.linkedin.com");

            LandingPage landingPage = new LandingPage(driver);
            landingPage.login("wowaliwa.gmail.com", "");







        }
}
