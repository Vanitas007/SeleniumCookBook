package Rozdzial_9.page.objects;

import Rozdzial_9.driver.manager.DriverManager;
import Rozdzial_9.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage extends BasePage{

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
        log().info("Clicked AngelfishID button");
        return new AngelfishListPage();
    }

    public void clickOnTigerSharkIdButton() {
        WaitForElement.waitUntilElementIsClickable(tigerSharkIdButton);
        tigerSharkIdButton.click();
        log().info("Clicked on TigerSharkID button");
    }

    public void clickOnKoiIdButtonIdButton() {
        WaitForElement.waitUntilElementIsClickable(koiIdButton);
        koiIdButton.click();
        log().info("Clicked on KoiID button");
    }

    public void clickOnGoldfishIdButton() {
        WaitForElement.waitUntilElementIsClickable(goldfishIdButton);
        goldfishIdButton.click();
        log().info("Clicked on GoldfishID button");
    }
}