package constants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;

	}

	public static void launchBrowser() {
		switch (GlobalVariables.BROWSER.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().browserVersion("121.0.6167.185").setup(); // System.setProperty("webdriver,chrome.driver",
																						// "##driver location here##");
																						// //Another way of implementing
																						// driver
			LOGGER.info("Launching " + GlobalVariables.BROWSER);
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			// System.setProperty("webdriver,edge.driver", "##driver location here##");
			// //Another way of implementing driver
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
