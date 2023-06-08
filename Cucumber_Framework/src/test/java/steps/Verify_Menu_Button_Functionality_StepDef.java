package steps;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;

import constants.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TimePage;
import utilities.CommonUtils;

public class Verify_Menu_Button_Functionality_StepDef {

	private static final org.apache.logging.log4j.Logger logger = LogManager
			.getLogger(Verify_Menu_Button_Functionality_StepDef.class);

	@Given("the user is logged in successfully and is on HomePage")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {

		// When you try to create a object for loginPage and get username,password then
		// it will throw NullPointerException
		// Its because we are already initializing with PageFactory.initElements so if
		// we try to create new Object for that class
		// then already the value being stored by initElements method will be assigned
		// to NULL, so it throws NULLPOINTEREXCEPTION.
		// To solve this error we need to implement singleton pattern

		try {
			String url = DriverManager.getDriver().getCurrentUrl();
			if (url.contains("dashboard")) {
				Thread.sleep(2000);
				logger.info("the user is logged in successfully and is on the HomePage");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenshot();
//			Assert.fail(e.getMessage()); // here username is incorrect , since we have used try catch so it will show
											// like successfully executed, so we are using Assert.fail to fail this
											// scenario

		}

	}

	@When("the user clicks on the directory option from the Menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
		try {
			HomePage.getInstance().getDirectory().click();
			logger.info("the user clicks on the directory option from Menu bar");
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}

	@When("the user clicks on the time option from the Menu bar")
	public void the_user_clicks_on_the_time_option_from_the_menu_bar() {
		try {
			Thread.sleep(6000);
			TimePage.getInstance().getTimeButton().click();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}

	}

	@Then("verify user is able to see view button in time page")
	public void verify_user_is_able_to_see_view_button_in_time_page() throws InterruptedException {
		try {
			if (TimePage.getInstance().getViewButton().isDisplayed()) {
				Thread.sleep(6000);
				System.out.println("view button is displayed");
			}
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail();
		}

	}

}
