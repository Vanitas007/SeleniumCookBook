package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalsCategoryPage {

    private Logger logger = LogManager.getLogger(AnimalsCategoryPage.class);

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

    public FishListPage clickOnFishCategory() {
        WaitForElement.waitUntilElementIsClickable(fishButton);
        fishButton.click();
        logger.info("Clicked on Fish button");
        return new FishListPage();
    }

    public void clickOnDogsCategory() {
        WaitForElement.waitUntilElementIsClickable(dogsButton);
        dogsButton.click();
        logger.info("Clicked on Dogs button");
    }

    public void clickOnCatsCategory() {
        WaitForElement.waitUntilElementIsClickable(catsButton);
        catsButton.click();
        logger.info("Clicked on Cats button");
    }

    public void clickOnReptiliesCategory() {
        WaitForElement.waitUntilElementIsClickable(reptiliesButton);
        reptiliesButton.click();
        logger.info("Clicked on Reptilies button");
    }

    public void clickOnBirdsCategory() {
        WaitForElement.waitUntilElementIsClickable(birdsButton);
        birdsButton.click();
        logger.info("Clicked on Birds button");
    }
}
