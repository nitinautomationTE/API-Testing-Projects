package restassured_Artifiactid_practiceAugust_2024_PlaceMgmt;

import io.restassured.path.json.JsonPath;
import payload.Payload;

public class DivingInDepth_AutomateComplexAPI {

	public static void main(String[] args) {
		// 1. Print the number of courses returned by api-
		
		JsonPath js = new JsonPath(Payload.complexJson());
		int courses_count = js.getInt("courses.size()");
		System.out.println(courses_count);
		
		//2. Print purchase amount
		int dashboard_purchaseamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(dashboard_purchaseamount);
		
		//3. Print title of first course
		String first_course_title = js.get("courses[0].title");
		System.out.println(first_course_title);
		
		//4. Print all courses titles and their respective prices
		for(int i=0; i<courses_count;i++)
		{
			String title = js.get("courses["+i+"].title");
			int price = js.getInt("courses["+i+"].price");
			System.out.println(title);
			System.out.println(price);
		}
		
		//5. Print number of copies sold by RPA course
		for(int i=0; i<courses_count;i++)
		{
			String title = js.get("courses["+i+"].title");
			if(title.equalsIgnoreCase("RPA")) 
			{
			int rpa_copies =  js.getInt("courses["+i+"].copies");
			System.out.println(rpa_copies);
			break;
		    }
		}
		//6. Verify if sum of all course price matches with purchase amount
		int sum=0;
		for(int i=0; i<courses_count;i++)
		{
				int price = js.getInt("courses["+i+"].price");
				sum=sum+price;	
		}
		
		if(sum==dashboard_purchaseamount) {
			System.out.println("Actual sum"+sum);
		}
		else {
			System.out.println("All course price did not matched purchase amount");
		}
	}

}
