package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class ExplicitWaitTests_8_1 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    @Test

    public void waitForDisappearingElement(){

        WebElement checkboxElement = driver.findElement(By.id("checkbox"));
        assertTrue(checkboxElement.isDisplayed());
        assertFalse(checkboxElement.isSelected());

        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        removeButton.click();

        WebDriverWait messageWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        messageWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

//  W tutorialu poniższy wait invisibilityOf
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        webDriverWait.until(ExpectedConditions.invisibilityOf(checkboxElement));

        WebElement messageElement = driver.findElement(By.id("message"));
        assertEquals(messageElement.getText(),"It's gone!");
    }
}
