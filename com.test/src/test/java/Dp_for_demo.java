import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dp_for_demo {
	
	@DataProvider(name = "demoblaze", parallel = true)
	public Object[][] dataprovidersdemoblaze() {
	    return new Object[][] { {"arasu1", "arasu"},{"arasu", "arasu1"}
	    };
	}


}

