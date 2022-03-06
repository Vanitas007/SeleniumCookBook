package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FileUploadTests_7_3 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void fileUploadTest() {
        WebElement uploadFileButton = driver.findElement(By.id("file-upload"));
        uploadFileButton.sendKeys("D:\\Testowanie\\testfile.txt");

        WebElement fileSumbitButton = driver.findElement(By.id("file-submit"));
        fileSumbitButton.click();

        // Tutaj pajacowałem z assertTrue i metodą isDisplayed() :/
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedFiles.getText(), "testfile.txt");
    }


}
