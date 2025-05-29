package org.nnn.login;

import org.nnn.POM.HomePage;
import org.nnn.POM.LoginPage;
import org.nnn.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginHappyPathTests extends BaseTest {
    private static final String HOMEPAGE_TITLE = "ISkillo";
    private static final String LOGIN_FORM_TITLE = "Sign in";
    public static final String LOGIN_SUCCESSFUL_MSG = "Successful login!";
    public static final String LOGIN_NOT_SUCCESSFUL_MSG = "Wrong username or password!";

    @Test
    public void verifyTheUserCannotLoginWithInvalidCredentials() throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, log);
        log.info("STEP 1: Not logged in user has opened the Skillo HomePage.");
        homePage.openHomePage();

        log.info("STEP 1.1.Verify the user is on the home page ");
        // create a method in home page that will check the :
        // 1.1.1. Page Title
        String actualHomePageTitle = driver.getTitle();
        Assert.assertEquals(actualHomePageTitle,HOMEPAGE_TITLE);

        // 1.1.2. Verify the nav bar login link is shown
        log.info("STEP 1.1.2. Verify that the login link is presented ");
        boolean isShownNavBarLoginLink = homePage.isNavLoginShown();
        Assert.assertTrue(isShownNavBarLoginLink);

        log.info("STEP 2: The use is navigating to the login page via click on navigation bar login link");
        homePage.clickOnLoginNavBar();

        //Step 2.1. Verify the user is on login page
        log.info("STEP 2.1.: The user is successfully on the login page");
        LoginPage loginPage = new LoginPage(super.driver,log);

        //Verify loigin page form title is text is presented correctly written
        String actualLoginFormHeaderText = loginPage.getLoginFormHeaderText();
        Assert.assertEquals(actualLoginFormHeaderText,LOGIN_FORM_TITLE);


        //Step 3. Provide username
        log.info("STEP 3. Provide username");
        loginPage.provideUser(" ");

        //Step 4. Provide password
        log.info("STEP 4. Provide password");
        loginPage.providePass(" ");

        //Step 5. Click on login submit button
        log.info("STEP 4. Click on loginButton");
        loginPage.clickOnLoginFormSubmitButton();

        //Step 6. Verify successful flow
        //Step 6.1. Success message



        //Step 6.2. LogOut Button
        //Step 6.3. HomePage navigation bar profile link shown




        Thread.sleep(4444);


    }

}
