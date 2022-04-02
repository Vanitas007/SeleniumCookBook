package JavaStartSeleniumRozdzial_9.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    private WebDriver driver;

    @FindBy(css = "a[href$=\"=FI-SW-01\"]")
    private WebElement angelfishIdButton;

    @FindBy(css = "a[href$=\"=FI-SW-02\"]")
    private WebElement tigerSharkIdButton;

    @FindBy(css = "a[href$=\"=FI-FW-01\"]")
    private WebElement koiIdButton;

    @FindBy(css = "a[href$=\"=FI-FW-01\"]")
    private WebElement goldfishIdButton;


    public FishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAngelfishIdButton() {
        angelfishIdButton.click();
    }

    public void clickOnTigerSharkIdButton() {
        tigerSharkIdButton.click();
    }

    public void clickOnKoiIdButtonIdButton() {
        koiIdButton.click();
    }

    public void clickOnGoldfishIdButton() {
        goldfishIdButton.click();
    }
}
