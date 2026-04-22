package Logging;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataproviders.Exceldataprovider1;

public class Logging_demoblaze {

    WebDriver driver;
    public Logger log = LogManager.getLogger(Logging_demoblaze.class);

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        log.info("Browser launched and URL opened");
    }

    @Test(dataProvider = "excel", dataProviderClass = Exceldataprovider1.class)
    public void loginTest(String username, String password) {
    	try {
    	    driver.findElement(By.id("login2")).click();

    	    log.info("Attempting login with username: " + username);

    	    driver.findElement(By.id("loginusername")).sendKeys(username);
    	    
    	    
    	    log.info("Attempting login with password: " + password);
    	    driver.findElement(By.id("loginpassword")).sendKeys(password);
    	    driver.findElement(By.xpath("//button[text()='Log in']")).click();

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    String welcomeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))).getText();

//    	    if (welcomeText.contains("Welcome arasu")) {
//    	        log.info("Login successful for user");
//    	    } else {
//    	        log.error("Login failed for user");
//    	    }

    	    Assert.assertTrue( welcomeText.contains("Welcome arasu"),"Login failed for user: " + username);

    	} catch (Exception e) {
    	   // log.error("Exception occurred during login for user: " + username);
    	    log.error("Error message: " + e.getMessage());
    	}

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("Browser closed");
    }
}
