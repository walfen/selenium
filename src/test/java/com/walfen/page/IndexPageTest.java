package com.walfen.page;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndexPageTest {

	private WebDriver driver;
	
	private String url;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		url = "http://walfen.com";
	}
	
	@Test
	public void test() {
		// define source text
		String sourceText = "Hello World!";
		
		// open index page, fill input text, click button and read text
		IndexPage indexPage = new IndexPage(driver, url);
		indexPage.fillInputText(sourceText);
		indexPage.clickButton();
		String resultText = indexPage.getText();
		
		// check if source text is equals to result text
		assertEquals(sourceText, resultText);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
