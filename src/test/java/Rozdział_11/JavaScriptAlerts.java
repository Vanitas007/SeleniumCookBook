package Rozdział_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlerts {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/javascript_alerts");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void javaScriptAlerts() {
        WebElement jsAlertButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        jsAlertButton.click();
        driver.switchTo().alert().accept();


        WebElement jsConfirmButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        jsConfirmButton.click();
        driver.switchTo().alert().dismiss();

// coś tu nie działa z wprowadzaniem tekstu do alertu. Pobrany tekst to tekst alertu, a nie wprowadzony
        WebElement jsPromtButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        jsPromtButton.click();
        driver.switchTo().alert().sendKeys("Treść wpisywana w okno typu Prompt");
        String dsa = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        System.out.println(dsa);
    }
}
