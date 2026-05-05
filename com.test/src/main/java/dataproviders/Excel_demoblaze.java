package dataproviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel_demoblaze {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setup() {

        System.out.println("Launching browser... Thread: " + Thread.currentThread().getId());

        WebDriverManager.edgedriver().setup();

        // ✅ FIX: Options must be passed INTO driver
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        WebDriver edge = new EdgeDriver(options);   // ✅ FIXED LINE

        edge.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        edge.get("https://www.demoblaze.com/");

        driver.set(edge);

        System.out.println("Browser launched successfully");
    }

    @Test(dataProvider = "excel", dataProviderClass = Exceldataprovider1.class)
    public void loginTest(String userName, String password) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
                .sendKeys(userName);

        getDriver().findElement(By.id("loginpassword")).sendKeys(password);

        getDriver().findElement(By.xpath("//button[text()='Log in']")).click();

        String welcomeText = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")))
                .getText();

        Assert.assertTrue(welcomeText.contains("Welcome"),
                "Login failed for user: " + userName);
    }

    @AfterMethod
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();   // ✅ IMPORTANT for parallel
        }
    }
}
