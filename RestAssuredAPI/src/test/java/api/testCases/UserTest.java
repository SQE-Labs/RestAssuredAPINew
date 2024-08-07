package api.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endPoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	
	// Generate test data by java faker 
	
	Faker faker;
	user userPayload;
	
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload = new user();
		
		// generate fake id and set 
		userPayload.setId(faker.idNumber().hashCode());
		
		userPayload.setFirstName(faker.name().firstName());
		
		userPayload.setUsername(faker.name().username());
		
		userPayload.setLastName(faker.name().lastName());
		
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		userPayload.setPassword(faker.internet().password(5,10));
		
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	
	@Test(priority = 1)
	public void testCreateUser() {
		
		 System.out.println(userPayload);
		 Response response = userEndPoints.createUser(userPayload);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	
	@Test(priority = 2)
	public void testGetUserData() {
		 Response response = userEndPoints.getUser(this.userPayload.getUsername());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		 userPayload.setFirstName(faker.name().firstName());
		 Response response = userEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		System.out.println(this.userPayload.getUsername());
		 Response response = userEndPoints.deleteUser(this.userPayload.getUsername());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	
	@Test(priority = 5,description = "Verify 404 error status code when wrong username passed")
	public void testGet404StatusCode() {
		 Response response = userEndPoints.getUser("fjkierr");
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),404);
		 
	
	}
	
	
	
	
	
	@Test(priority = 6)
	public void testDeleteUser404() {
		
		System.out.println(this.userPayload.getUsername());
		 Response response = userEndPoints.deleteUser("4urjf9j");
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),404);
		 
	
	}
	
	
	
	
	@Test(priority = 7)
	public void testLoginUser() {
		
		System.out.println(this.userPayload.getUsername());
		System.out.println(this.userPayload.getPassword());
		 Response response = userEndPoints.loginUser(this.userPayload.getUsername(),this.userPayload.getPassword());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	@Test(priority = 8)
	public void testLoginUser404() {
		
		System.out.println(this.userPayload.getUsername());
		System.out.println(this.userPayload.getPassword());
		 Response response = userEndPoints.loginUser(this.userPayload.getUsername(),this.userPayload.getPassword());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
