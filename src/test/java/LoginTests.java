import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.JButton;
import java.awt.*;

public class LoginTests {
    //@Test
        public void negativeLoginTest(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.linkedin.com/");

            LandingPage landingPage = new LandingPage(driver);
            Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
            landingPage.login("wowaliwa@gmail.com", "");

            Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

            driver.quit();
        }

    @Test
        public void positiveLoginTest() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.linkedin.com/");

            LandingPage landingPage = new LandingPage(driver);
            landingPage.login("wowaliwa@gmail.com", "wowaliwa8542");

            HomePage homePage = new HomePage(driver);
            Assert.assertTrue(homePage.isPageLoaded(), "Login failed. Home page didn't load after Login");

            driver.quit();
        }

        }
