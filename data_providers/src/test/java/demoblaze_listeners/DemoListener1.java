package demoblaze_listeners;



import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DemoListener1 implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {

    	WebDriverWait wait = new WebDriverWait(Logging_demoblaze.driver, Duration.ofSeconds(10));

    	WebElement element = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']"))
    	);

        File src = element.getScreenshotAs(OutputType.FILE);

        File dest = new File("screenshots/" + result.getName() + ".png");

        src.renameTo(dest);   // no checked exception → no try-catch needed

        System.out.println("Screenshot captured for PASSED test: " + result.getName());
    }
}

