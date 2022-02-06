package com.secookbook.examples.chapter01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AutomationPracticeCom {

    private WebDriver driver;

    @BeforeEach
    public void setDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void s84sprawdzanieTekstuElementu() {
        WebElement phoneNumber = driver.findElement(By.className("shop-phone"));
        String phoneNumberText = phoneNumber.getText();
        assertEquals("Call us now: 0123-456-789", phoneNumberText);
    }

    @Test
    public void s87automatyzowanieRozwijanychMenuIList() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")));
        WebElement dressesButton = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
        dressesButton.click();

// Robie z menu rozwijanego obiekt Select na podstawie Xpatcha
        Select productSort = new Select(driver.findElement(By.id("selectProductSort")));
// Sprawdzam czy menu rozwijane obsługuje wybór wielokrotny
        assertFalse(productSort.isMultiple());
// Sprawdzam czy menu rozwijane ma 4 opcje wyboru
        assertEquals(8,productSort.getOptions().size());
    }

}
