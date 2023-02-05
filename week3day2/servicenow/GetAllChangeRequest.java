package week3day2.servicenow;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetAllChangeRequest {

	@Test
	public void getChangeRequests()
	{
		// Add Endpoint
		RestAssured.baseURI = "https://dev107650.service-now.com/api/now/table";
		
		//Construct Request(Headers, Authentication and Request Body)
		
		//Add Authentication
		RestAssured.authentication = RestAssured.basic("admin", "Sangee@2503");
		
		// Construct request body
		RequestSpecification RequestSpecification = RestAssured.given()
													.accept("application/xml");
		
		// Send request
		Response response = RequestSpecification.get("/change_request");
		
		//Print Status Code
		System.out.println("Status Code : " + response.getStatusCode());
		
		// Validate Response code
		ValidatableResponse statusCode = response.then().assertThat().statusCode(200);	
		
		// Print the response
		response.prettyPrint();
		
		
	}
}
