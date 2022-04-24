package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage extends BasePage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        log().info("Clicked on Sign on Link");
        return new LoginPage();
    }
}
