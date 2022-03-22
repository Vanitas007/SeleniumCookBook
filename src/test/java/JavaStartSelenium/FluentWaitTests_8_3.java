package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

/** Zadanie_8_3 Fluent Wait na obiekt istniejący w drzewie DOM, ale nie wyświetlany na stronie */

public class FluentWaitTests_8_3 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    @Test
    public void fluentWaitTest() {
        WebElement helloWorldElement = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
        assertFalse(helloWorldElement.isDisplayed());

        WebElement startButton = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        startButton.click();

/** Ja zamiast fluentWaita dodałem metode do klasy WaitUntil_8_2
        WaitUntil_8_2 waitUntil = new WaitUntil_8_2(driver);
        waitUntil.waitUntilVisibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4"));
*/

// Rozwiązanie z tutoriala
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(helloWorldElement));

        assertEquals(helloWorldElement.getText(), "Hello World!");
    }
}
