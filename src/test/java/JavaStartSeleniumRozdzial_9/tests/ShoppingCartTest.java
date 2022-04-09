package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.page.objects.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        AnimalsCategoryPage animalsCategoryPage = new AnimalsCategoryPage();
        animalsCategoryPage
                .clickOnFishCategory()
                .clickOnAngelfishIdButton()
                .clickOnAddToCardLargeAngelfish()
                .clickOnProceedToCheckout();

        LoginPage loginPage = new LoginPage();
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}