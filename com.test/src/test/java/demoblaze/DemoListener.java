package demoblaze;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class DemoListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(DemoListener.class);

    public void onTestStart(ITestResult result) {
        log.info(result.getName() + " started");
    }
    public void onTestSuccess(ITestResult result) {
        log.info(result.getName() + " passed");
    }

    public void onTestFailure(ITestResult result) {

        log.error(result.getName() + " failed");

        Logging_demoblaze test = (Logging_demoblaze) result.getInstance();

        try {
            WebElement element = test.driver.findElement(By.id("nameofuser"));

            File src = element.getScreenshotAs(OutputType.FILE);

            FileHandler.copy(
                src,
                new File("test-output/screenshots/" + result.getName() + ".png")
            );

            log.info("Screenshot captured");

        } catch (Exception e) {
            log.error("Screenshot failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn(result.getName() + " skipped");
    }
}
