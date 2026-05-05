package QA_FOX;
//dataproviders valid data
//prallelexection
//loggers
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.DataProviderQAfox;
import utils.ValidandInvaliddataProvider;

public class Login {
	public static Logger log = LogManager.getLogger(Login.class);
	 
	 private static ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();
	 public WebDriver drivers() {
	        return driver1.get();
	    }
	@BeforeMethod
	public void setup() {
		log.info("WebDriver creation");
		  WebDriver d = new EdgeDriver();
		  driver1.set(d);
	        drivers().manage().window().maximize();
	        drivers().get("https://tutorialsninja.com/demo/");
	        log.info("Launching browser");
	}
	
	@Test(
	        dataProvider = "validData", dataProviderClass = ValidandInvaliddataProvider.class , priority = 0
	    )
	public void Login( String name , String Password) throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(drivers(), Duration.ofSeconds(10));
		 
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
		 log.info("Navigation to the dropdown");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']"))).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated( By.name("email"))).sendKeys(name);
         log.info("Sending names");
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(Password);
         log.info("Sending Passwords");
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']"))).click();
         log.info("Click the submit button");
         WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='My Account']")));
         Assert.assertTrue(text.getText().contains("My Account"));
         Thread.sleep(4000);
         log.info("Waiting 4secons");
	}
	
	@Test(
	        dataProvider = "invalidData", dataProviderClass = ValidandInvaliddataProvider.class , priority = 1
	    )
	public void Login2( String name , String Password) throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(drivers(), Duration.ofSeconds(10));
		 
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
		 log.info("Navigation to the dropdown");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']"))).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated( By.name("email"))).sendKeys(name);
         log.info("Sending invalid  names");
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(Password);
         log.info("Sending  invalid Passwords");
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']"))).click();
         log.info("Click the submit button");
         WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
         Assert.assertTrue(text.getText().contains("Warning: No match for E-Mail Address and/or Password."));
         Thread.sleep(4000);
         log.info("Waiting 4secons");
	}
	
	
	@AfterMethod
	
	public void Reset() throws InterruptedException {
		
		drivers().quit();
		 log.info("driver closing");
		
	}

}
