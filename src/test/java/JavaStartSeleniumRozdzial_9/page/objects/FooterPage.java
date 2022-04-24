package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static JavaStartSeleniumRozdzial_9.generic.assertions.AssertWebElement.assertThat;

public class FooterPage extends BasePage{

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed(){
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        assertThat(bannerAfterLoginLogo).isDisplayed();
        return this;
    }
}
