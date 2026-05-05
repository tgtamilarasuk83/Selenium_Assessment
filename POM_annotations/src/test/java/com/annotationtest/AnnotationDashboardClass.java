package com.annotationtest;

import com.dataproviders.dataproviderclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.DashBoardPage;
import com.page.LoginPage;


public class AnnotationDashboardClass extends BaseTestUsingAnnotation {
	

	 @Test(
		        dataProvider = "excel", dataProviderClass = dataproviderclass.class
		    )
    public void dashboardTest(String name , String Password) {

        LoginPage objLogin = new LoginPage(driver);
        objLogin.login(name,Password );

        DashBoardPage objDashboard = new DashBoardPage(driver);
        System.out.println("Dashboard");
        Assert.assertTrue(objDashboard.getHometext().contains("Dashboard"));
    }
}
