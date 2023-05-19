package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.GlobalVariables;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CommonUtils;

public class CommonStepDefinitions {

	public static WebDriver driver;

	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinitions.class);

	// Here we are using Log4j2, repo present in my github is for log4j(or)log4j1
	// Log4j1 is supported only upto java 9 , so its better to use log4j2 but both
	// goals are same (Logging).

	@Before
	public void beforeScenario() {
		LOGGER.info("Execution started");
		LOGGER.info("Instantiating commonUtils");
		CommonUtils commonUtils = new CommonUtils();
		LOGGER.info("Loading properties file");
		commonUtils.loadProperties();
		LOGGER.info("Checking the driver is NULL or NOT?");
		if (driver == null) {
			LOGGER.info("Driver is NULL, Instantiated!");
			launchBrowser();
		}
	}

	public void launchBrowser() {
		switch (GlobalVariables.BROWSER.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver,chrome.driver", "##driver location here##"); //Another way of implementing driver 
			LOGGER.info("Launching " + GlobalVariables.BROWSER);
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			LOGGER.info("Launching " + GlobalVariables.BROWSER);
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			LOGGER.info("Launching " + GlobalVariables.BROWSER);
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			LOGGER.info("Launching " + GlobalVariables.BROWSER);
			driver = new ChromeDriver();
		}
	}

}
