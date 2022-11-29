package com.training.base;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	WebDriver driver;
	public HashMap<String, By> ObjRep = new HashMap<String, By>();
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	public void addObject(String logicalName, By by) {
		ObjRep.put(logicalName, by);	
	}
	public void enterIntoTextBox(String logicalName, String InputData) {
		WebElement element= getWebElement(logicalName);
		enterIntoTextBox(element,InputData);	
	}
	public void clickCheckBox(String logicalName) {
		WebElement element = getWebElement(logicalName);
		clickCheckBox(element);	
	}
	public void clickonButton(String logicalName) {
		WebElement element = getWebElement(logicalName);
		clickonButton(element);	
	}
	public void validateErrorMessage(String logicalName, String InputData) {
		WebElement element = getWebElement(logicalName);
		validateErrorMessage(element,InputData);
	}
	public void validatePage(String InputData) {
		String expectedTitle=InputData;
//		WebElement element = getWebElement(logicalName);
//		waitforElement(element);
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void clickUserMenuOption(String logicalName) {
		WebElement element = getWebElement(logicalName);
		clickUserMenuOption(element);	
	}

	public void selectUserMenuOption(String logicalName) {
		WebElement element = getWebElement(logicalName);
		selectUserMenuOption(element);
	}

	public void printOptionsInUserMenu(String logicalName) {
		WebElement element = getWebElement(logicalName);
		printOptionsInUserMenu(element);	
	}
	public void validateText(String logicalName, String inputData) {
		WebElement element = getWebElement(logicalName);
		validateText(element,inputData);	
	}
	public void clickOnOption(String logicalName) {
		WebElement element = getWebElement(logicalName);
		clickOnOption(element);		
	}
	public void selectAndCloseWindow(String logicalName) {
		WebElement element = getWebElement(logicalName);
		String parentWindow=driver.getWindowHandle();
		element.click();
		for(String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			String WindowTitle=driver.getTitle();
			System.out.println(WindowTitle);	
			}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String WindowTitle=driver.getTitle();
			System.out.println(WindowTitle);	

			driver.close();
			driver.switchTo().window(parentWindow);	
	}
/*-------------------------------------------------------------*/
	
	private void enterIntoTextBox(WebElement element, String inputData) {
		waitforElement(element);
		element.sendKeys(inputData);	
	}
	private void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	private void actionClass(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();	
	}
	private void clickonButton(WebElement element) {
		waitforElement(element);
		element.click();	
	}
	private void clickCheckBox(WebElement element) {
		waitforElement(element);
		element.click();	
	}
	private WebElement getWebElement(String logicalName) {
		By by = ObjRep.get(logicalName);
		WebElement element = driver.findElement(by);
		return element;
	}
	private void validateErrorMessage(WebElement element, String InputData) {
		String expectedMessage=InputData;
		actionClass(element);
		String actualMessage=element.getText();
		System.out.println("Expected Message is : "+expectedMessage);
		System.out.println("Actual Message is : "+actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	private void clickUserMenuOption(WebElement element) {
		waitforElement(element);
		actionClass(element);
		element.click();
		System.out.println(element.getText());
	}
	private void selectUserMenuOption(WebElement element) {
		actionClass(element);
		element.click();	
	}
    private void printOptionsInUserMenu(WebElement element) {
		System.out.println(element.getText());
	}
	private void validateText(WebElement element, String inputData) {
		String expectedMessage=inputData;
		actionClass(element);
		String actualMessage=element.getText();
		System.out.println("Expected Message is : "+expectedMessage);
		System.out.println("Actual Message is : "+actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);	
	}
	private void clickOnOption(WebElement element) {
		waitforElement(element);
		element.click();	
	}
	
	

	

	

	

}
