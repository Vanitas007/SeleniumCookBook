package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalsCategoryPage {

    private WebDriver driver;

    @FindBy(css = "a[href$=\"Id=FISH\"]")
    private WebElement fishButton;

    @FindBy(css = "a[href$=\"Id=DOGS\"]")
    private WebElement dogsButton;

    @FindBy(css = "a[href$=\"Id=CATS\"]")
    private WebElement catsButton;

    @FindBy(css = "a[href$=\"Id=REPTILIES\"]")
    private WebElement reptiliesButton;

    @FindBy(css = "a[href$=\"Id=BIRDS\"]")
    private WebElement birdsButton;


    public AnimalsCategoryPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnFishCategory() {
        fishButton.click();
    }

    public void clickOnDogsCategory() {
        dogsButton.click();
    }

    public void clickOnCatsCategory() {
        catsButton.click();
    }

    public void clickOnReptiliesCategory() {
        reptiliesButton.click();
    }

    public void clickOnBirdsCategory() {
        birdsButton.click();
    }
}
