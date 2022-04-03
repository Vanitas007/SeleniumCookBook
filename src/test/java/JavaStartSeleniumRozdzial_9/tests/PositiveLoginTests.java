package JavaStartSeleniumRozdzial_9.tests;

import JavaStartSeleniumRozdzial_9.page.objects.FooterPage;
import JavaStartSeleniumRozdzial_9.page.objects.LandingPage;
import JavaStartSeleniumRozdzial_9.page.objects.LoginPage;
import JavaStartSeleniumRozdzial_9.page.objects.TopMenuPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();
        FooterPage footerPage = new FooterPage();

        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }
}

/** pierwotny test analogiczny do tego co wyżej przed refaktoryzacją xD */
//    @Test
//    public void asUserLoginUsingValidLoginAndPassword() {
//        WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
//        enterStoreLink.click();
//
//        WebElement signOnLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
//        signOnLink.click();
//
//        WebElement usernameField = driver.findElement(By.name("username"));
//        usernameField.clear();
//        usernameField.sendKeys("j2ee");
//
//        WebElement passwordField = driver.findElement(By.name("password"));
//        passwordField.clear();
//        passwordField.sendKeys("j2ee");
//
//        WebElement signOnButton = driver.findElement(By.name("signon"));
//        signOnButton.click();
//
//        WebElement bannerAfterLoginLogo = driver.findElement(By.cssSelector("#Banner img[src*='dog']"));
//        assertTrue(bannerAfterLoginLogo.isDisplayed());
//    }

//  https://www.w3schools.com/cssref/css_selectors.asp
//  #firstname 	Selects the element with id="firstname"
// 	a[href*="w3schools"] 	Selects every <a> element whose href attribute value contains the substring "w3schools"