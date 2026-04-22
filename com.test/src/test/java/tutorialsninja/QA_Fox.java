package tutorialsninja;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class QA_Fox {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test(
        dataProvider = "excel_qafox",
        dataProviderClass = dataproviderforQAFpx.class
    )
    public void f(String name, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='My Account']"))).click();wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.name("email"))).sendKeys(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.name("password"))).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@value='Login']"))).click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
