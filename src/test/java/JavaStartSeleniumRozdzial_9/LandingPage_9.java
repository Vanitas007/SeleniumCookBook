package JavaStartSeleniumRozdzial_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage_9 {

    private WebDriver driver;

   public LandingPage_9(WebDriver driver){
       this.driver=driver;
   }
   public void clickOnEnterStoreLink(){
       WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
       enterStoreLink.click();
   }
}
