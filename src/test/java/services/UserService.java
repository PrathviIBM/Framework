package services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

import data.Payloads;

public class UserService {
	public static Response registerUser(String email, String password) {
        return given()
            .body(Payloads.registerPayload(email, password))
            .log().all()
        .when()
            .post(Endpoints.REGISTER);
    }
	
	public static Response createUserPayload(String name, String job) {
        return given()
            .body(Payloads.createUserPayload(name, job))
            .log().all()
        .when()
            .post(Endpoints.CREAT_USER);
    }
	
	public static Response getUser(String id, int id1){
		return given()
				.pathParam(id, id1)
				.log().all()
				.when()
				.get(Endpoints.GET_USER);
				
	}
}
