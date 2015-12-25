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
	 * The web driver.
	 */
	private WebDriver driver;

	@FindBy(xpath="//*[@id='hello-input']")
	private WebElement helloInput;
	
	@FindBy(xpath="//*[@id='hello-button']")
	private WebElement helloButton;
	
	@FindBy(xpath="//*[@id='hello-text']")
	private WebElement helloText;
	
	/**
	 * Creates an index page.
	 * @param driver - the driver
	 */
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Fills the hello input text.
	 * @param text - the text
	 */
	public void fillHelloInput(String text) {
		helloInput.sendKeys(text);
	}
	
	/**
	 * Clicks the hello button.
	 */
	public void clickHelloButton() {
		helloButton.click();
	}
	
	/**
	 * Returns the hello text.
	 * @return the hello text
	 */
	public String readHelloText() {
		return helloText.getText();
	}
	
}
