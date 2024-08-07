package api.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endPoints.userEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	
	
	
	@Test(priority = 1,dataProvider= "AllData" ,dataProviderClass =DataProviders.class)
	public void testCreateUser(String userId,String UserName,String fname,String lname,String email,String pwd,String phone) {
		
        user userPayload = new user();
		
		// generate fake id and set 
		userPayload.setId(Integer.parseInt(userId));		
		userPayload.setFirstName(fname);
		userPayload.setUsername(UserName);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		Response response = userEndPoints.createUser(userPayload);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	@Test(priority = 2,dataProvider = "UserNamesData",dataProviderClass =DataProviders.class)
	public void testDeleteUser(String username) {
		
		//System.out.println(this.userPayload.getUsername());
		 Response response = userEndPoints.deleteUser(username);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}

}
