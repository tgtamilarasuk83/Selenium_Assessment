package tutorial_ninja;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tutorial_ninja {
	
	
	  WebDriver driver;
	  WebDriverWait wait ; 


@Given("The user in the home page")
public void the_user_in_the_home_page() {
	driver = new EdgeDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://tutorialsninja.com/demo/");
}

@When("he clicks on the My account and then Login")
public void he_clicks_on_the_my_account_and_then_login() {
	wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='My Account']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']"))).click()
;
}

@When("he enters email {string} and password {string}")
public void he_enters_email_and_password(String string, String string2) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.name("email"))).sendKeys(string);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.name("password"))).sendKeys(string2);

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@value='Login']"))).click();

}

@Then("check the Account Login Successful")
public void check_the_account_login_successful() {
  driver.close(); 
}

}
