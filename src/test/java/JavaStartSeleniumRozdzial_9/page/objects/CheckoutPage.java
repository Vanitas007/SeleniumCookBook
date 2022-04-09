package JavaStartSeleniumRozdzial_9.page.objects;


import JavaStartSeleniumRozdzial_9.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}