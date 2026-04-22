import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dataprovides_clas {

    
    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  

    @BeforeMethod()
    public void setup() {
    	  driver.set(new EdgeDriver()); 
    	  WebDriver driver1 = driver.get();
    	   
        driver1.manage().window().maximize();
        driver1.get("https://www.bing.com/");
        
    }

   

    @Test(dataProvider = "testdata" , dataProviderClass = Class_dataprovide.class)
    public void Search(String Keyword) {
    	  WebDriver driver1 = driver.get();
     WebElement E =    driver1.findElement(By.id("sb_form_q"));
     E.sendKeys(Keyword);
     E.sendKeys(Keys.ENTER);
   
        System.out.println("Searchdisplay");
    }

    @AfterMethod
    void done() {
    	  WebDriver driver1 = driver.get();
    	 driver1.quit();
    }
}
