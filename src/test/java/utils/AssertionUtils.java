package utils;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class AssertionUtils {

	public static void logResponse(Response response) {
		//response.then().log().all();
		ExtentTestManager.getTest().info("Response: " + response.asPrettyString());
	}
	
	public static void statusCode(Response response, int expectedStatusCode) {
		response.then().statusCode(expectedStatusCode);
		ExtentTestManager.getTest().info("Status code validated: " + expectedStatusCode);		
	}
	
	public static void assertResponseBody(Response response,String jsonPath, Object expectedValue) {
		response.then().body(jsonPath, equalTo(expectedValue));
		ExtentTestManager.getTest().info("Verified JSON path: " + jsonPath + " = " + expectedValue);
	}
}
