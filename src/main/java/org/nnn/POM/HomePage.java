package org.nnn.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    //1. PAGE URL
    public static final String HOME_PAGE_SUFIX = "/posts/all";

    //2.LOCAL CONSTS
    // LABELS TEXT ETC
    // HOME PAGE TITLE

    //3.UI ELEMENTS
    public static final String nav_bar_home_link_ID = "nav-link-home";
    public static final String nav_bar_login_link_ID = "nav-link-login";

    //4. CONSTRUCTOR
    public HomePage (WebDriver driver){
        super(driver);
    }

    //5. BASIC NAVIGATION
   public void navigateToHomePage(){
        navigateTo(HOME_PAGE_SUFIX);
    }

    //6. USER ACTIONS
    public void clickOnHomeNavBar(){
        WebElement navBarHome = driver.findElement(By.id(nav_bar_home_link_ID));
        wait.until(ExpectedConditions.visibilityOf(navBarHome));
        navBarHome.click();
    }

    public void clickOnLoginNavBar(){
        WebElement navBarHome = driver.findElement(By.id(nav_bar_login_link_ID));
        wait.until(ExpectedConditions.visibilityOf(navBarHome));
        navBarHome.click();
    }


    // 6.1. Click on some chosen navigation link

    //SUPPORT METHODS
    //GEtters
    //Boolean - > logout btn missing when user not successfully logedin

}
