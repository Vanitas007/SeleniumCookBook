package com.secookbook.examples.chapter01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
    }

    @AfterEach
    public void tearDown() throws Exception {
// Zamknij przeglądarkę
        driver.quit();
    }

    @Test
    public void testWikipediaSearch() {
// Znajdź element wprowadzania tekstu za pomocą jego nazwy
        WebElement element = driver.findElement(By.id("searchInput"));
// Wyczyść tekst zapisany w elemencie
        element.clear();
// Wpisz informacje do szukania
        element.sendKeys("Szachy");
// Prześlij formularz
        element.submit();
// Wyszukiwanie w Google jest renderowane dynamicznie za pomocą JavaScript.
// Poczekaj na załadowanie strony. Timeout po 10 sekundach
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("szachy");
            }
        });
        assertEquals("Szachy – Wikipedia, wolna encyklopedia", driver.getTitle());
    }
    @Test

    public void wyswietlanieWszystkichLinkowZeStrony(){
// Wyszukanie wszystkich linków, które są wyświetlane na stronie
        List<WebElement> links = driver.findElements(By.tagName("a"));

//Sprawdzenie, czy na stronie jest wyświetlane 316 linków
        assertEquals(316, links.size());

//Iterowanie po liście linków i wyświetlanie dla każdego z nich adresu docelowego
        for (WebElement link : links){
            System.out.println(link.getAttribute("href"));
        }
    }

}