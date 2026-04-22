package com.testNG.TestNGApplicationtesting;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsssertionsTest {
	  WebDriver driver;
	  SoftAssert asser = new SoftAssert();

	    @BeforeMethod
	    public void beforeTest() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.get("https://demoblaze.com/");
	    }
	    @Test 
	    public void loginTest()  {

	        driver.findElement(By.id("login2")).click();

	        driver.findElement(By.id("loginusername")).sendKeys("arasu");

	        driver.findElement(By.id("loginpassword")).sendKeys("arasu");

	        driver.findElement(By.xpath("//button[text() ='Log in' ]")).click();
	        
	        
	      //  assertThat(driver.getTitle(), is("https://www.demoblaze.com/"));
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement Element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Welcome arasu')]")));
		    String Element2 ="Welcome arasu";
		    
		    
		   asser.assertEquals(Element.getText(), Element2,"login sucessfull");
		    
		    
		  //  Assert.assertEquals(Element.getText(), Element2);
		   // System.out.println("successful");
		   asser.assertAll();

	    }
	    
	    
	    @Test 
	    public void invalidTest()  {

	        driver.findElement(By.id("login2")).click();

	        driver.findElement(By.id("loginusername")).sendKeys("arasu");

	        driver.findElement(By.id("loginpassword")).sendKeys("arasu1");

	        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

	        // handle alert
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    
	        String s = alert.getText();
	        String y = "Wrong password.";
	        asser.assertEquals(s,y);
	        //Assert.assertEquals(s, y);
	        alert.accept();
	       asser.assertAll();
	        
	        
	    }
	   
	    @Test
	    public void invalidTest2() {

	        driver.findElement(By.id("login2")).click();

	        driver.findElement(By.id("loginusername")).sendKeys("arasu1");

	        driver.findElement(By.id("loginpassword")).sendKeys("arasu");

	        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

	        // handle alert
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());  
	        
	        String s = alert.getText();
	        String y = "Wrong password.";
	        asser.assertEquals(s,y);
	       // Assert.assertEquals(s, y);
	        alert.accept();
	       asser.assertAll();
	    }


	    @AfterMethod
	    public void afterTest() {
	    	driver.quit();;
	        
	    }
}
