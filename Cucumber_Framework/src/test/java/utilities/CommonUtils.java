package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import constants.DriverManager;
import constants.GlobalVariables;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import steps.CommonStepDefinitions;

public class CommonUtils {

	private static CommonUtils instance;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {
		if (instance == null) {
			instance = new CommonUtils();
		}
		return instance;
	}

	public void loadProperties() {

		// This is one way of loading properties file
		// This is for reading properties file at project level

		/*
		 * FileReader reader = null; try { reader = new FileReader("config.properties");
		 * } catch (FileNotFoundException e) { e.printStackTrace(); }
		 * 
		 * Properties properties = new Properties(); try { properties.load(reader); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */

		// This is another way of loading properties file
		// This is for reading properties file from src/resources folder
		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		GlobalVariables.APP_URL = properties.getProperty("APP_URL");
		GlobalVariables.BROWSER = properties.getProperty("BROWSER");
		GlobalVariables.USERNAME = properties.getProperty("USERNAME");
		GlobalVariables.PASSWORD = properties.getProperty("PASSWORD");
	}

	public static void initElements() {
		// This method is to initialize page objects in LoginPage class with driver
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
	}

	public void takeScreenshot() {
		// this will take screenshot
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		// this will copy the screenshot in specified location
		try {
			FileUtils.copyFile(screenshot, new File(CommonStepDefinitions.getScenarioName()+".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//This method is to initialize page objects in LoginPage class with driver
//		PageFactory.initElements(DriverManager.getDriver(), LoginPage.class);
//		PageFactory.initElements(DriverManager.getDriver(), HomePage.class);
		
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
	}

}
