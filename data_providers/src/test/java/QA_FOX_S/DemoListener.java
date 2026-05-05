package QA_FOX_S;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import QA_FOX_S.DemoListener;
public class DemoListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(DemoListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {

        Object currentClass = result.getInstance();
        WebDriver driver = ((Login) currentClass).drivers();

        String method = result.getMethod().getMethodName();

        try {
            if (method.equals("Login")) {
                captureElement(driver,
                        By.xpath("//h2[normalize-space()='My Account']"),
                        "valid_login");
                log.info("Valid login screenshot captured");
            }

            if (method.equals("Login2")) {
                captureElement(driver,
                        By.xpath("//div[contains(@class,'alert-danger')]"),
                        "invalid_login");
                log.info("Invalid login screenshot captured");
            }

        } catch (Exception e) {
            log.error("Error in success screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Object currentClass = result.getInstance();
        WebDriver driver = ((Login) currentClass).drivers();

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/" +
                    result.getMethod().getMethodName() + "_failure.png");

            dest.getParentFile().mkdirs();

            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            log.error("Failure screenshot captured");

        } catch (Exception e) {
            log.error("Error capturing failure screenshot: " + e.getMessage());
        }
    }

     //Element Screenshot
    private void captureElement(WebDriver driver, By locator, String name)
            throws IOException {

        WebElement element = driver.findElement(locator);

        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + name + ".png");

        dest .getParentFile().mkdirs();
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
