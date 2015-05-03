
import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class HelloTest extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://localhost:8091/zenika/", "*firefox");
	}
	public void ftestZenika() throws Exception {

		selenium.open( "http://localhost:8091/zenika/index.jsp" );
		selenium.waitForPageToLoad( "30000" );
		verifyTrue(selenium.isTextPresent("Hello World!"));		
	}
}
