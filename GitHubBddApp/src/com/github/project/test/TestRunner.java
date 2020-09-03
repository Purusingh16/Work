package com.github.project.test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features= {"Feature"}, 
							glue="com.github.naukri.stepdef",
							dryRun=false,
							tags= {"@NaukriSmokeTesting"})
public class TestRunner {
		


}