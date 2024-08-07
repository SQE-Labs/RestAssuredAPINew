package api.endPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;



import api.payload.pet;

public class petEndPoints {

	
	public static Response addNewPet(pet payload) {
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when().post(Routes.pet_post_url);
				
				return response;
			
	}
	
	
	public static Response uploadPetImage(int petId) {
		Response response = given()
				.accept(ContentType.JSON)
				.contentType("multipart/form-data")
				.pathParam("petId", petId)
				.multiPart("file","C:/Users/lenovo/Desktop/AutomationParallelCE/TestData/Cat_11zon.jpg")
				
				.when().post(Routes.pet_uploadeImage_url);
		
		return response;
	}
	
	
	public static Response getPet(int petId) {
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("petId", petId)
				
				.when().get(Routes.pet_get_url);
		
		return response;
	}
	
	
	public static Response updatePetName(pet payload ) {
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				.when().put(Routes.pets_put__url);
		
		
		return response;
		
	}
	
	public static Response getPetFindbyStatus(String status) {
		Response response = given()
				.accept(ContentType.JSON)
				.queryParam("status", status)
				.when().get(Routes.pet_get_status_url);
		
		
		return response;
		
	}
	
	
	
	public static Response getPet400(int petId) {
		Response response = given()
				.accept(ContentType.BINARY)
				.pathParam("petId", petId)
				
				.when().get(Routes.pet_get_url);
		
		return response;
	}
	
	
public static Response addNewPet405(pet payload) {
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when().get(Routes.pet_post_url);
				
				return response;
			
	}


public static Response deletePet(int petId) {
	Response response = given()
			.contentType(ContentType.JSON)
			.pathParam("petId", petId)
			.when().delete(Routes.pet_del_url);
	
	return response;
			
}
	
	 
	   
}
