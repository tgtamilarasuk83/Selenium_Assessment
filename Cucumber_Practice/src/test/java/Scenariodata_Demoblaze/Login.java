package Scenariodata_Demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Alert;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.junit.Assert;

public class Login {

    WebDriver driver;

    @Given("user is on Homepage")
    public void user_is_on_homepage() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com");

        // Open login popup
        driver.findElement(By.id("login2")).click();
    }

    @When("user enter username as {string} and password as {string}")
    public void user_enter_username_as_and_password_as(String username, String password) {
        driver.findElement(By.id("loginusername")).clear();
        driver.findElement(By.id("loginpassword")).clear();

        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }

    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("the error message seen as {string}")
    public void the_error_message_seen_as(String expectedAlert) throws InterruptedException {

        Thread.sleep(2000); // wait for alert

        Alert alert = driver.switchTo().alert();
        String actualAlert = alert.getText();

        System.out.println("Alert message: " + actualAlert);

        Assert.assertEquals(expectedAlert, actualAlert);

        alert.accept();
        driver.quit();
    }
}