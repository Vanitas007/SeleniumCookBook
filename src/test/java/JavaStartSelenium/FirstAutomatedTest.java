package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("https://duckduckgo.com/");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("JavaStart");
        driver.findElement(By.id("search_form_input_homepage")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }
    @Test
    public void myFirstTestEDITED(){
        driver.navigate().to("https://duckduckgo.com/");

        WebElement queryField = driver.findElement(By.id("search_form_input_homepage"));
        queryField.sendKeys("JavaStart");
        queryField.submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}