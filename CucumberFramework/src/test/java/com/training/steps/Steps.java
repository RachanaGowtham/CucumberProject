package com.training.steps;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pageFactory.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class Steps extends BaseTest{
	
	
	PageFactory pageFactory = new PageFactory();
	BasePage page;
	
	@Before
	public void setup() throws IOException {
		launchapplication();
	}
	
	
	@Given("User is on {string}")
	public void user_is_on(String pageName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		page=pageFactory.initialize(pageName);
	}
	@When("User enter into text box {string} {string}")
	public void user_enter_into_text_box(String logicalName, String InputData) {
		page.enterIntoTextBox(logicalName,InputData);
	}
	@Then("User Clicks on CheckBox {string}")
	public void user_clicks_on_check_box(String logicalName) {
	   page.clickCheckBox(logicalName);
	}
	@Then("User Clicks on Button {string}")
	public void user_clicks_on_button(String logicalName) {
	   page.clickonButton(logicalName);
	}
	@Then("Validate error message {string} {string}")
	public void validate_error_message(String logicalName, String InputData) {
	    page.validateErrorMessage(logicalName,InputData);
	}
	@Then("Validate the new page {string}")
	public void validate_the_new_page(String InputData) {
		 page.validatePage(InputData);
	}
	@Then("Click on UserMenu option {string}")
	public void click_on_user_menu_option(String logicalName) {
	   page.clickUserMenuOption(logicalName);
	}
	@Then("Print the Options in the UserMenu List {string}")
	public void print_the_options_in_the_user_menu_list(String logicalName) {
	   page.printOptionsInUserMenu(logicalName);
	}
	@Then("Select the required Option from UserMenu {string}")
	public void select_the_required_option_from_user_menu(String logicalName) {
	   page.selectUserMenuOption(logicalName);
	}
	@Then("Validate text {string} {string}")
	public void validate_text(String logicalName, String InputData) {
	  page.validateText(logicalName,InputData);
	}
	@Then("User Clicks on Option {string}")
	public void user_clicks_on_option(String logicalName) {
	    page.clickOnOption(logicalName);
	}
	@Then("Select the required Option and close Window {string}")
	public void select_the_required_option_and_close_window(String logicalName) {
	    page.selectAndCloseWindow(logicalName);
	}
	@After
	public void teardown(Scenario scenario) {
		 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		   // embed it in the report.
		      scenario.attach(screenshot, "image/png",scenario.getName()); 
			driver.close();
		driver = null;
	}
	
}
