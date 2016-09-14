package priv.practices.selenium1;



import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

/**
 * @author http://www.cnblogs.com/tuan/archive/2012/09/03/2669171.html
 * 
 */

/*1. 启动selenium server
java -jar selenium-server-standalone-2.25.0.jar

2. 在Eclipse 里面，右键 run as Junit test*/

public class SeleniumRC extends SeleneseTestCase {
	@SuppressWarnings("deprecation")
	private Selenium selenium;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "https://www.baidu.com/");
		selenium.start();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFC0000_JUnit4() throws Exception {
		selenium.open("/");
		selenium.click("id=kw");
		selenium.type("id=kw", "selenium");
		selenium.click("id=su");
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
