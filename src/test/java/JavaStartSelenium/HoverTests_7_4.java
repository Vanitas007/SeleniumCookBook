package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HoverTests_7_4 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void hoverTest() {
        WebElement userOneAvatar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        Actions akcja = new Actions(driver);




    }
}
