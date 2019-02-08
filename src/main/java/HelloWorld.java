import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args)
/*    {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Selenium");
        search.sendKeys(Keys.ENTER);
        driver.quit();
    }*/ {
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.google.com");
        WebElement searchField = driver2.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> searchResultsList = driver2.findElements(By.xpath("//div[@class='srg']/div"));


        System.out.println("Number of searches: " + searchResultsList.size());
        for (WebElement w : searchResultsList) {
            System.out.println(w.getText());
            if (w.getText().contains("Selenium")) {
                System.out.println("searchTerm found");
            } else {
                System.out.println("searchTerm not found");
            }
        }
        driver2.quit();
    }

}
