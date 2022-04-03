package JavaStartSeleniumRozdzial_9.page.objects;

import JavaStartSeleniumRozdzial_9.driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    private WebDriver driver;

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    public TopMenuPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    //  https://www.w3schools.com/cssref/css_selectors.asp
//  #firstname 	Selects the element with id="firstname"
// 	a[href*="w3schools"] 	Selects every <a> element whose href attribute value contains the substring "w3schools"
    public void clickOnSignInLink(){
        signOnLink.click();
    }
}
