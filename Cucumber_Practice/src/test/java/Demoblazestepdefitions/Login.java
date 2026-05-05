package Demoblazestepdefitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Login {
	
	@Before
	public void setup() {
		    driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

    public static WebDriver driver;
    WebDriverWait wait;

    @Given("User is in the dashboard page")
    public void user_is_in_dashboard_page() {
       
        driver.get("https://www.demoblaze.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("User clicks on the login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login2")).click();

       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }

   
    @When("the user enters username")
    public void enter_valid_username() {
        driver.findElement(By.id("loginusername")).sendKeys("arasu");
    }

    @And("the user enters password")
    public void enter_valid_password() {
        driver.findElement(By.id("loginpassword")).sendKeys("arasu");
    }

   
    @When("the user enters invalid username")
    public void enter_invalid_username() {
        driver.findElement(By.id("loginusername")).sendKeys("arasu1");
    }

    @And("the user enters invalid password")
    public void enter_invalid_password() {
        driver.findElement(By.id("loginpassword")).sendKeys("arasu2");
    }

    @And("clicks on the Login")
    public void click_login() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("the user should see the Welcome message")
    public void verify_success() {
        String text = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        ).getText();

        Assert.assertTrue(text.contains("Welcome"), "Login failed!");
    }

    @Then("the user should see an error alert")
    public void verify_error() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();

        System.out.println("Alert: " + alertText);
        alert.accept();
    }


    @After
    public void tearDown() {
       
            driver.quit();
        
    }
}
