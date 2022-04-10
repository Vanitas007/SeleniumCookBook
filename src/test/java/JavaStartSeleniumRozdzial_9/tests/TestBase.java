package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.configuration.ConfigurationProperties;
import JavaStartSeleniumRozdzial_9.configuration.PropertiesLoader;
import JavaStartSeleniumRozdzial_9.driver.DriverManager;
import JavaStartSeleniumRozdzial_9.driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static JavaStartSeleniumRozdzial_9.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

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
