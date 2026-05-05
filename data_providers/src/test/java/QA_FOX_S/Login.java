package QA_FOX_S;


import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import utils.ValidandInvaliddataProvider;
@Listeners(QA_FOX_S.DemoListener.class)
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

    @Test(dataProvider = "validData",
          dataProviderClass = ValidandInvaliddataProvider.class,
          priority = 0)
    public void Login(String name, String Password) {

        WebDriverWait wait = new WebDriverWait(drivers(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
        log.info("Navigation to dropdown");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(name);
        log.info("Entering username: " + name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(Password);
        log.info("Entering password");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']"))).click();
        log.info("Click login");

        String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[normalize-space()='My Account']")
                )
        ).getText();

        Assert.assertTrue(text.contains("My Account"));
        log.info("Valid login successful");
    }

    @Test(dataProvider = "invalidData",
          dataProviderClass = ValidandInvaliddataProvider.class,
          priority = 1)
    public void Login2(String name, String Password) {

        WebDriverWait wait = new WebDriverWait(drivers(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
        log.info("Navigation to dropdown");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(name);
        log.info("Entering invalid username: " + name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(Password);
        log.info("Entering invalid password");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']"))).click();
        log.info("Click login");

        String error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'alert-danger')]")
                )
        ).getText();

        Assert.assertTrue(error.contains("Warning"));
        log.info("Invalid login error validated");
    }

    @AfterMethod
    public void Reset() {
        drivers().quit();
        log.info("Driver closed");
    }
}
