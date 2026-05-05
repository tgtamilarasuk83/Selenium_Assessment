package runnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"},
    features = "src/test/resources/featurespac/DemoBlaze_Feature_file/Login.feature",
    glue = "Demoblazestepdefitions"
)
public class TestNg_runner extends AbstractTestNGCucumberTests {

}
