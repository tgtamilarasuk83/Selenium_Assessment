package com.test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.DashBoard;
import com.page.LoginPage;

public class DashBoardTest extends BaseTest {

    LoginPage objLogin;
    DashBoard objDashboard;


    @Test
    public void dashboardTest() {

        objLogin = new LoginPage(driver);
        objLogin.login("Admin", "admin123");

        objDashboard = new DashBoard(driver);
        
        Assert.assertTrue(objDashboard.getHometext().contains("Dashboard"));


    }
}
