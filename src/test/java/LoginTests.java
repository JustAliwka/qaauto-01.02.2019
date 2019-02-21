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

    @DataProvider
    public Object[][] inValidDataLandingPage() {
        return new Object[][]{
                { "wowaliwa@gmail.com", "" },
                { "", "wowaliwa8542" },
                { "", "" },
                { "    @    .com", "     " }
        };
    }
    @Test(dataProvider = "inValidDataLandingPage")
    public void negativeLoginTestEmptyPass(String userEmail, String userPassword){
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login(userEmail, userPassword);

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
    }

    @DataProvider
    public Object[][] inValidDataLoginFaildPage() {
        return new Object[][]{
                { "    @    .com", "    8", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""},
                { "wowaliwa@gmail.com", "*******", "", "Это неверный пароль. Повторите попытку или измените пароль." }
        };
    }
    @Test(dataProvider = "inValidDataLoginFaildPage")
    public void negativeLoginTestSpacesInLoginAndPass(String userEmail, String userPassword,
                                                      String loginError, String passError){

        LandingPage landingPage = new LandingPage(driver);

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login(userEmail, userPassword);

        LoginFailed loginFailed = new LoginFailed(driver);
        Assert.assertTrue(loginFailed.isPageLoaded(), "Login Failed page is not loaded");
        Assert.assertEquals(loginFailed.getEmailValidationMessageText(), loginError,
                "Wrong validation message for password field.");
        Assert.assertEquals(loginFailed.getPasswordValidationMessageText(), passError,
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


