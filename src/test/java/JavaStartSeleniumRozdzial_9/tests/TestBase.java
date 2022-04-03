package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.driver.DriverManager;
import JavaStartSeleniumRozdzial_9.driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
