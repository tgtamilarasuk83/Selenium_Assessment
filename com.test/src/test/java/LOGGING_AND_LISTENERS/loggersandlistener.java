package LOGGING_AND_LISTENERS;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Logging.Logging_demoblaze;

public class loggersandlistener implements ITestListener {

    Logger log = LogManager.getLogger(loggersandlistener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.error("Test FAILED: " + result.getName());

        // 🔥 Screenshot logic
        Object obj = result.getInstance();
        Logging_demoblaze test = (Logging_demoblaze) obj;

        TakesScreenshot ts = (TakesScreenshot) test.driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String time = LocalDateTime.now().toString().replace(":", "-");

        File dest = new File("screenshots/" + result.getName() + "_" + time + ".png");

        try {
            FileUtils.copyFile(src, dest);
            log.error("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            log.error("Screenshot failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test SKIPPED: " + result.getName());
    }
}

