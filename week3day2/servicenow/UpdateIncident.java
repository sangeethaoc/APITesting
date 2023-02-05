package week3day2.servicenow;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident {
	
	@Test
	public void incidentUpdation()
	{
		//Requirement API document
		
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
																	+ "    \"short_description\": \"My First Incident Request via RestAssured API\",\r\n"
																	+ "    \"description\": \"My First Incident Request created in Service Now via RestAssured API\"\r\n"
																	+ "}");
				// Send Request
				Response response = requestSpecification.put("/incident/d71b3b41c0a8016700a8ef040791e72a");
				
				// Print Response Code
				System.out.println("Status Code : "+response.getStatusCode());
				
				// Validate Response code
				ValidatableResponse statusCode = response.then().assertThat().statusCode(200);
				
				//Print Response
				response.prettyPrint();
	}

}
