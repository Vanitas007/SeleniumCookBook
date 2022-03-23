package JavaStartSeleniumRozdzial_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

/** Temat 9 - Wstęo oraz pierwszy test
 *
 * Trzeba ogarniać selektory CSS. Szczególnie ten z assercji. */

public class MyFirstTest_9 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    @Test
    public void myFirstTest(){
        driver.findElement(By.cssSelector("#Content a")).click();
//  https://www.w3schools.com/cssref/css_selectors.asp
//  #firstname 	Selects the element with id="firstname"
// 	a[href*="w3schools"] 	Selects every <a> element whose href attribute value contains the substring "w3schools"
        driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']")).click();

        driver.findElement(By.name("username")).sendKeys("qwe");
        driver.findElement(By.name("password")).sendKeys("rty");
        driver.findElement(By.name("signon")).click();

        assertEquals(driver.findElement(By.cssSelector("#Content ul[class='messages'] li")).getText(), "Invalid username or password. Signon failed.");
    }
}
