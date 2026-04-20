package assessment;




import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class newOGcode {
	public static void main(String args[]) {
		System.out.println("hello");
		 
		WebDriver driver=new EdgeDriver();
		
		
		// Launch the browser using Selenium WebDriver. 
		driver.get("https://demoblaze.com/");
		
		
		
		
		//explicit wait FOR LOGIN 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement login = wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='login2']")));
		login.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']"))).sendKeys("arasu");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='loginpassword'])[1]"))).sendKeys("arasu");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Log in']"))).click();
						
		
			
		
		//Validation
		 WebElement Element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Welcome arasu')]")));
	    String Element2 ="Welcome arasu";
	   if(Element.equals(Element2)) {	
		System.out.println("\"Login Successful");
		}	
	   
	   
		
		
		
	
		
		//LAPTOP PAGE

       WebElement laptop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Laptops']")));   
       laptop.click();
		
		        
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		
		 list =  (ArrayList<WebElement>) driver.findElements(By.xpath("//a[@class=\"hrefch\"]"));
		 
		 ArrayList<String> list1 = new ArrayList<String>();
		 
		 for(WebElement E : list) {
			 list1.add(E.getText());
		 }
		
		 Collections.sort(list1);
		 
		
		for(String X : list1) {
			System.out.println("Found Laptop:"+X);
		}
		 
			
	
		//Add Product to Cart
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='MacBook Pro']"))).click();

		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg']"))).click();
		 
		 
		//alert
		 wait.until(ExpectedConditions.alertIsPresent());
		 driver.switchTo().alert().accept();
		 System.out.println("Alert handled successfully.");
		 System.out.println("Product added to cart");
		 
		 
		 //Question 4: Place Order (5 Marks)
		 
		 
		 driver.findElement(By.id("cartur")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Products']")));

		 driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		
		 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

		 driver.findElement(By.id("name")).sendKeys("John Doe");
		 driver.findElement(By.id("country")).sendKeys("India");
		 driver.findElement(By.id("city")).sendKeys("Bangalore");
		 driver.findElement(By.id("card")).sendKeys("1234567812345678");
		 driver.findElement(By.id("month")).sendKeys("04");
		 driver.findElement(By.id("year")).sendKeys("2026");

		 driver.findElement(By.xpath("//button[normalize-space()='Purchase']")).click();

		 WebElement confirmation = wait2.until(
		         ExpectedConditions.visibilityOfElementLocated(
		                 By.xpath("//div[contains(@class,'sweet-alert')]"))
		 );

		 String purchaseText = confirmation.getText();

		 if (purchaseText.contains("Id")) {
			    System.out.println("Order is placed successfully");
			    System.out.println(purchaseText);
			} else {
			    System.out.println("Order is NOT placed successfully");
			}

		 
		
		// OK button (confirm purchase)
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'OK']"))).click();
		


		
		 
	}

}

