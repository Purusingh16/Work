package com.cg.bddapp.tests;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="Features" , glue="com.cg.bddapp.stepdefs",monochrome=false,tags= {"@Smoke","@Regression"})
public class TestRunner {}