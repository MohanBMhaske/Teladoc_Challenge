package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features="E:\\Selenium4 Practice\\Teladoc_Challenge\\src\\test\\java\\FeatureFile\\webtables.feature",
	    glue= {"StepDefinition"},
	    monochrome=true
	    )
public class TestRunner {

}
