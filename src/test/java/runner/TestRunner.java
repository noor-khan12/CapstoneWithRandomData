package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReportingConfig;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\src\\test\\resources\\features", 
		// where the feature files are 
		glue = "classpath:stepDefinitions",
		//where step definitions is 
		tags = "@capstoneProject", 
		// the job of tags we will run one scenario or multiple scenarios or 
		//entire feature 
		dryRun = false, 
		// dryRun checks if there are any missing steps in stepDefinitions class
		// for each scenario steps in feature file 
		monochrome = true, 
		//will make console readable 
		strict = true, 
		// strict will mark scenario as failed if there are any pending steps 
		plugin = {"pretty", 
				"html:target/site/cucumber-pretty", 
				"json:target/cucumber.json"},
		publish = true 
		
		)
public class TestRunner {
	
	/*
	 * this method will invoke cucumber reporting once the execution is over 
	 */
	/*
	 * @AfterClass is from Junit and will run after (AfterHooks) 
	 */
	@AfterClass
	public static void generateReport() {
		CucumberReportingConfig.reportConfig();
	}

}
