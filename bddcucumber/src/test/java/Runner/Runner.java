package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C://Users//Lenovo//eclipse-workspace//reastAssuredPractice//bddcucumber//src//test//resources//Features//sauceDemo.feature",
glue= {"StepDefination"},
monochrome=true,
plugin= {"pretty","html:target/remport.html","json:target/jsonReport/report.json","junit:target/xmlReport/report.xml"})

public class Runner {

}
