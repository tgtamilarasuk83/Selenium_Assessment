package demoblaze_listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(DemoListener1.class)
public class Logging_demoblaze {

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
    }

    @Test()
    @Parameters({"val1", "val2"})
    public void loginTest(String username, String password) {

        driver.findElement(By.id("login2")).click();

        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        ).getText();

        Assert.assertTrue(text.contains("Welcome " + username));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
