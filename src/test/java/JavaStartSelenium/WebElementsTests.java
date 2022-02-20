package JavaStartSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/** Temat 7 Metoda sendKeys() oraz getAttribute() */

public class WebElementsTests {

    private WebDriver driver;

    private void sleep(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    @Test
    public void typingIntoWebElementTest(){
        WebElement userNameField  = driver.findElement(By.id("username"));
        sleep();
        userNameField .sendKeys("Selenium Start");
        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();
        assertEquals(typeUserNameValue,"Selenium Start");
    }

    @Test
    public void filePickingTest(){
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("D:\\WeebsOut.png");

        /** Niestety test nie kończy się asercją, ponieważ nie mamy możliwości zaglądnięcia do wnętrza kontrolki
          (jest to po stronie sesji przeglądarki, do której Selenium nie ma dostępu). Dlatego nie jest to pełnoprawny
          test. W prawdziwym życiu po wybraniu poprawnego lub niepoprawnego pliku i kliknięciu „Załaduj”
          dostalibyśmy prawdopodobnie komunikat (o sukcesie lub porażce), do którego Selenium ma już dostęp.
         */
    }

    @Test
    public void typingAndClearingValueInsideWebElementTest(){
        WebElement userNameField  = driver.findElement(By.id("username"));
        sleep();
        userNameField .sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();

        assertEquals(typeUserNameValue,"Selenium Start");

        userNameField.clear();
        sleep();

        String emptyUserNameField = userNameField.getAttribute("value");
        assertEquals(emptyUserNameField,"");
    }

    @Test
    public void checkRadioButtonTest(){
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        sleep();
        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected());

        femaleRadioButton.click();
        sleep();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
    public void checkboxButtonTest(){
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        sleep();
        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());

        sleep();
        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();
        sleep();
        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());
    }

    @Test
    public void dropDownListingTest(){
        sleep();
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        List<WebElement> options = countryDropDown.getOptions();
        List<String> namesOfOptions = new ArrayList<>();

        for (WebElement option : options){
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }

        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");
        sleep();
        assertEquals(namesOfOptions, expectedNamesOfOptions);
    }
}
