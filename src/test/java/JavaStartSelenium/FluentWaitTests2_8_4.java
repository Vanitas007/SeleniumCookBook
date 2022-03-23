package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

/** Zadanie_8_4 */

public class FluentWaitTests2_8_4 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void fluentWaitWithExceptionTest() {
        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

// Ja zrobiłem tak jak Zadanie_8_3 i działało bez problemu z użyciem waitUntilVisibilityOfElementLocated()
// Moje 4 vs 7 linijek

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        WebElement helloWorldMessage = fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

        assertTrue(helloWorldMessage.isDisplayed());
    }
}
