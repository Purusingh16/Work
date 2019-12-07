package cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(plugin={"json:target/cucumber-report.json","pretty","html:target/cucumber","rerun:target/rerun.txt"},
glue="stepDefination",dryRun=false,monochrome=true,features="src/test/resources/featurefiles/firstcucumberdemo.feature",
tags={"@sanity or @regression"})
public class JavaTestRunner extends AbstractTestNGCucumberTests
{
   
}
