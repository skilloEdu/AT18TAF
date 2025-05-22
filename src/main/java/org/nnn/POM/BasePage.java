package org.nnn.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

     public void fillField(WebElement elm, String txt){
        wait.until(ExpectedConditions.visibilityOf(elm));
        elm.clear();
        elm.sendKeys(txt);
     }

    public void clickOn(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        System.out.println("The user has clicked on " + element);
    }

    private String locatorInfo(WebElement elm ){
        String[] rawWebElmInfo = elm.toString().split("->");
        String[] webElmInfo = rawWebElmInfo[1].split(":");
        String locatorStrategy = webElmInfo[0];
        String locatorExpression = webElmInfo[1];
        String info = "LOCATOR STRATEGY BY : "+ locatorStrategy.toUpperCase() + " WITH LOCATOR EXPRESSION"+ locatorExpression;
        return info;
    }
}
