package Rozdział_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ListiningTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void listingGoodExampleTest() {

        //Tworzymy listę wymaganych kategorii dla atrybutów href
        List<String> listOfHrefAttributes = new LinkedList<String>();
        listOfHrefAttributes.add("FISH");
        listOfHrefAttributes.add("DOGS");
        listOfHrefAttributes.add("REPTILES");
        listOfHrefAttributes.add("CATS");
        listOfHrefAttributes.add("BIRDS");

        //Sortujemy listę tak aby była ona w układzie alfabetycznym
        listOfHrefAttributes.sort(String::compareToIgnoreCase);

        //Tworzymy listę WebElementów dla linków lewej nawigacji
        List<WebElement> leftNavigationLinksList = driver.findElements(By.xpath("//*[@id='SidebarContent']/a"));

        //Tworzymy listę WebElementów dla linków górnej nawigacji
        List<WebElement> topNavigationLinksList = driver.findElements(By.xpath("//*[@id='QuickLinks']/a"));

        //Tworzymy listę WebElementów dla area pod zdjęciem papugi
        List<WebElement> bottomNavigationLinksList = driver.findElements(By.xpath("//*[@id='MainImageContent']//area"));

        //Sprawdzamy po kolei listy
        assertThatListIsCorrect(leftNavigationLinksList, listOfHrefAttributes);
        assertThatListIsCorrect(topNavigationLinksList, listOfHrefAttributes);
        assertThatListIsCorrect(bottomNavigationLinksList, listOfHrefAttributes);

    }

    //Metoda assertThatListIsCorrect przyjmuje dwa argumenty:
    // Pierwszy to aktualna lista WebElementów
    // Drugi to oczekiwana lista stringów (kategorii atrybutu href)
    private void assertThatListIsCorrect(List<WebElement> actualListOfWebElements, List<String> expectedListOfStrings) {

        //Tworzymy pustą listę, do niej będziemy dodawać teksty z listy WebElementów
        List<String> listOfHrefAttributes = new LinkedList<>();

        for (WebElement leftNavigationLink : actualListOfWebElements) {

            //Dla każdego WebElementu z listy sprawdzamy czy jest wyświetlony
            assertTrue(leftNavigationLink.isDisplayed());

            //Dla każdego WebElementu z listy pobieramy atrybut href, a następnie rozdzielamy metodą split()
            // na dwie części otrzymany String. Następnie bierzemy drugą [1] wartość wyrażenia czyli np. CATS
            String hrefCategory = leftNavigationLink.getAttribute("href").split("&categoryId=")[1];

            //Dodajemy uzyskaną nazwę kategorii do listy
            listOfHrefAttributes.add(hrefCategory);
        }

        // Sortujemy listę kategorii - analogicznie jak wyżej
        listOfHrefAttributes.sort(String::compareToIgnoreCase);

        // Sprawdzamy czy wielkość listy WebElementów jest taka sam jak wielkość listy oczekiwanej
        assertEquals(actualListOfWebElements.size(), expectedListOfStrings.size());

        //Sprawdzamy czy wartości w listach są takie same
        assertEquals(Arrays.toString(listOfHrefAttributes.toArray()), Arrays.toString(expectedListOfStrings.toArray()));
    }
}

