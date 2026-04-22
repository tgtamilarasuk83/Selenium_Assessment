import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demoblaze_application {

    public WebDriver driver;
    @Parameters({"browser" ,"url"})
    @BeforeTest
   
    public void setup(String browser ,String Url) {

        if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    
    //valid login 
    @Parameters({"username", "password"})
    @Test(priority = 1)
   
    public void loginTest(String userName, String password) {

        driver.findElement(By.id("login2")).click();
        
      
        driver.findElement(By.id("loginusername")).sendKeys(userName);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }
    
    //invalid login 
    
    @Test (priority = 2)
    @Parameters({"username1", "password1"})
    public void invalidTest(String userName, String password)  {

        driver.findElement(By.id("login2")).click();

        driver.findElement(By.id("loginusername")).sendKeys(userName);

        driver.findElement(By.id("loginpassword")).sendKeys(password);

        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        // handle alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    
        String s = alert.getText();
        String y = "Wrong password.";

        Assert.assertEquals(s, y);
        alert.accept();
        
        
    }
    
    //invalid login 
    
    @Test (priority = 3)
    @Parameters({"username2", "password2"})
    public void invalidTest2(String userName, String password)  {

        driver.findElement(By.id("login2")).click();

        driver.findElement(By.id("loginusername")).sendKeys(userName);

        driver.findElement(By.id("loginpassword")).sendKeys(password);

        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        // handle alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    
        String s = alert.getText();
        String y = "Wrong password.";
        Assert.assertEquals(s, y);
        alert.accept();
        
        
    }
    
    @AfterTest
    public void afterTest() {
    	driver.quit();;
        
    }
    
}
