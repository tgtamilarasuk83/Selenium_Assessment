import org.testng.annotations.DataProvider;

public class Class_dataprovide {
	@DataProvider(name = "testdata" , parallel = true )
    public Object[][] dataproviders() {
        return new Object[][] { {"Selenium"},{"TestNG"}, {"Automation"}};
    }
}
