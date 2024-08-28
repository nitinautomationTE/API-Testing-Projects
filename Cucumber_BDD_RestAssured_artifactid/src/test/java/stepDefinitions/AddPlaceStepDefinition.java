package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

public class AddPlaceStepDefinition extends Utils{
	//Global variable(class level variable)
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	/*@Given("Add Place PAYLOAD")
	public void add_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions			    
	   resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	   res=given().spec(requestSpecification()).body(data.addPlacePayload());
	   }*/
	
	@Given("Add Place PAYLOAD {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		   resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		   res=given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
	}

    @When("user calls {string} with Post HTTP request")
	public void user_calls_with_post_http_request(String string) {

    	    response =res.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();


	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expected_value) {
		String responseString=response.asString();
		JsonPath js= new JsonPath(responseString);
		assertEquals(js.get(key).toString(),expected_value);
	}

}
