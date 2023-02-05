package week3day2.servicenow;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetIncidentsWithMultipleQueryParams {

	@Test
	public void getIncidentsWithMultipleParams() {
		// Add Endpoint
		RestAssured.baseURI = "https://dev107650.service-now.com/api/now/table";

		// Construct Request(Headers, Authentication and Request Body)

		// Add Authentication
		RestAssured.authentication = RestAssured.basic("admin", "Sangee@2503");

		// Construct request body
		Map<String, String> paramsMap = new HashMap<String, String>();

		paramsMap.put("sysparm_fields", "sys_id,number,short_description");
		paramsMap.put("sysparm_limit", "10");

		RequestSpecification RequestSpecification = RestAssured.given().accept("application/xml")
				.queryParams(paramsMap);
		// .queryParam("sysparm_fields", "sys_id,number,short_description")
		// .queryParam("sysparm_limit", 10);

		// Send request
		Response response = RequestSpecification.get("/incident");

		// Print Status Code
		System.out.println("Status Code : " + response.getStatusCode());
		
		// Validate Response code
		ValidatableResponse statusCode = response.then().assertThat().statusCode(200);	

		// Print the response
		response.prettyPrint();

	}
}
