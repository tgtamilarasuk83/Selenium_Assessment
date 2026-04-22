import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class valiid_dp {
	@DataProvider(name = "demoblaze1", parallel = true)
	public Object[][] dataprovidersdemoblaze() {
	    return new Object[][] { {"arasu", "arasu"}
	    };
	}
}
