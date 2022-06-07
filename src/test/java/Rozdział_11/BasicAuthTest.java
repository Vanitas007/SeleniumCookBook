package Rozdział_11;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BasicAuthTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/basic_auth");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void basicAuthNewTest() {
        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
        driver.get("http://theinternet.przyklady.javastart.pl/basic_auth");

        assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText(), "Congratulations! You must have the proper credentials.");
    }


}
