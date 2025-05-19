package org.nnn.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static final String BASE_URL = "http://training.skillo-bg.com:4300";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateTo(String pageURLSUFIX) {
        String urlToBeLoaded = BASE_URL+pageURLSUFIX;

        driver.get(urlToBeLoaded);
        System.out.println("THE USER HAS NAVIGATED TO " + urlToBeLoaded);
    }

}
