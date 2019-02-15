import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        //Hometask: create couple of explorotary Negative tests ( use classes of equalance) for login form
        //find tipical tests, create separate tests
//rename first test negativeLoginPassEmpty
//use landing page for all tests
//create new class for LoginFailed, use isPageLoaded for LoginFailed
