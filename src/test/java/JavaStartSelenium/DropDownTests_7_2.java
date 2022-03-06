package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Zadanie 7.1. lipa
 */

public class DropDownTests_7_2 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void dropDownTest() {
        WebElement dropdownWebElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownWebElement);


        String selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Please select an option");

        select.selectByValue("1");
        selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Option 1");

        select.selectByValue("2");
        selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Option 2");


/** Sprawdza tylko czy są takie opcje do wyboru, ale ich nie wybiera */

//        List<WebElement> options = select.getOptions();
//        List<String> namesOfOptions = new ArrayList<>();
//
//        for (WebElement option: options){
//            namesOfOptions.add(option.getText());
//            System.out.println(option.getText());
//        }
//        List<String>expectedNamesOfOptions = new ArrayList<>();
//        expectedNamesOfOptions.add("Please select an option");
//        expectedNamesOfOptions.add("Option 1");
//        expectedNamesOfOptions.add("Option 2");
//
//        assertEquals(namesOfOptions,expectedNamesOfOptions);
    }


}
