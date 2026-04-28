package demoblaze;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import dataproviders.Exceldataprovider1;

@Listeners(demoblaze.DemoListener.class)
public class Logging_demoblaze {

    public WebDriver driver;
    public Logger log = LogManager.getLogger(Logging_demoblaze.class);

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        log.info("Browser launched");
    }

    @Test(dataProvider = "excel", dataProviderClass = Exceldataprovider1.class)
    public void loginTest(String username, String password) {

        driver.findElement(By.id("login2")).click();

        log.info("Entering username: " + username);
        driver.findElement(By.id("loginusername")).sendKeys(username);

        log.info("Entering password");
        driver.findElement(By.id("loginpassword")).sendKeys(password);

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String text = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        ).getText();

        log.info("Login text: " + text);

        Assert.assertTrue(text.contains("Welcome " + username));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("Browser closed");
    }
}
