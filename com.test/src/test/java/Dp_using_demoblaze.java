import java.time.Duration;

import org.openqa.selenium.Alert;
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

public class Dp_using_demoblaze {
	  
	  
	 static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	 WebDriver driver1; 

	    @BeforeMethod   
	    public void setup() {

	        driver.set(new EdgeDriver());
	        driver1 = driver.get();	
	       	
	        driver1.get("https://www.demoblaze.com/");
	        
	    }
   
	    //valid login 
	    @Test(dataProvider = "demoblaze1", dataProviderClass = valiid_dp.class)
	   
	    public void loginTest(String userName, String password) {

	        driver1.findElement(By.id("login2")).click();
	        
	        
	      
	        driver1.findElement(By.id("loginusername")).sendKeys(userName);
	        driver1.findElement(By.id("loginpassword")).sendKeys(password);
	        driver1.findElement(By.xpath("//button[text()='Log in']")).click();
	    }
	    
	    //invalid login 
	    
	    @Test(dataProvider = "demoblaze", dataProviderClass = Dp_for_demo.class)

	    public void invalidTest(String userName, String password)  {

	        driver1.findElement(By.id("login2")).click();

	        driver1.findElement(By.id("loginusername")).sendKeys(userName);

	        driver1.findElement(By.id("loginpassword")).sendKeys(password);

	        driver1.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

	        // handle alert
	        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    
	        String s = alert.getText();
	        String password1 = "Wrong password.";
	        String user = "Wrong password.";
	        
	        
	        if(s.equalsIgnoreCase(password1)) {
	        	 Assert.assertEquals(s, password1);
		 	        alert.accept();
	        }
	        else {
	        	Assert.assertEquals(s, user);
	 	        alert.accept();
	        }
	        
	        
	        
	        
	        

	       
	        
	        
	    }        
	       
	    @AfterMethod
	    public void afterTest() {
	    	driver1.quit();;
	        
	    }
}
