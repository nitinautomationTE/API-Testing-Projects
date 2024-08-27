package restassured_Artifiactid_practiceAugust_2024_library_mgmt;

import io.restassured.RestAssured;

public class DynamicJsonHandle {
	public void addBook(String isbn,int aisle) {
		RestAssured.baseURI="";
		given().header("Content-Type","application/json").body(Payload.add)
		
	}

}
