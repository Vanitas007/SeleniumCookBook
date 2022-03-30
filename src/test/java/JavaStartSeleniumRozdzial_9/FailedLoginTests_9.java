package JavaStartSeleniumRozdzial_9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Temat 9 - Wstęp oraz pierwszy test
 * <p>
 * Trzeba ogarniać selektory CSS. Szczególnie ten z assercji.
 */

public class FailedLoginTests_9 {

    private WebDriver driver;
//    private LandingPage_9 landingPage_9;


    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("NotExistingLogin");
        loginPage.typeIntoPasswordField("NotProperPassword");
        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();

        FooterPage footerPage = new FooterPage(driver);
        footerPage.isBannerAfterLoginDisplayed();

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