package tests;

import base.TestBase;
import data.Payloads;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.Endpoints;
import services.UserService;
import utils.AssertionUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// Second way for Testing

public class UserTests extends TestBase{

	@Test
	public void testRegisterUser(){
		UserService.registerUser("eve.holt@reqres.in", "pistol")
		.then()
		.log().all()
        .statusCode(200)
        .body("token", notNullValue());
	}
	
	@Test
	public void testCreateUser() {
		Response response = UserService.createUserPayload("morpheus", "leader");
		AssertionUtils.logResponse(response);
		AssertionUtils.statusCode(response,201);
		AssertionUtils.assertResponseBody(response, "name", "morpheus");
		
//		.then() // log implementation in AssertionUtils.java
//		.log().all()
//		.statusCode(201)
//        .body("name", equalTo("morpheus"));		
	}	
}




/* 1. First way of testing api's
public class UserTests extends TestBase {

    @Test
    public void testGetUser() {
        given()
//        	.header("x-api-key", "reqres-free-v1") //commented because header is setup in TestBase with RequestSpecification 
            .pathParam("id", 2)
            .log().all()
        .when()
            .get(Endpoints.getUser)
        .then()
        	.log().all()
            .statusCode(200)
            .body("data.id", equalTo(2));
    }

    @Test
    public void testCreateUser() {
        given()
//            .contentType(ContentType.JSON)	//commented because headers are setup in TestBase with RequestSpecification
//            .header("x-api-key", "reqres-free-v1")	//commented because headers are setup in TestBase with RequestSpecification
            .body(Payloads.createUserPayload("morpheus", "leader"))
            .log().all()
        .when()
            .post(Endpoints.createUser)
        .then()
        	.log().all()
            .statusCode(201)
            .body("name", equalTo("morpheus"));
    }

    @Test
    public void testRegisterUser() {
        given()        	
//        	.spec(requestSpec) //If you remove Global request then use this Step 3: Assign to global request specification // RestAssured.requestSpecification = requestSpec;
            .body(Payloads.registerPayload("eve.holt@reqres.in", "pistol"))
            .log().headers()
        .when()
            .post(Endpoints.register)
        .then()
        	.log().all()
            .statusCode(200)
            .body("token", notNullValue());
    }
} */
