import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                { "wowaliwa@gmail.com", "wowaliwa8542" },
                { "WOWaliwa@gmail.com", "wowaliwa8542" },
                { "wowaliwa@gmail.com  ", "wowaliwa8542" },
                { "  wowaliwa@gmail.com", "wowaliwa8542" }
        };
    }

    @Test(dataProvider = "validData")
    public void positiveLoginTest(String userEmail, String userPassword) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Login failed. Home page didn't load after Login");
    }
    @Test
    public void negativeLoginTestEmptyPass(){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("wowaliwa@gmail.com", "");

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
    }
    @Test
    public void negativeLoginTestEmptyLogin(){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("", "wowaliwa8542");

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
    }
    @Test
    public void negativeLoginTestEmptyLoginPass(){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("", "");

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
    }
    @Test
    public void negativeLoginTestSpacesInPass(){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("    @    .com", "     ");

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
    }
    @Test
    public void negativeLoginTestSpacesInLoginAndPass(){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("    @    .com", "    8");

        LoginFailed loginFailed = new LoginFailed(driver);
        Assert.assertTrue(loginFailed.isPageLoaded(), "Login Failed page is not loaded");
    }
    @Test
    public void negativeLoginTestPercentInLoginAndPass(){

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("%%%", "%%%");

        LoginFailed loginFailed = new LoginFailed(driver);
        Assert.assertTrue(loginFailed.isPageLoaded(), "Login Failed page is not loaded");
    }
    @Test
    public void negativeLoginTestCorrectInLoginAndWrongPass(){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login("wowaliwa@gmail.com", "*******");

        LoginFailed loginFailed = new LoginFailed(driver);
        Assert.assertTrue(loginFailed.isPageLoaded(), "Login Failed page is not loaded");

        Assert.assertEquals(loginFailed.getPasswordValidationMessageText(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Wrong validation message for password field.");
    }
    @Test
    public void negativeLoginTestSymbolsInLoginAndPass(){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        String specialCharsLogin1 = landingPage.generateRandomChars(";<=>?@[]^_`{|}~",15);
        String specialCharsLogin2 = landingPage.generateRandomChars("!#$%&'()*+,-./:",15);
        String specialCharsPass = landingPage.generateRandomChars("!#$%&'()*+,-./:;<=>?@[]^_`{|}~",30);

        landingPage.login(specialCharsLogin1+"@" +specialCharsLogin2 +".com", specialCharsPass);

        LoginFailed loginFailed = new LoginFailed(driver);
        Assert.assertTrue(loginFailed.isPageLoaded(), "Login Failed page is not loaded");
    }

    }

    //add Data Provider for 2 negative tests - for LAnding and LoginFailed
// add to data provider 4 parameters: user pass passValidMessage and LoginValidMEssage. If mail/pass ok, empty string


