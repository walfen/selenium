package com.walfen.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the index page.
 * @author Miguel Angel Ruiz Martinez - walfen.com
 *
 */
public class IndexPage {
	
	/**
	 * The path of the index page.
	 */
	private static final String PATH = "/selenium-test";

	/**
	 * The input text element.
	 */
	@FindBy(xpath="//*[@id='test-input']")
	private WebElement inputText;
	
	/**
	 * The button element.
	 */
	@FindBy(xpath="//*[@id='test-button']")
	private WebElement button;
	
	/**
	 * The text element.
	 */
	@FindBy(xpath="//*[@id='test-text']")
	private WebElement text;
	
	/**
	 * Creates an index page.
	 * @param driver - the driver
	 * @param url 
	 */
	public IndexPage(WebDriver driver, String url) {
		driver.get(url + PATH);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Fills the input text.
	 * @param text - the text
	 */
	public void fillInputText(String text) {
		inputText.sendKeys(text);
	}
	
	/**
	 * Clicks the hello button.
	 */
	public void clickButton() {
		button.click();
	}
	
	/**
	 * Returns the text.
	 * @return the text
	 */
	public String getText() {
		return text.getText();
	}
	
}
