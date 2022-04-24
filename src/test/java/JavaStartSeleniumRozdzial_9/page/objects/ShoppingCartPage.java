package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage{

    @FindBy(css = "a[href$=\"newOrderForm=\"]")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public CheckoutPage clickOnProceedToCheckout(){
        WaitForElement.waitUntilElementIsVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Clicked on Proceed to Checkout Button");
        return new CheckoutPage();
    }

}
