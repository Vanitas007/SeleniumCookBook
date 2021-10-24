package com.secookbook.examples.chapter01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void s84sprawdzanieTekstuElementu(){
        WebElement phoneNumber = driver.findElement(By.className("shop-phone"));
        String phoneNumberText = phoneNumber.getText();
        assertEquals("Call us now: 0123-456-789", phoneNumberText);
    }


}
