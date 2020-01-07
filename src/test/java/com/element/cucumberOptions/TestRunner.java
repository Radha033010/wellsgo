package com.element.cucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/element/features/",
		glue = {"com/element/stepDefinitions/" },

		//or condition
//		tags={"@Tulip,@riga"},
//         tags={"@AddNotes,@AddFiles"},
		// and condition
//		tags={"@Tulip","@riga"},

		//ignore condition
//		tags={"@Tulip","~@riga"},

		plugin = { "pretty", "html:target/report/cucumber", "json:target/report/json/login.json",
				"unused:target/unused.log" })

public class TestRunner extends AbstractTestNGCucumberTests {
}