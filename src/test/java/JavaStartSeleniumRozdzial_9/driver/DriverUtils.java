package JavaStartSeleniumRozdzial_9.driver;


import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import io.qameta.allure.Step;

public class DriverUtils {

    @Step("Maximizing browser window")
    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Navigating to URL: {pageUrl}")
    public static void navigateToPage(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
