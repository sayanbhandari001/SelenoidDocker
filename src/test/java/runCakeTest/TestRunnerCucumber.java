package runCakeTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "html:cucumber-reports/htmlreprt.html", "json:cucumber-reports/report.json" },
		features = {"src/test/java/features"},
		glue = { "stepDefenitions"},
		publish = true,
		monochrome=true,
		dryRun=false,
		tags = ("@naukriIndiaUpdate or @naukriInternationalUpdate")
		)
 
public class TestRunnerCucumber {
	
}
//tags = ("@naukriIndiaUpdate or @naukriInternationalUpdate")
//tags = ("@naukriInternationalUpdate")

///update password before running in feature file