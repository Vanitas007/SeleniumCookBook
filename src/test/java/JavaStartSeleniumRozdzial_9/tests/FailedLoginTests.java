package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.page.objects.LandingPage;
import JavaStartSeleniumRozdzial_9.page.objects.LoginPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();
        LoginPage loginPage = new LoginPage();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }
}

