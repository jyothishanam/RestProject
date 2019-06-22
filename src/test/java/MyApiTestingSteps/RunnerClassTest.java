package MyApiTestingSteps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"json:target/cucumber-reports/report.json","html:target/cucumber-reports"},
		glue="MyApiTestingSteps",
		features="src/test/resources/FeaturesFile",
		tags= {"@Get"},
		monochrome=true
		)
public class RunnerClassTest {

}
