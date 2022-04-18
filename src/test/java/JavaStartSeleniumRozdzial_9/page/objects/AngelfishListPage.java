package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelfishListPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a.Button[href$=\"EST-1\"]")
    private WebElement addToCardLargeAngelfishButton;

    @FindBy(css = "a.Button[href$=\"EST-2\"]")
    private WebElement addToCardSmallAngelfishButton;

    public AngelfishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ShoppingCartPage clickOnAddToCardLargeAngelfish() {
        WaitForElement.waitUntilElementIsVisible(addToCardLargeAngelfishButton);
        addToCardLargeAngelfishButton.click();
        logger.info("Clicked on add to card large Angelfish button");
        return new ShoppingCartPage();
    }

    public void clickOnAddToCardSmallAngelfish() {
        WaitForElement.waitUntilElementIsVisible(addToCardSmallAngelfishButton);
        addToCardSmallAngelfishButton.click();
        logger.info("Clicked on add to card small Angelfish button");
    }


}
