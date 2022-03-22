package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** klasa opisana w Zadanie_8_2 */

public class WaitUntil_8_2 {

    private WebDriverWait webDriverWait;

    public WaitUntil_8_2(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement waitUntilPresenceOfElementLocated(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementIsInvisible(WebElement checkboxBeforeClick) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkboxBeforeClick));
    }

    //Własnej roboty pod Zadanie_8_3
    public WebElement waitUntilVisibilityOfElementLocated(By by){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}