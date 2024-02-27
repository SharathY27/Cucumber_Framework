package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/resources/features/Verify_Menu_Button_Functionality.feature"},
	glue = "steps",
	monochrome=true,
	//This publish is used to generate Cucumber web report , it will generate report link in console (it is simple report) 
	publish=true,
	//This plugin used for Extent Report
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

	)*/

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"src\\test\\resources\\features\\Get_Data_From_Dynamic_Table.feature" }, glue = "steps", monochrome = true)

/*
 * //This is for reporting using cucumber and rerun plugin is used for storing
 * failed scenarios in text file and we will rerun using rerunner class plugin=
 * {"rerun:target/failed_scenarios.txt", // this plugin is used to rerun the
 * failed scenarios // "pretty", // this will simply print in console "usage",
 * // used for duration of execution "html:target/cucumber-reports/report.html",
 * //html report generaion "json:target/cucumber-reports/report.json", //json
 * report generaion "junit:target/cucumber-reports/report.xml" //xml report
 * generaion }
 */

/*
 * Note : usually target folder is majorly used for storing failed scenarios, if
 * you want to store in customized folder Example: you are using plugin=
 * {"rerun:failed_scenarios/failed_scenarios.txt"} this will create the folder
 * under project level named failed_scenarios inside failed_scenarios.txt will
 * be created In Rerunner class in features we need to use @failed_scenarios
 * instead of target if using customized folder
 */

public class TestRunner {

}
