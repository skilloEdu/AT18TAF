package org.nnn.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public static final String LOGIN_PAGE_SUFIX = "/users/login";

    @FindBy(css = "p.h4")
    private WebElement loginFormTitle;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameInputField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordInputField;

    @FindBy(id = "sign-in-button")
    private WebElement loginSubmitButton;


    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver,this);
    }

    public void navigateToLoginPage(){
        navigateTo(LOGIN_PAGE_SUFIX);
    }

    public void provideUser(String userNameText){
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        //clear
        usernameInputField.clear();
        //send
        usernameInputField.sendKeys(userNameText);
    }

    public void providePass(String pass){
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        //clear
        passwordInputField.clear();
        //send
        passwordInputField.sendKeys(pass);
    }

    public void clickOnLoginFormSubmitButton(){
        wait.until(ExpectedConditions.visibilityOf(loginSubmitButton));
        loginSubmitButton.click();
    }

    public boolean isLoginFormHeaderTextShown(){
        return isElementPresented(loginFormTitle);
    }

    public String getLoginFormHeaderText(){
        return getElementText(loginFormTitle);
    }
}
