package dataproviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel_demoblaze {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        edgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        edgeDriver.get("https://www.demoblaze.com/");
        driver.set(edgeDriver);
    }

    @Test(
        dataProvider = "excel",
        dataProviderClass = Exceldataprovider1.class
    )
    public void loginTest(String userName, String password) {
        driver.get().findElement(By.id("login2")).click();

        driver.get().findElement(By.id("loginusername")).sendKeys(userName);
        driver.get().findElement(By.id("loginpassword")).sendKeys(password);
        driver.get().findElement(By.xpath("//button[text()='Log in']")).click();

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        String welcomeText = wait
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")))
            .getText();

        Assert.assertTrue(
            welcomeText.contains("Welcome"),
            "Login failed for user: " + userName
        );
    }

    @AfterMethod
    public void afterTest() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}