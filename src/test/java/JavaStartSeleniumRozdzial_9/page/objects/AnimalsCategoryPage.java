package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalsCategoryPage {

    Logger logger = LogManager.getRootLogger();

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
        logger.info("Clicked on Fish button");
    }

    public void clickOnDogsCategory() {
        dogsButton.click();
        logger.info("Clicked on Dogs button");
    }

    public void clickOnCatsCategory() {
        catsButton.click();
        logger.info("Clicked on Cats button");
    }

    public void clickOnReptiliesCategory() {
        reptiliesButton.click();
        logger.info("Clicked on Reptilies button");
    }

    public void clickOnBirdsCategory() {
        birdsButton.click();
        logger.info("Clicked on Birds button");
    }
}
