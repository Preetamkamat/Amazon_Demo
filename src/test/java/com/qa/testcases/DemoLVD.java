package com.qa.testcases;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DemoLVD {
    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://vserver.co.in/LVDQA/WWW/AdminPanel/Login.html");
    }


    @Test(priority = 0)
    public void verifyEmailField() {
        boolean emailfield = driver.findElement(By.id("txt_emailId")).isDisplayed();
        Assert.assertEquals(emailfield, true);
    }

    @Test(priority = 1)
    public void verifyPasswordField() {
        boolean passwordfield = driver.findElement(By.id("txt_password")).isDisplayed();
        Assert.assertEquals(passwordfield, true);
    }

    @Test(priority = 3)
    public void verifyLoginScreen() throws InterruptedException {
        driver.findElement(By.id("txt_emailId")).sendKeys("admin@lvd.com");
        driver.findElement(By.id("txt_password")).sendKeys("123123");
        driver.findElement(By.id("btn_login")).click();
        Thread.sleep(5000);
        boolean profilepic = driver.findElement(By.xpath("//a[@class='dropdown-toggle profilePic ellipsis ng-binding ng-scope']")).isDisplayed();
        Assert.assertEquals(profilepic, true);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
