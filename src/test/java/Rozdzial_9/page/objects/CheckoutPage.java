package Rozdzial_9.page.objects;


import Rozdzial_9.driver.manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}