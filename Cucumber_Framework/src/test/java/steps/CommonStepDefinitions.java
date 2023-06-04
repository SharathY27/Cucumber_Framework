package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CommonUtils;

public class CommonStepDefinitions {
	
	public static String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
	}
	
	

	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinitions.class);

	// Here we are using Log4j2, repo present in my github is for log4j(or)log4j1
	// Log4j1 is supported only upto java 9 , so its better to use log4j2 but both
	// goals are same (Logging).

	@Before
	public void beforeScenario(Scenario scenario) {
		scenarioName=scenario.getName();
		LOGGER.info("Execution started");
		LOGGER.info("Instantiating commonUtils");
		LOGGER.info("Loading properties file");
		CommonUtils.getInstance().loadProperties();
		LOGGER.info("Checking the driver is NULL or NOT?");
		if (DriverManager.getDriver() == null) {
			LOGGER.info("Driver is NULL, Instantiated!");
			DriverManager.launchBrowser();
			CommonUtils.initElements();
		}
	}

	@After
	public void afterScenario() {
		DriverManager.getDriver().quit();	
	}

}
