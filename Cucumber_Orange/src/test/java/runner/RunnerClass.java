package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/dashboard.feature",
	glue={"stepDefinitions","hooks"},
	monochrome=true,
	plugin = {"rerun:FailedScenarios/failedScenrios.txt",
			"pretty",
			"usage:UsageReports/usage.txt",
			"html:HTMLReports/report.html",
			"json:JSONReports/report.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	publish=true,
	dryRun=false)


public class RunnerClass {

}
