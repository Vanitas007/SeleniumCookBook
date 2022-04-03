package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private WebDriver driver;

    @FindBy(css = "a[href$=\"newOrderForm=\"]")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnProceedToCheckout(){
        proceedToCheckoutButton.click();
    }

}
