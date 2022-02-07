package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/** Zadanie 5.2 */

public class FourthLocatorsExerciseTest {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstLocatorTest() {
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=");

        driver.findElement(By.name("username"));
        driver.findElement(By.name("password"));
        driver.findElement(By.name("repeatedPassword"));
// I do końca name
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }


}
