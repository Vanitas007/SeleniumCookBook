package com.secookbook.examples.chapter01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;


public class GoogleSearch {
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.pl");
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div[3]/button[2]"));
        element.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys("Selenium testing tools cookbook");
        searchField.submit();

        //Przestarzała metoda
//        new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d){
//                return d.getTitle().toLowerCase().startsWith("selenium testing tools cookbook");
//            }
//        });

        //pajacerka własnej roboty...
        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("selenium testing tools cookbook");
            }
        });

        assertEquals("Selenium testing tools cookbook - Szukaj w Google", driver.getTitle());
    }

    @Test
    public void s60wyszukanieLinkuGmaila(){
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        assertEquals("https://mail.google.com/mail/&ogbl", gmailLink.getAttribute("href"));
    }
}
