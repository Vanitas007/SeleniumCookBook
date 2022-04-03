package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import JavaStartSeleniumRozdzial_9.waits.WaitForElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

    private WebDriver driver;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isBannerAfterLoginDisplayed(){
        WaitForElement.waitUntilEmenentsVisable(bannerAfterLoginLogo);
        boolean isDisplayed = bannerAfterLoginLogo.isDisplayed();
        return isDisplayed;
    }

}
