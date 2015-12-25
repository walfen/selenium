package com.walfen.page;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndexPageTest {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testHello() {
		// access to web page
		driver.get("http://walfen.com/selenium-test");
		
		// define source text
		String sourceText = "Hello World!";
		
		// fill input text, click button and read text
		IndexPage indexPage = new IndexPage(driver);
		indexPage.fillHelloInput(sourceText);
		indexPage.clickHelloButton();
		String resultText = indexPage.readHelloText();
		
		// check if source text is equals to result text
		assertEquals(sourceText, resultText);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
