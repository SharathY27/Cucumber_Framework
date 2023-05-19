package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import constants.GlobalVariables;

public class CommonUtils {

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
		// This is for reading properties file from resource folder
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

}
