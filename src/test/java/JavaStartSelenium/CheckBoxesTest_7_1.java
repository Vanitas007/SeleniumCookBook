package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Zadanie 7.1. Od strzała zrobione
 */

public class CheckBoxesTest_7_1 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void checkboxesTest() {
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        assertFalse(checkbox1.isSelected(), "Checkbox1 powinien być odznaczony.");
        assertTrue(checkbox2.isSelected(), "checkbox2 powinien być zaznaczony.");

        checkbox1.click();
        checkbox2.click();

        assertTrue(checkbox1.isSelected(), "Checkbox1 powinien być odznaczony.");
        assertFalse(checkbox2.isSelected(), "checkbox2 powinien być zaznaczony.");
    }
}
