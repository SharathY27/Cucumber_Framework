package steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.DriverManager;
import constants.GlobalVariables;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import pageObjects.LoginPage;
import utilities.CommonUtils;

public class CommonStepDefinitions {
	
	Scenario scenario;

	public static String scenarioName = null;

	public static String getScenarioName() {
		return scenarioName;
	}

	private static final Logger LOGGER = LogManager.getLogger(CommonStepDefinitions.class);

	// Here we are using Log4j2, repo present in my github is for log4j(or)log4j1
	// Log4j1 is supported only upto java 9 , so its better to use log4j2 but both
	// goals are same (Logging).
	
	@BeforeStep
	public void getScenario(Scenario scenario) {
		this.scenario = scenario;
	}

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
			
//			login();
		}
	}
	

	public void login() throws InterruptedException {
		try {
			DriverManager.getDriver().get(GlobalVariables.APP_URL);
			DriverManager.getDriver().manage().window().maximize();
			Thread.sleep(6000);
			LoginPage.getInstance().getUsername().sendKeys(GlobalVariables.USERNAME);
			LoginPage.getInstance().getPassword().sendKeys(GlobalVariables.PASSWORD);
			LoginPage.getInstance().getLogin_Button().click();

		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(LoginPage.getInstance().getUsername()));
		}
	}
	
	public void takeScreenshot() {
		byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotTaken, "image/png", scenarioName);
	}
	
	public void takeScreenshotAsFile() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			Thread.sleep(3000);
			FileUtils.copyFile(screenshot, new File("Screenshots/image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// IF you are using extent report no need of explicitly calling screenshot
	// utility for failed/passed scenarios, instead use this
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, "image/png", scenarioName);
		}
	}

	@After
	public void afterScenario() {
		takeScreenshotAsFile();
		DriverManager.getDriver().quit();
	}

}
