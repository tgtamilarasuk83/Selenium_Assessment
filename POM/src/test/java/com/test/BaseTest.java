package com.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.page.DashBoard;
import com.page.LoginPage;

public class BaseTest {
	
	public static WebDriver driver;
	LoginPage objLogin;
	DashBoard objDAshBoard;
	
	@BeforeClass
	public void Setup() {
		driver = new EdgeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("opening");
	}

	@AfterClass
	public void quit() {
		
		driver.quit();
		System.out.println("closing");
	}
	
}
