
package restassured_Artifiactid_practiceAugust_2024_PlaceMgmt;

import io.restassured.RestAssured;
import payload.Payload;

import static io.restassured.RestAssured.*;//given(),when(),then() belongs to this package.Eclipse will not add it bydefault.
import static org.hamcrest.Matchers.*;//equalTo() belongs to this package.Eclipse will not add it bydefault.

public class AddPlaceWithExhibitedPayload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123").header("Connection","keep-alive").header("Content-Type","application/json").
		body(Payload.payload()).
		when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
		.body("scope",equalTo("APP")).body("id",equalTo("2c89522a39f9e9e3b1844b74e180e5ec")).header("server","Apache/2.4.52 (Ubuntu)");
		
		/* so note one thing from this code,in response three things are dynamic , at each hit its respond new response_id, id,reference.
		   if you need these three parameters value then you have to handle it through chaining.
		 */
		//Add place->update place with new address->get place to validate if new address is present in response.
		

	}

}
