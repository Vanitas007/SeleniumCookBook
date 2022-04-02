package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.page.objects.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        AnimalsCategoryPage animalsCategoryPage = new AnimalsCategoryPage(driver);
        animalsCategoryPage.clickOnFishCategory();

        FishListPage fishCategoryPage = new FishListPage(driver);
        fishCategoryPage.clickOnAngelfishIdButton();

        AngelfishListPage angelfishListPage = new AngelfishListPage(driver);
        angelfishListPage.clickOnAddToCardLargeAngelfish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnProceedToCheckout();

        LoginPage loginPage = new LoginPage(driver);
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");

    }
}