import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void NegativeLoginTest() {

        String UserName = "panalina";
        String UserPassword = "something";

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        //LinkedIn: Войти или зарегистрироваться
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        WebElement UserNameField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement UserPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement SubmitButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        UserNameField.sendKeys(UserName);
        UserPasswordField.sendKeys(UserPassword);
        SubmitButton.sendKeys(Keys.ENTER);



        driver.quit();
    }
}
