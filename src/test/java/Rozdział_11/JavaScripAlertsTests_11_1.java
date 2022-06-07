package Rozdział_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class JavaScripAlertsTests_11_1 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/javascript_alerts");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void javaScriptAlertTest() {
//        WebElement jsAlertButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        WebElement jsAlertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        jsAlertButton.click();

        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.id("result"));

        assertTrue(result.isDisplayed());
        assertEquals(result.getText(), "You successfuly clicked an alert");
    }

    @Test
    public void javaScriptAlertConfirmTest() {
        WebElement jsConfirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        jsConfirmButton.click();

        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.id("result"));
        assertEquals(result.getText(), "You clicked: Ok");

        jsConfirmButton.click();
        driver.switchTo().alert().dismiss();
        assertEquals(result.getText(), "You clicked: Cancel");
    }

    @Test
    public void JavaScripAlertsTests() {
        WebElement jsPromptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        jsPromptButton.click();

        driver.switchTo().alert().sendKeys("Selenium is cool");
        driver.switchTo().alert().accept();
//        String typedText = "Selenium is cool";
//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys(typedText);
//        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals(result.getText(), "You entered: Selenium is cool");
    }
}
