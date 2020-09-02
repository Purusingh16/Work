package com.cg.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features", glue= {"com.cg.stepdef"}, monochrome=true, dryRun=false, tags={"@Smoke, @Regression"})
public class Test {

}
