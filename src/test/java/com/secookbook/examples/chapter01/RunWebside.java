package com.secookbook.examples.chapter01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RunWebside {

    WebDriver driver;
    //stworzona zmienna sklepURL zeby nie trzebabylo wprowadzac linka do kazdego testu z osobna
    //automatyczna obsluga wyjatku za pomoca try/catch
    URL sklepURL = new URL("http://automationpractice.com/index.php");

    public RunWebside() throws MalformedURLException {
    }

    @BeforeMethod
    //przed każdym testem uruchamiany jest sterownik, przeglądarka i jest ona maksymalizowana
    public void driverSetup() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    // po każdym teście przeglądarka jest zamykana
    public void driverQuit() {
        driver.quit();
    }

    @Test
    //uruchomienie strony metodą .get czyści hisotrię (nie można używać potem metod:
    //navigate().forward(), navigate().back(), navigate().refresh()
    public void getMethodSklep() {
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    //analogicznie metoda .navigate przechowuje hisotrię umożliwiając nawigowanie metodami.
    public void navigateMethodSklep() {
        //driver.navigate().to("http://automationpractice.com/index.php");
        driver.navigate().to(sklepURL);
        /*metody .to można używać to string wklepując po prostu link do strony.
        Można też używać to URL. należy wtedy zrobić zmienną np.
        URL googleURL = new URL(https://www.google.pl/);
        i wpisać po prostu ...().to(googleURL);
        wtedy gdy zmieni się adres strony wystarczy zmienić jedną wartość, a nie w każdym tescie
        dodatkowo konieczna jest obsługa wyjątku. Na tym przykładzie try/catch
        zmienna URL wystawiłem na samą góre zeby mogla byc uzywana przez wysztkie testy.
         */
        driver.navigate().to("https://www.purepc.pl/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}