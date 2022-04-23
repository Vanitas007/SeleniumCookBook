package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverUtils;
import JavaStartSeleniumRozdzial_9.page.objects.LandingPage;
import JavaStartSeleniumRozdzial_9.page.objects.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static JavaStartSeleniumRozdzial_9.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("P213456")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

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

