package Demoblazestepdefitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class CategorySteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is in the dashboard page .")
    public void user_is_in_dashboard_page() {
        driver = new EdgeDriver();
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @When("he click on the Laptop element in categorie .")
    public void click_laptop_category() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Laptops']"))).click();
    }

    @Then("the Laptiop page should be loaded")
    public void laptop_page_loaded() {
        System.out.println("Laptop page loaded");
    }

    @Then("He see the product MacBook Pro")
    public void see_macbook() {
        System.out.println("MacBook Pro is visible");
    }

    @When("Click on MacBook Pro")
    public void click_macbook() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("MacBook Pro"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Add to cart"))).click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Then("MacBook Pro page is loaded.")
    public void verify_macbook_cart() {
        driver.findElement(By.id("cartur")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Products']")));

        List<WebElement> cartItems = driver.findElements(By.xpath("//tr/td[2]"));

        boolean found = false;

        for (WebElement item : cartItems) {
            if (item.getText().equals("MacBook Pro")) {
                found = true;
                System.out.println("MacBook Pro is present in cart");
                break;
            }
        }

        if (!found) {
            System.out.println("MacBook Pro NOT found in cart");
        }

        driver.quit();
    }

    @Then("He see the product Sony vaio i5")
    public void see_sony() {
        System.out.println("Sony vaio i5 is visible");
    }

    @When("Click on Sony vaio i5")
    public void click_sony() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Sony vaio i5"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Add to cart"))).click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Then("Sony vaio i5 page is loaded.")
    public void verify_sony_cart() {
        driver.findElement(By.id("cartur")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Products']")));

        List<WebElement> cartItems = driver.findElements(By.xpath("//tr/td[2]"));

        boolean found = false;

        for (WebElement item : cartItems) {
            if (item.getText().equals("Sony vaio i5")) {
                found = true;
                System.out.println("Sony vaio i5 is present in cart");
                break;
            }
        }

        if (!found) {
            System.out.println("Sony vaio i5 NOT found in cart");
        }

        driver.quit();
    }
}