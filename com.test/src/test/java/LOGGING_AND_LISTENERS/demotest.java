package LOGGING_AND_LISTENERS;


import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(demolistenerfail.class)
public class demotest {

        public WebDriver driver;
       
	    @BeforeMethod
	    public void beforeTest() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://tutorialsninja.com/demo/index.php");
	    }
	   
	    @Test
	    public void loginTest() {
	        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	        driver.findElement(By.id("input-email")).sendKeys("subhashreerajait@gmail.com");
	        driver.findElement(By.id("input-password")).sendKeys("Subha123");
	        driver.findElement(By.xpath("//input[@value='Login']")).click();

	        String title = driver.getTitle();
	        Assert.assertTrue(title.contains("Accountss"));
	    }

	    @AfterMethod
	    public void afterTest() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}