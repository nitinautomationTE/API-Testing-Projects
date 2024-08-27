package restassured_Artifiactid_practiceAugust_2024_PlaceMgmt;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.Payload;

public class UpdatePlaceAndValidate {
	/* we need place id to update place, where place id we will get from add place id api response because its
	 * dynamic. to perform this api chaining is required.
	 * note: PUT api request gives reponse only like values are updated i mean like a direction message
	 *       so how  could you validate if you don't see the response. So this hit get api to check.
	   Add place->update place with new address->get place to validate if new address is present in response.
	 */
	
	 public static void main(String[] args) {
    
	//Add place api
    		RestAssured.baseURI="https://rahulshettyacademy.com/";
    		String response = given().log().all().queryParam("key", "qaclick123").header("Connection","keep-alive").header("Content-Type","application/json").
    		body(Payload.payload()).
    		when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
    		.body("scope",equalTo("APP")).header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
    		
    		System.out.println(response);
    		JsonPath js = new JsonPath(response);//for parsing json
    		String placeid=js.getString("place_id");
    		System.out.println(placeid);
     //Update place api-queryParam("place_id",""+placeid+"\",\r\n")//NOTE: everytime change address
    		String updated_expected_address ="83 winter walk, USA";
    	    String resp1= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").header("place_id",""+placeid+"").body("{\r\n"
    				+ "\"place_id\":\""+placeid+"\",\r\n"
    				+ "\"address\":\""+updated_expected_address+"\",\r\n"
    				+ "\"key\":\"qaclick123\"\r\n"
    				+ "}").
    		when().put("maps/api/place/update/json").
    		then().log().all().statusCode(200).statusLine("HTTP/1.1 200 OK").body("msg",equalTo("Address successfully updated")).
    		extract().response().asString();
    	    
    	    System.out.println(resp1);
    	    JsonPath js1 = new JsonPath(resp1);
    	    String msg = js1.get("msg");
    	    System.out.println(msg);
    	    
    	//Get place id ( to validate)//Note: we don't need to provide header in get api call, only query params are there.
    	    String getResponse =given().log().all().queryParam("key","qaclick123").queryParam("place_id", ""+placeid+"").
    	    when().get("maps/api/place/get/json").
    	    then().statusCode(200).statusLine("HTTP/1.1 200 OK").
    	    extract().response().asString();
    	    
    	    System.out.println(getResponse);
    	    JsonPath js2 = new JsonPath(getResponse);
    	    String updated_actual_address = js2.get("address");
    	    System.out.println(updated_actual_address);
    	    Assert.assertEquals(updated_expected_address, updated_actual_address, "Expected address is not equals to actual address");
    	 
    	    
    	    
    	    
    	    
    		
    		
      }
}
