package utils;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
public class AssertionUtils {

	public static void logResponse(Response response) {		
		System.out.print("\n<---------------------- < API Response > ---------------------->\n\n");
		response.then().log().body();
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
	
	public static void tokenValidation(Response response) {					
		String token = response.jsonPath().getString("token");
		 Assert.assertNotNull(token, "Token should not be null");
	}
}
