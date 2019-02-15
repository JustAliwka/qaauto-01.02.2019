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

            String siteURL = "https://www.linkedin.com/";
            String siteTitle = "LinkedIn: Log In or Sign Up";
            WebElement verificationElement = driver.findElement(By.xpath("//input[@class='login submit-button']"));

            boolean result = landingPage.isPageLoaded(siteURL, siteTitle, verificationElement);
            System.out.println("---- Result of the test: " + result + "----");

            driver.quit();
        }


        public void positiveLoginTest() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.linkedin.com");
            String siteURL = "https://www.linkedin.com/feed/";
            String siteTitle = "LinkedIn";

            LandingPage landingPage = new LandingPage(driver);
            landingPage.login("wowaliwa@gmail.com", "wowaliwa8542");


            WebElement verificationElement = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

            boolean result = landingPage.isPageLoaded(siteURL, siteTitle, verificationElement);
            System.out.println("---- Result of the test: " + result + "----");

            driver.quit();
        }

        }





/*
    Home Task #4:
        1. isPageLoaded() method
        - Implement isPageLoaded() method inside LandingPage.class
        - isPageLoaded() method should check page URL, page Title and specific WebElement on Landing page
        - isPageLoaded() method should return boolean (true or false)
        2. Update both negative and successful Tests
        - Use new LandingPage() in both tests
        - Use isPageLoaded() method in Assert to verify that Landing page is loaded
        - Remove any commented/unused code*/
