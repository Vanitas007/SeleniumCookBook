package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.page.objects.AnimalsCategoryPage;
import JavaStartSeleniumRozdzial_9.page.objects.LandingPage;
import JavaStartSeleniumRozdzial_9.page.objects.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {

    @TmsLink("P444555")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to buy small fish without loging in and check if warning message" +
            " You must sign on before attempting to check out. Please sign on and try checking out again is displayed")
    public void asNotLoggedInUserIShallNotProceedToCheckout() {

        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnEnterStoreLink();

        AnimalsCategoryPage animalsCategoryPage = new AnimalsCategoryPage();
        animalsCategoryPage
                .clickOnFishCategory()
                .clickOnAngelfishIdButton()
                .clickOnAddToCardLargeAngelfish()
                .clickOnProceedToCheckout();

        LoginPage loginPage = new LoginPage();
        loginPage
                .assertVisibilityOfWarningMessageAfterProceedChceckoutAsNotLoggedUser("You "+
                "must sign on before attempting to check out. Please sign on and try checking out again.");

    }
}