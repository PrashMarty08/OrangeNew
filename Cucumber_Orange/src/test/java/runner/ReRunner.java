package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="@FailedScenarios/failedScenrios.txt",glue={"stepDefinitions","hooks"},monochrome=true)

public class ReRunner {
	
}
