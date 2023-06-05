package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features/Verify_CEO_Name.feature",
	glue = "steps",
	monochrome=true,
	plugin= {"rerun:target/failed_scenarios.txt"} // this plugin is used to rerun the failed scenarios
	
	
	//Note : usually target folder is majorly used for storing failed scenarios, if you want to store in customized folder
//	Example: you are using plugin= {"rerun:failed_scenarios/failed_scenarios.txt"}
//	this will create the folder under project level named failed_scenarios inside failed_scenarios.txt will be created 
//	In Rerunner class in features we need to use @failed_scenarios instead of target if using customized folder
)
public class TestRunner {

}
