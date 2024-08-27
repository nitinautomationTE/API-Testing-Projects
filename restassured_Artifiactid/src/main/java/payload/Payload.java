package payload;
public class Payload{

		// TODO Auto-generated method stub
		public static String payload() {
			return "{\r\n"
					+ "  \"location\": {\r\n"
					+ "    \"lat\": -38.383494,\r\n"
					+ "    \"lng\": 33.427362\r\n"
					+ "  },\r\n"
					+ "  \"accuracy\": 50,\r\n"
					+ "  \"name\": \"Frontline house\",\r\n"
					+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
					+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
					+ "  \"types\": [\r\n"
					+ "    \"shoe park\",\r\n"
					+ "    \"shop\"\r\n"
					+ "  ],\r\n"
					+ "  \"website\": \"http://google.com\",\r\n"
					+ "  \"language\": \"French-IN\"\r\n"
					+ "}"
					;

	    }
		public static String complexJson() {
			String complexjson="{\n\"dashboard\":{\n      \"purchaseAmount\":9000,\n      \"website\":\"rahulshettyacademey.yahoo\"},\n\"courses\":[{\"title\":\"Selenium\",\"price\":3000,\"copies\":7},{\"title\":\"RPA\",\"price\":4000,\"copies\":8},{\"title\":\"Selenium\",\"price\":2000,\"copies\":6}]\n}";
			return complexjson;		
		
		}
		//adding variable[actual variable] of call by value of method is called handling of dynamic json payload.
		public static String dynamicjson(String isbn,int aisle) {
			String librarydetails="{\n\"name\":\"Learning RA\",\n\"isbn\":\""+isbn+"\",\n\"aisle\":\""+aisle+"\",\n\"author\":\"kp\"\n}";
			return librarydetails;
			
		}
}
