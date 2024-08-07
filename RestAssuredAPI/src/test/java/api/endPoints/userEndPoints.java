package api.endPoints;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class userEndPoints {

	public static Response createUser(user payload) {
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when().post(Routes.post_url);

		return response;

	}

	public static Response getUser(String username) {
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)

				.when().get(Routes.get_url);

		return response;

	}

	public static Response updateUser(String username, user payload) {
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)

				.when().put(Routes.put_url);

		return response;

	}
	
	
	
	public static Response deleteUser(String username) {
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)

				.when().delete(Routes.del_url);

		return response;

	}
	
	
	public static Response loginUser(String username , String password) {
		Response response = given()
				.accept(ContentType.JSON)
				.queryParam("username", username)
				.queryParam("password", password)
				.when().get(Routes.login_url);
		
		return response;
	}

}
