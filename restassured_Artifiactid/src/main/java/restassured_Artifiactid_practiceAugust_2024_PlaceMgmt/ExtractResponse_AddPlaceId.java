package restassured_Artifiactid_practiceAugust_2024_PlaceMgmt;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.Payload;

public class ExtractResponse_AddPlaceId {
           public static void main(String[] args) {
        	// TODO Auto-generated method stub
       		
       		RestAssured.baseURI="https://rahulshettyacademy.com/";
       		String response = given().log().all().queryParam("key", "qaclick123").header("Connection","keep-alive").header("Content-Type","application/json").
       		body(Payload.payload()).
       		when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
       		.body("scope",equalTo("APP")).header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
       		
       		System.out.println(response);
       		JsonPath js = new JsonPath(response);//for parsing json
       		String placeid=js.getString("place_id");
       		System.out.println(placeid);
       		
       		/* so note one thing from this code,in response three things are dynamic , at each hit its respond new response_id, id,reference.
       		   if you need these three parameters value then you have to handle it through chaining.
       		 */
       		//Add place->update place with new address->get place to validate if new address is present in response.
       		
            
           }
}
