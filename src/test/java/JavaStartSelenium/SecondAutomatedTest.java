package JavaStartSelenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SecondAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void mySecondTest() {
        driver.navigate().to("https://selenium.dev/");

        String pageTitle = driver.getTitle();

//        assertTrue(pageTitle.equals("Selenium"));
        assertEquals(pageTitle,"Selenium");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}

