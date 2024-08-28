package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name,String language,String address ){
		 AddPlace p = new AddPlace();
		   p.setAccuracy(50);
		   p.setAddress(address);
		   p.setLanguage(language);
		   p.setPhone_number("(+91) 983 893 3937");
		   p.setWebsite("http://google.com");
		   p.setName(name);
		   
		   List<String> mylist = new  ArrayList<String>();
		   mylist.add("shoe park");
		   mylist.add("shop");
		   p.setTypes(mylist);
		   
		   Location loc = new Location();
		   loc.setLat(0);
		   loc.setLng(0);
		   p.setLocation(loc);
		   
		   return p;
	}

}
