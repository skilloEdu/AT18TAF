package org.nnn.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrationPage extends BasePage {

    public static final String REG_PAGE_SUFIX = "/users/register";
    private static final String EXPECTED_REG_FORM_HEADER_TEXT = "Sign up";
    private static final String EXPECTED_REG_MSG = "Successful register!";

    //2.LOCATORS
    //Registration form
    @FindBy(xpath = "//input[contains(@name, \"username\")]") // = driver.findElement(By.xpath(USERNAME_REG_INPUT_FIELD_XPATH));
    private WebElement regUsernameInputField;

    @FindBy (xpath = "//input[contains(@type, \"email\")]")
    private WebElement regEmailInputField;

    @FindBy (xpath = "//input[contains(@formcontrolname, \"birthDate\")]")
    private WebElement regBirthDateInputField;

    @FindBy (id = "defaultRegisterFormPassword" )
    private WebElement regPasswordInputField;

    @FindBy (id = "defaultRegisterPhonePassword")
    private WebElement regConfirmPasswordInputField;

    @FindBy (xpath = "//textarea")
    private WebElement publicInfoTextArea;

    @FindBy (id = "sign-in-button" )
    private WebElement registrationFormSubmitButton;


    public RegistrationPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Navigation to the page
    public void navigateToRegistrationPageByURL(){
        navigateTo(REG_PAGE_SUFIX);
    }

    //User Actions
    //Populate data in input fields
    public void provideUserName(){
        String providedDemoUser = demoUsername();
        fillField(regUsernameInputField,providedDemoUser);
    };

    public void provideEmail(){
        fillField(regEmailInputField,randomValidEmail());
    };

    public void provideBDayInfo(){
        fillField(regBirthDateInputField,"22022022");
    };

    public void providePass(){
        fillField(regPasswordInputField,"22022022!A");
    };

    public void providePassConfirm(){
        fillField(regConfirmPasswordInputField,"22022022!A");
    };

    public void providePublicInfo(){
        fillField(publicInfoTextArea,"Public profile");
    };

    public void clickOnSubmitBtn(){
        clickOn(registrationFormSubmitButton);
    }


    //Support methods for reg page
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }


    //Support utils for test data gen
    public String demoUsername() {
        String username = "Demo" + getCurrentTime();
        return username;
    }

    public String randomValidEmail() {
        String email = "demo" + getCurrentTime() + "@gmail.com";
        return email;
    }
}
