package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/** Zadanie_8_2 na podstawie 8_1. Dodana klasa WaitUntil_8_2 z 2ma metodami na czekanie, konstruktorem i polem.
 * Polepsza to kod i tr konkretne metody pomagają przeciwdziałać wyjątkowi StaleElementReferenceException */

public class ExplicitWaitTests_8_2 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void waitForDisappearingElement() {
        WebElement checkboxElement = driver.findElement(By.id("checkbox"));
        assertTrue(checkboxElement.isDisplayed());
        assertFalse(checkboxElement.isSelected());

        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        removeButton.click();

        WaitUntil_8_2 waitUntil = new WaitUntil_8_2(driver);
        waitUntil.waitUntilElementIsInvisible(checkboxElement);

        WebElement messageElement = driver.findElement(By.id("message"));
        assertEquals(messageElement.getText(), "It's gone!");

        removeButton.click();

        checkboxElement = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertTrue(checkboxElement.isDisplayed());
        assertFalse(checkboxElement.isSelected());

    }
}
