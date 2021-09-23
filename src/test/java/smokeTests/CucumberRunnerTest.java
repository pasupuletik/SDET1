package smokeTests;
import  base.DriverType;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/main/resources/feature/api.feature",

       // plugin = {"pretty", "html:target/results"},
        plugin={"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"},
        glue = {"stepDefinitions"},
        tags=" @smoke",
        monochrome = true,
        strict = true)


public class CucumberRunnerTest extends AbstractTestNGCucumberTests
{

}





