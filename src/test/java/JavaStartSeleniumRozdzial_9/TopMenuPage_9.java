package JavaStartSeleniumRozdzial_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage_9 {

    private WebDriver driver;

    public TopMenuPage_9(WebDriver driver){
        this.driver=driver;
    }

    //  https://www.w3schools.com/cssref/css_selectors.asp
//  #firstname 	Selects the element with id="firstname"
// 	a[href*="w3schools"] 	Selects every <a> element whose href attribute value contains the substring "w3schools"
    public void clickOnSignInLink(){
        WebElement signOnLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signOnLink.click();
    }
}
