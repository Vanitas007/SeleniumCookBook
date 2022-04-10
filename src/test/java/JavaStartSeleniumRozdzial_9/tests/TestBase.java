package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.driver.DriverManager;
import JavaStartSeleniumRozdzial_9.driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static JavaStartSeleniumRozdzial_9.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
