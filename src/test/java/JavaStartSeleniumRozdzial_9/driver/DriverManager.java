package JavaStartSeleniumRozdzial_9.driver;

import JavaStartSeleniumRozdzial_9.driver.manager.BrowserFactory;
import org.openqa.selenium.WebDriver;

import static JavaStartSeleniumRozdzial_9.configuration.TestRunProperties.getBrowserToRun;
import static JavaStartSeleniumRozdzial_9.configuration.TestRunProperties.getIsRemoteRun;
import static JavaStartSeleniumRozdzial_9.driver.manager.BrowserType.FIREFOX;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}