package com.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

public class LoginPage {
	
	WebDriver driver;
	By username =  By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By Login = By.xpath("//button[@type='submit']");	
	By Title = By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
	
	  public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }
	
	public void setusername(String name) {
		driver.findElement(username).sendKeys(name);
		
	}
	
	public void setpassword(String pass) {
		driver.findElement(password).sendKeys(pass);
		
	}
	public void Loginclick() {
		driver.findElement(Login).click();
		
	}
	
	public String  getLoginTitle() {
		
		return driver.findElement(Title).getText();
		
	}
	
	
	
	public void login(String name, String pass) {
	    this.setusername(name);
	    this.setpassword(pass);
	    this.Loginclick();
	}


	       
	    
	

}
