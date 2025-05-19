package org.nnn.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final String LOGIN_PAGE_SUFIX = "/users/login";

    //UI MAP
    public static final String username_id = "defaultLoginFormUsername";
    public static final String password_id = "defaultLoginFormPassword";
    public static final String login_form_submit_btn_id = "sign-in-button";

    public LoginPage (WebDriver driver){
        super(driver);
    }

    public void navigateToLoginPage(){
        navigateTo(LOGIN_PAGE_SUFIX);
    }

    public void provideUser(String userNameText){
        WebElement userName = driver.findElement(By.id(username_id));
        wait.until(ExpectedConditions.visibilityOf(userName));
        //clear
        userName.clear();
        //send
        userName.sendKeys(userNameText);
    }

    public void providePass(String pass){
        WebElement passWord = driver.findElement(By.id(password_id));
        wait.until(ExpectedConditions.visibilityOf(passWord));
        //clear
        passWord.clear();
        //send
        passWord.sendKeys(pass);
    }

    public void clickOnLoginFormSubmitButton(){
        WebElement loginBtn = driver.findElement(By.id(login_form_submit_btn_id));
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }
}
