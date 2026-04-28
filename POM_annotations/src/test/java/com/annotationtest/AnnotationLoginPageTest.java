package com.annotationtest;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.LoginPage;



public class AnnotationLoginPageTest extends BaseTestUsingAnnotation {

    @Test
    public void loginTest() {

        LoginPage objLogin = new LoginPage(driver);
      
        String title = objLogin.getLoginTitle();
        Assert.assertTrue(title.contains("Login"));

        
    }
}
