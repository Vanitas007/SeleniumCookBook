package Rozdział_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ScreenShotMakerTests_11_5 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://duckduckgo.com/");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void screenshotMakerTest() {
        ScreenShotMaker_11_5 screenShotMaker_11_5 = new ScreenShotMaker_11_5(driver);
        screenShotMaker_11_5.makeScreenshot("GoogleBeforeTypingQueryPage.png");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Kurs Selenium");

        screenShotMaker_11_5.makeScreenshot("GoogleAfterTypingQueryPage.png");
        searchField.submit();

        screenShotMaker_11_5.makeScreenshot("GoogleSearchResultsPage.png");
        assertEquals("Kurs Selenium at DuckDuckGo", driver.getTitle());
    }
}
