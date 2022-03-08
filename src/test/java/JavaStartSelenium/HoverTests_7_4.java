package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/** LIPA */

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
        WebElement userOneAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[1]"));
        WebElement userTwoAvatar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        WebElement userThreeAvatar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

        Actions action = new Actions(driver);
        action.moveToElement(userOneAvatar).perform();

        WebElement userOneCaption = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement userTwoCaption = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement userThreeCaption = driver.findElement(By.xpath("//div[3]/div/h5"));

        assertEquals(userOneCaption.getText(), "name: user1");
        assertEquals(userTwoCaption.getText(), "");
        assertEquals(userThreeCaption.getText(), "");

        action.moveToElement(userTwoAvatar).perform();

        assertEquals(userOneCaption.getText(), "");
        assertEquals(userTwoCaption.getText(), "name: user2");
        assertEquals(userThreeCaption.getText(), "");

        action.moveToElement(userThreeAvatar).perform();

        assertEquals(userOneCaption.getText(), "");
        assertEquals(userTwoCaption.getText(), "");
        assertEquals(userThreeCaption.getText(), "name: user3");
    }
}
