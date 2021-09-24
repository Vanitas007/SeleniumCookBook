package com.secookbook.examples.chapter01;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;

public class GoogleSearchTestOnChrome {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
// Uruchom Chrome
        driver = new ChromeDriver();
//Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
//Przejdź do Google
        driver.get("http://www.google.com");
    }

    @Test
    public void testGoogleSearch() {
//Znajdź pole tekstowe za pomocą jego nazwy
        WebElement element = driver.findElement(By.name("q"));
// Wpisz coś do wyszukiwania
        element.sendKeys("Selenium i testowanie aplikacji. Receptury");
// Teraz prześlij formularz. WebDriver znajdzie
// formularz odpowiadający elementowi
        element.submit();
// Strona wyszukiwania w Google jest dynamicznie renderowana za pomocą JavaScript.
// Czekamy na załadowanie się strony. Timeout po 10 sekundach
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith("selenium i testowanie aplikacji. receptury");
            }
        });
        assertEquals("Selenium i testowanie aplikacji. Receptury - Szukaj w Google",
                driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
// Zamknij przeglądarkę
        driver.quit();
    }
}