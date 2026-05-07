package RunnerClass_demoblaze;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"},
    features = "src/test/resources/Scenariodata_demoblaze/login1.feature",
    glue = "Scenariodata_Demoblaze"   
)
public class TestNg_runner extends AbstractTestNGCucumberTests {
}