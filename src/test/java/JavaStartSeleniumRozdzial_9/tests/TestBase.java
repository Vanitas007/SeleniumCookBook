package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.configuration.ConfigurationProperties;
import JavaStartSeleniumRozdzial_9.configuration.PropertiesLoader;
import JavaStartSeleniumRozdzial_9.driver.DriverUtils;
import JavaStartSeleniumRozdzial_9.driver.manager.BrowserType;
import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import java.util.Properties;

import static JavaStartSeleniumRozdzial_9.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting up browser to: {browserType} and navigating to Home Page")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
