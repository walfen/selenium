package com.walfen.page;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * This test checks the correct behaviour of the index page.
 * @author Miguel Angel Ruiz Martinez - walfen.com
 *
 */
@RunWith(value = Parameterized.class)
public class IndexPageTest {

	/**
	 * The driver used during the test.
	 */
	private WebDriver driver;

	/**
	 * The name of the driver used during the test.
	 */
	private String driverName;

	/**
	 * The url of the web application.
	 */
	private static final String URL = "http://walfen.com";

	/**
	 * Creates an index page test. It receives two parameters from the @Parameterized.Parameters method.
	 * @param driver - the driver
	 * @param driverName - the driver name
	 */
	public IndexPageTest(WebDriver driver, String driverName) {
		this.driver = driver;
		this.driverName = driverName;
	}

	/**
	 * Returns the list of web drivers used for the test.
	 * @return the list of web drivers and their names
	 */
	@Parameterized.Parameters(name = "{1}")
	public static List<Object[]> listWebDrivers() {
		List<Object[]> webDrivers = new ArrayList<Object[]>();

		// html
		webDrivers.add(new Object[] { new HtmlUnitDriver(true), "HtmlUnit" });

		// firefox
		webDrivers.add(new Object[] { new FirefoxDriver(), "Firefox" });

		// chrome
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		webDrivers.add(new Object[] { new ChromeDriver(), "Chrome" });

		return webDrivers;
	}

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		// define source text
		String sourceText = "Hello World!";

		// open index page, fill input text, click button and read text
		IndexPage indexPage = new IndexPage(driver, URL);

		// allow user to see execution (to be removed in real tests)
		Thread.sleep(1000);

		indexPage.fillInputText(sourceText);
		indexPage.clickButton();
		String resultText = indexPage.getText();

		// allow user to see execution (to be removed in real tests)
		Thread.sleep(1000);

		// check if source text is equals to result text
		assertEquals(sourceText, resultText);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
