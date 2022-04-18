package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href$=\"=FI-SW-01\"]")
    private WebElement angelfishIdButton;

    @FindBy(css = "a[href$=\"=FI-SW-02\"]")
    private WebElement tigerSharkIdButton;

    @FindBy(css = "a[href$=\"=FI-FW-01\"]")
    private WebElement koiIdButton;

    @FindBy(css = "a[href$=\"=FI-FW-01\"]")
    private WebElement goldfishIdButton;


    public FishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AngelfishListPage clickOnAngelfishIdButton() {
        WaitForElement.waitUntilElementIsVisible(angelfishIdButton);
        angelfishIdButton.click();
        logger.info("Clicked AngelfishID button");
        return new AngelfishListPage();
    }

    public void clickOnTigerSharkIdButton() {
        WaitForElement.waitUntilElementIsClickable(tigerSharkIdButton);
        tigerSharkIdButton.click();
        logger.info("Clicked on TigerSharkID button");
    }

    public void clickOnKoiIdButtonIdButton() {
        WaitForElement.waitUntilElementIsClickable(koiIdButton);
        koiIdButton.click();
        logger.info("Clicked on KoiID button");
    }

    public void clickOnGoldfishIdButton() {
        WaitForElement.waitUntilElementIsClickable(goldfishIdButton);
        goldfishIdButton.click();
        logger.info("Clicked on GoldfishID button");
    }
}