package services;

import io.restassured.response.Response;
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
        .when()
            .post(Endpoints.CREAT_USER);
    }
}
