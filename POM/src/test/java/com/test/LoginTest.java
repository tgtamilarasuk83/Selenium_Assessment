package com.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.LoginPage;

public class LoginTest extends BaseTest {
 

    LoginPage objLogin;
    

    @Test
    public void loginTest() {

    	 objLogin = new LoginPage(driver);

        String logintitle = objLogin.getLoginTitle();

        Assert.assertTrue(logintitle.contains("Login"), "Title does not contain Login");
    }
}
