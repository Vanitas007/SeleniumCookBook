package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.page.objects.LandingPage;
import org.testng.annotations.Test;

public class ProceedToCheckoutTest extends TestBase{

    @Test
    public void addAngelFishToShoppingCardAndProceedToCheckout(){

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        


    }
}
