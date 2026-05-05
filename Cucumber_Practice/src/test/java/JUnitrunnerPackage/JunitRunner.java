package JUnitrunnerPackage;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = "src/test/resources/featurespac/DemoBlaze_Feature_file/Login.feature",
    glue = "Demoblazestepdefitions"
    //tags = "@Tamil or @VL"
    //tags = "@Tamil and  @VL"
    //tags = ("@Tamil"  "@InvalidLogin")


)
public class JunitRunner {
}
