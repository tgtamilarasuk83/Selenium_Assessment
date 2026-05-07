package data_table_demoblaze;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
		
public class data_table {
	
	 WebDriver driver;
	
	

	@Given("user is on Homepages")
	public void user_is_on_homepages() {
		    driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://www.demoblaze.com");

	       
	        driver.findElement(By.id("login2")).click();
	}

	@When("user enter username as {string} and passwords as {string}")
	public void user_enter_username_as_and_passwords_as(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		  List<List<String>> Sign = dataTable.asLists(String.class); 
		  
		  List<List<String>> sign = dataTable.asLists(String.class);
		  for (List<String> row : sign) {

		        String name = row.get(0);
		        String password = row.get(1);

		        
		        driver.findElement(By.id("loginusername")).clear();
		        driver.findElement(By.id("loginpassword")).clear();

		       
		        driver.findElement(By.id("loginusername")).sendKeys(name);
		        driver.findElement(By.id("loginpassword")).sendKeys(password);

		      
		        driver.findElement(By.xpath("//button[text()='Log in']")).click();
		  }
		
	}

	@When("Users clicks on the login button")
	public void users_clicks_on_the_login_button() {
		   driver.findElement(By.xpath("//button[text()='Log in']")).click();
		   driver.quit();
	}

}
