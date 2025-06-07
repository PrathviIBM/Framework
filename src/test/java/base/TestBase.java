package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;

public class TestBase {

// 1. First way of setting up baseURI without headers

//    @BeforeClass
//    public void setup() {
//        RestAssured.baseURI = "https://reqres.in/api";
//    }

	// <!---------------------------------------------------------------------!>

// 2. Second way of setting up header with baseURI and RequestSpecification

//	public static RequestSpecification requestSpec;
//
//    @BeforeClass
//    public void setup() {
//        RestAssured.baseURI = "https://reqres.in/api";  // You can read from config file if needed
//
//        requestSpec = new RequestSpecBuilder()
//            .addHeader("Content-Type", "application/json")
//            .addHeader("x-api-key", "reqres-free-v1")  // Example custom header
//            .build();
//
//        RestAssured.requestSpecification = requestSpec;
//    }

	// <!---------------------------------------------------------------------!>

//  3. Third way of setting up header with baseURI,RequestSpecification with Map

	public static RequestSpecification requestSpec;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://reqres.in/api";

		// Step 1: Create a map of headers
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("x-api-key", "reqres-free-v1");

		// Step 2: Build the request specification with map
		requestSpec = new RequestSpecBuilder().addHeaders(headers).build();

		// Step 3: Assign to global request specification
		RestAssured.requestSpecification = requestSpec;
	}
}
