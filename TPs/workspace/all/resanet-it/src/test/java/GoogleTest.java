
import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class GoogleTest extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://www.google.fr/", "*safari");
	}
	public void testNew() throws Exception {

		selenium.open("/");
		selenium.type("q", "zenika");
		selenium.click("btnG");
		selenium.click("//ol[@id='rso']/li[1]/h3/a/em");
/*
		selenium.open("/firefox?client=firefox-a&rls=org.mozilla:fr:official");
		selenium.type("sf", "zenika");
		selenium.click("btnG");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Zenika : Architecture Informatique");
		selenium.waitForPageToLoad("30000");
		selenium.click("//img[@alt='Blog Zenika']");
		selenium.waitForPageToLoad("30000");
*/
/*
		selenium.open("/");
		selenium.type("q", "zenika");
		selenium.click("btnG");
		selenium.waitForPageToLoad("30000");
*/
	}
}
