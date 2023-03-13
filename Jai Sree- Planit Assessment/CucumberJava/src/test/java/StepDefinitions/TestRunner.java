package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/PlanitTesting.feature",glue={"StepDefinitions"},
monochrome = true,
plugin = {"pretty", "junit:target/JUnitReports/report.XML", "json:target/JSONReports/report.json", "pretty", "html:target/HtmlReports"}

		)
public class TestRunner {

}
