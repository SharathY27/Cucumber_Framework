package steps;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;

import constants.DriverManager;
import constants.GlobalVariables;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.CommonUtils;

public class Verify_CEO_Name_StepDef {

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Verify_CEO_Name_StepDef.class);

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
			DriverManager.getDriver().get(GlobalVariables.APP_URL);
			Thread.sleep(6000);
			CommonUtils.getInstance().highlightingElement(LoginPage.getInstance().getUsername());
			Thread.sleep(2000);
			CommonUtils.getInstance().takeScreenshot();
			LoginPage.getInstance().getUsername().sendKeys(GlobalVariables.USERNAME);
			LoginPage.getInstance().getPassword().sendKeys(GlobalVariables.PASSWORD);
			LoginPage.getInstance().getLogin_Button().click();

			String url = DriverManager.getDriver().getCurrentUrl();
			if (url.contains("dashboard")) {
				Thread.sleep(2000);
				logger.info("the user is logged in successfully and is on the HomePage");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage()); // here username is incorrect , since we have used try catch so it will show like successfully executed, so we are using Assert.fail to fail this scenario
			
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

	@When("the user selects the job title as {string} from the dropdown")
	public void the_user_selects_the_job_title_as_from_the_dropdown(String string) {
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
		System.out.println("clicks search button");
	}

	@Then("the user should see the CEO name")
	public void the_user_should_see_the_ceo_name() {
		System.out.println("the user should see CEO name");
	}

}
