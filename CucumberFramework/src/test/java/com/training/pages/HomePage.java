package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;
import com.training.base.BaseTest;

public class HomePage extends BasePage{
	
	static WebDriver driver;
	
	public HomePage() {
		super(driver=BaseTest.getDriver());
	//Method which accepts String , By byobj 
	addObject("userMenu", By.id("userNavLabel"));
	addObject("Logout", By.xpath("//a[@href='/secur/logout.jsp']")); 
	addObject("UserMenuList", By.xpath("//div[@id='userNav-menuItems']"));
	addObject("Username", By.id("idcard-identity"));
	addObject("DeveloperConsole", By.xpath("//a[contains(text(),'Developer Console')]")); 
}
}
