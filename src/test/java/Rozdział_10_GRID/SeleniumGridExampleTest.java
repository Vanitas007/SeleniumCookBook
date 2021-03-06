package Rozdział_10_GRID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class SeleniumGridExampleTest {

/** Uruchomienie HUBa: java -jar selenium-server-4.1.3.jar hub
 * Uruchomienie NODa: java -Dwebdriver.chrome.driver=D:\Testowanie\ProjektyGIT\SeleniumCookbook\src\main\resources\chromedriver.exe  -jar selenium-server-4.1.3.jar node*/

// Z ustawieniami: java -Dwebdriver.chrome.driver=D:\Testowanie\ProjektyGIT\SeleniumCookbook\src\main\resources\chromedriver.exe  -jar selenium-server-4.1.3.jar node --config D:\Programy\SeleniumGridNode\NodeConfiguration.toml
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        ChromeOptions capability = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), capability);
    }

    @Test
    public void searchInDuckDuckGoTest() {
        driver.navigate().to("https://duckduckgo.com/");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("JavaStart");
        driver.findElement(By.id("search_form_input_homepage")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}