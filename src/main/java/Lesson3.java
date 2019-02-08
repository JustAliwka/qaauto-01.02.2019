import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Lesson3 {
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
        String searchTerm = "Selenium";
        WebElement searchField = driver2.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> searchResultsElements = driver2.findElements(By.xpath("//div[@class='srg']/div"));

        System.out.println("Number of searches: " + searchResultsElements.size());

        //For each WebElement in searchResultList print text

        for (WebElement searchResultsElement:searchResultsElements) {
            String searchResultsElementText = searchResultsElement.getText();
            System.out.println(searchResultsElementText);
            if (searchResultsElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Search results found");

            } else {
                System.out.println("Search results NOT found");
            }


        }

        driver2.quit();
    }
}
