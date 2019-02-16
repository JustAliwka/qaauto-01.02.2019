import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {
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
    @Test
        public void negativeLoginTestEmptyPass(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.linkedin.com/");

            LandingPage landingPage = new LandingPage(driver);
            Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
            landingPage.login("wowaliwa@gmail.com", "");

            Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

            driver.quit();
        }
    @Test
        public void negativeLoginTestEmptyLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("", "wowaliwa8542");

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        driver.quit();
    }
    @Test
    public void negativeLoginTestEmptyLoginPass(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("", "");

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        driver.quit();
    }
    @Test
    public void negativeLoginTestSpacesInPass(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("    @    .com", "     ");

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        driver.quit();
    }
    @Test
    public void negativeLoginTestSpacesInLoginAndPass(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("    @    .com", "    8888");

        LoginFailed loginFailed = new LoginFailed(driver);
        Assert.assertTrue(loginFailed.isPageLoaded(), "Landing page is not loaded");

        driver.quit();
    }
    @Test
    public void negativeLoginTestSymbolsInLoginAndPass(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        String specialCharsLogin1 = landingPage.generateRandomChars(";<=>?@[]^_`{|}~",15);
        String specialCharsLogin2 = landingPage.generateRandomChars("!#$%&'()*+,-./:",15);
        String specialCharsPass = landingPage.generateRandomChars("!#$%&'()*+,-./:;<=>?@[]^_`{|}~",15);

        landingPage.login(specialCharsLogin1+"@" +specialCharsLogin2 +".com", specialCharsPass);

        LoginFailed loginFailed = new LoginFailed(driver);
        Assert.assertTrue(loginFailed.isPageLoaded(), "Landing page is not loaded");

        driver.quit();
    }
        }

        //Hometask: create couple of explorotary Negative tests ( use classes of equalance) for login form
        //find tipical tests, create separate tests
        //rename first test negativeLoginPassEmpty
        //use landing page for all tests
        //create new class for LoginFailed, use isPageLoaded for LoginFailed

/* empty email
   empty pass
   empty login and pass
   spaces in login and pass
   special chars in email and pass

* */
