package JavaStartSeleniumRozdzial_9.driver;

import JavaStartSeleniumRozdzial_9.configuration.LocalWebDriverProperties;
import JavaStartSeleniumRozdzial_9.driver.manager.BrowserFactory;
import JavaStartSeleniumRozdzial_9.driver.manager.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)){
            driver.quit();
        }
        driver = null;
    }
}