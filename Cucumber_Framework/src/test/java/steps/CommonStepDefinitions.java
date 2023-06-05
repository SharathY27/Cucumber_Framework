package steps;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.DriverManager;
import constants.GlobalVariables;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPage;
import utilities.CommonUtils;

public class CommonStepDefinitions {

	public static String scenarioName = null;

	public static String getScenarioName() {
		return scenarioName;
	}

	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinitions.class);

	// Here we are using Log4j2, repo present in my github is for log4j(or)log4j1
	// Log4j1 is supported only upto java 9 , so its better to use log4j2 but both
	// goals are same (Logging).

	@Before
	public void beforeScenario(Scenario scenario) throws InterruptedException {
		scenarioName = scenario.getName();
		LOGGER.info("Execution started");
		LOGGER.info("Instantiating commonUtils");
		LOGGER.info("Loading properties file");
		CommonUtils.getInstance().loadProperties();
		LOGGER.info("Checking the driver is NULL or NOT?");
		if (DriverManager.getDriver() == null) {
			LOGGER.info("Driver is NULL, Instantiated!");
			DriverManager.launchBrowser();
			CommonUtils.initElements();
			login();
		}
	}

	public void login() throws InterruptedException {
		try {
			DriverManager.getDriver().get(GlobalVariables.APP_URL);
			Thread.sleep(6000);
			CommonUtils.getInstance().highlightingElement(LoginPage.getInstance().getUsername());
			Thread.sleep(2000);
			CommonUtils.getInstance().takeScreenshot();
			LoginPage.getInstance().getUsername().sendKeys(GlobalVariables.USERNAME);
			LoginPage.getInstance().getPassword().sendKeys(GlobalVariables.PASSWORD);
			LoginPage.getInstance().getLogin_Button().click();
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
			System.out.println("I am waiting");
			wait.until(ExpectedConditions.elementToBeClickable(LoginPage.getInstance().getUsername()));
		}
	}

	@After
	public void afterScenario() {
		DriverManager.getDriver().quit();
	}

}
