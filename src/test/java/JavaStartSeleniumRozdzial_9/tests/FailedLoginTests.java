package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverUtils;
import JavaStartSeleniumRozdzial_9.page.objects.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static JavaStartSeleniumRozdzial_9.navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();
        loginPage
                .assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }

}

