package com.secookbook.examples.chapter01;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginAutomation {
    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().maximize();
        /*
        https://stackoverflow.com/questions/63102108/driver-geturl-vs-driver-navigate-tourl
        driver.get(“url”); ładuje strone, ale nie przechowuje historii
        driver.navigate().to(“url’); łąduje strone i przechowuje historię przeglądarki umożliwiając
        navigate().forward(), navigate().back(), navigate().refresh()
        */
        driver.get("https://www.twitch.tv/directory");
        driver.quit();
    }
}
