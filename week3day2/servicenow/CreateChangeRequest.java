package week3day2.servicenow;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateChangeRequest {
	
	
	@Test
	public void changeRequestCreation()
	{
				//Add Endpoint
				RestAssured.baseURI="https://dev107650.service-now.com/api/now/table";	
				
				//Construct Request(Headers, Authentication and Request Body)
				
				//Add Authentication
				RestAssured.authentication = RestAssured.basic("admin","Sangee@2503");
				
				//Construct request body
				RequestSpecification requestSpecification = RestAssured.given()
															.contentType("application/json")
															.accept("application/xml")
															.when()
															.body("{\r\n"
																	+ "    \"short_description\": \"Add network switch to cabinet\",\r\n"
																	+ "    \"contact_type\": \"Phone\",\r\n"
																	+ "    \"company\": \"HPE\"\r\n"
																	+ "}");
				// Send Request
				Response response = requestSpecification.post("/change_request");
				
				// Print Response Code
				System.out.println("Status Code : "+response.getStatusCode());
				
				// Validate Response code
				ValidatableResponse statusCode = response.then().assertThat().statusCode(201);	
				
				//Print Response
				response.prettyPrint();
				
	}
}
