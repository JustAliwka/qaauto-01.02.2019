import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHome {

    @Test
    public void NegativeLoginTest() {

        String UserName = "a@b.c";
        String UserPassword = "";

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "Login page title is wrong");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page URL is not correct");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='login-submit']")).isDisplayed());

        WebElement UserNameField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement UserPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement SubmitButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        UserNameField.sendKeys(UserName);
        UserPasswordField.sendKeys(UserPassword);
        SubmitButton.click();

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "Login page title is wrong");

        driver.quit();
    }
}
