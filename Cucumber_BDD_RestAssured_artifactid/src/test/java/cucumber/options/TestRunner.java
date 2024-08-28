package cucumber.options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Nitin\\RestAssured\\Practice\\Cucumber_BDD_RestAssured_artifactid\\src\\test\\java\\"
		+ "features\\placeValidations.feature",glue= {"stepDefinitions"})
public class TestRunner {

}
/* we all are set now. lets run this test.we are pointing to run this feature -features="C:\\Nitin\\RestAssured\\Practice\\
 * Cucumber_BDD_RestAssured_artifactid\\src\\test\\java\\features\\placeValidations.feature
 * and we are referring this step defintion-glue= {"stepDefinitions"}.Currently we don't have any
   We run this so that we can get the implementation syntax. Right click and run as junit.
 */
