package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private Logger logger = LogManager.getLogger(ShoppingCartPage.class);

    @FindBy(css = "a[href$=\"newOrderForm=\"]")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public CheckoutPage clickOnProceedToCheckout(){
        WaitForElement.waitUntilElementIsVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked on Proceed to Checkout Button");
        return new CheckoutPage();
    }

}
