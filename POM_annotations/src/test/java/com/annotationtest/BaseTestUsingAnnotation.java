package com.annotationtest;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestUsingAnnotation {

    public WebDriver driver;

    @BeforeClass
    public void setup() {
    	  driver = new ChromeDriver();
    	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	}

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
