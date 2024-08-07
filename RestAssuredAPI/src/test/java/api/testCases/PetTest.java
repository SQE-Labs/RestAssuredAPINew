package api.testCases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.util.SSCellRange;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endPoints.petEndPoints;
import api.endPoints.userEndPoints;
import api.payload.pet;
import api.payload.user;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.response.Response;


public class PetTest {

	
	Faker faker;
	pet petPayload;
	
	
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		petPayload = new pet();
		
		// generate fake id and set 
		petPayload.setId(faker.number().numberBetween(1, 1000));
		
		
		pet.Category category = new pet.Category();
		
		category.setId(faker.number().numberBetween(1, 100));
		category.setName(faker.animal().name());
		petPayload.setCategory(category);
		

        List<String> photoUrls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            photoUrls.add(faker.internet().url());
        }
        
        petPayload.setPhotoUrls(photoUrls);
        
        List<pet.Tag> tags = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pet.Tag tag = new pet.Tag();
            tag.setId(faker.number().numberBetween(1, 100));
            tag.setName(faker.color().name());
            tags.add(tag);
        }
        petPayload.setTags(tags);
        
        petPayload.setStatus(faker.options().option("available", "pending", "sold"));	
		
	}
	
	
	
	
	@Test(priority = 1)
	public void testAddNewPet() {
		
		 System.out.println(petPayload);
		 Response response = petEndPoints.addNewPet(petPayload);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	@Test(priority = 2)
	public void testUploadPetImage() {
		
		System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.uploadPetImage(this.petPayload.getId());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	@Test(priority = 3)
	public void testGetPet() {
		
		System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.getPet(this.petPayload.getId());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	@Test(priority = 4)
	public void testupdatePetName() {
		
		System.out.println("Pet Id Is : " + this.petPayload.getId());	
	
		
        pet.Category category = new pet.Category();
		
		category.setName("Cow");
		this.petPayload.setCategory(category);
		System.out.println("Pet name Is : " + this.petPayload.getCategory().getName());
		
		 Response response = petEndPoints.updatePetName(this.petPayload);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		
		
		 
	}
	
	
	
	
	
	@Test(priority = 5)
	public void testgetPetFindbyStatus() {
		
		System.out.println("Pet Id Is : " + this.petPayload.getStatus());		
		 Response response = petEndPoints.getPetFindbyStatus(this.petPayload.getStatus());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	
	@Test(priority =6)
	public void testGetPet404() {
		
		//System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.getPet(498435893);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),404);
		 
	
	}
	
	
	@Test(priority =6)
	public void testGetPet400() {
		
		//System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.getPet(498435893);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),404);
		 
	
	}
	
	
	@Test(priority =7)
	public void testGetPet500Error() {
		
		//System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.getPet400(498435893);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),500);
		 
	
	}
	
	
	@Test(priority =8,description = "verify method not allowed 405 error code status")
	public void testaddNewPet405() {
		
		//System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.addNewPet405(this.petPayload);
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),405);
		 
	
	}
	
	
	@Test(priority =8,description = "verify delete pet and status code 200")
	public void testDeletePet() {
		
		//System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.deletePet(this.petPayload.getId());
	
	     // log response 
		 
		 response.then().log().all();
		 
		 
		 //Assert		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
	
	}
	
	
	
	@Test(priority =9,description = "verify all the record of pets")
	public void testGetPetByStatus() throws IOException {
		
		
		File file = new File("C:/Users/lenovo/Documents/ComcateParallel/RestAssuredAPI/TestData/expectedData.json");
        String expectedJson = FileUtils.readFileToString(file, "UTF-8");
		
		//System.out.println("Pet Id Is : " + this.petPayload.getId());
		 Response response = petEndPoints.getPetFindbyStatus("available");
	
	     // log response 
		 
		 response.then().log().all();
		 
		 String actualJsonResponse = response.asString();
		 
		 // Assert
		
		 // Compare the expected JSON with the actual JSON
	        try {
				JSONAssert.assertEquals(expectedJson, actualJsonResponse, false);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
	}
	
	
	
	
	@Test(priority =10,description = "verify all the record of pets")
	public void testGetPetByStatus2() throws IOException, JSONException {
		
		
//		File file = new File("C:/Users/lenovo/Documents/ComcateParallel/RestAssuredAPI/TestData/expectedData.json");
//        String expectedJson = FileUtils.readFileToString(file, "UTF-8");
//        
//		JSONObject jsonObject1 = new JSONObject(expectedJson);
//	
//		 Response response = petEndPoints.getPetFindbyStatus("available");
//		 response.then().log().all(); 
//		 String actualJsonResponse = response.asString();
//		 
//		 
//			JSONObject jsonObject2 = new JSONObject(actualJsonResponse);
//			System.out.println(jsonObject2);
//		 
//		 // Assert
//       	 Assert.assertTrue(jsonObject1.equals(jsonObject2));

		
		
        File file = new File("C:/Users/lenovo/Documents/ComcateParallel/RestAssuredAPI/TestData/expectedData.json");
        String expectedJson = FileUtils.readFileToString(file, "UTF-8");

       
        Object expected = expectedJson.trim().startsWith("[") ? new JSONArray(expectedJson) : new JSONObject(expectedJson);


        Response response = petEndPoints.getPetFindbyStatus("available");
        response.then().log().all();
        String actualJsonResponse = response.asString();

      
        Object actual = actualJsonResponse.trim().startsWith("[") ? new JSONArray(actualJsonResponse) : new JSONObject(actualJsonResponse);

      
        Assert.assertTrue(expected.equals(actual));
    }
		 
	
	}
	
	
	
	
	
	

