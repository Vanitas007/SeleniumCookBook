package com.secookbook.examples.chapter01;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class GoogleSearchTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        //uruchom przeglądarke Firefox
        driver = new FirefoxDriver();
        //maksymalizacja okna przeglądarki
        driver.manage().window().maximize();
        //przechodzę do googli
        driver.get("https://www.google.pl/");
    }

    @Test
    public void testGoogleSearch(){
        //szukam elementu po nazwie żeby wprowadzić tekst
        WebElement element = driver.findElement(By.name("q"));
        //Wyszyść tekst zapisany w elemencie
        element.clear();

        //wpisuje wyszukiwaną frazę
        element.sendKeys("Selenium testing tools coocbook");

        //Przesyłam formularz - czytaj leci enter
        element.submit();

        //Wyszukiwanie w Google jest renderowane dynamicznie za pomocą JavaScript.
        //Czekam na załadowanie storny. Timeout na kilka sekund.
        new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return d.getTitle().toLowerCase().startsWith("selenium testing tools coocbook");
            }
        });
        assertEquals("Selenium testing tools coocbook - Google Search",
        driver.getTitle());
    }

    @After
    public void tearDown() throws Exception{
        //Zamykam przeglądarke
        driver.quit();
    }
}
