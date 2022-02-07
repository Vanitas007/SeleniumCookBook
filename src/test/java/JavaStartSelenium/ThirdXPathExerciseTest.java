package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/** Zadanie 5.1 */

public class ThirdXPathExerciseTest {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstXpathTest() {
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");

        driver.findElement(By.xpath("//*[@id=\"Logo\"]"));

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}

/**
 * PPM->Copy->Copy Xpath
 * i wszystko siada zgodnie ze wzorem
 */

//div[@id='Logo']//img
//img[@name='img_cart']
//div[@id='MenuContent']/a[2]
//div[@id='MenuContent']/a[3]
//input[@name='keyword']
//input[@name='searchProducts']
//div[@id="QuickLinks"]/a[1]/img
//div[@id="QuickLinks"]/a[2]/img
//div[@id="QuickLinks"]/a[3]/img
//div[@id="QuickLinks"]/a[4]/img
//div[@id="QuickLinks"]/a[5]/img
//div[@id="SidebarContent"]/a[1]/img
//div[@id="SidebarContent"]/a[2]/img
//div[@id="SidebarContent"]/a[3]/img
//div[@id="SidebarContent"]/a[4]/img
//div[@id="SidebarContent"]/a[5]/img
//div[@id="MainImageContent"]/img
//div[@id="PoweredBy"]/a
