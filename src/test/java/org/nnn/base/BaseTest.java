package org.nnn.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("THE USER HAS STARTED CHROME BROWSER");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            System.out.println("THE USER HAS KILLED THE BROWSER");
        }
    }



}
