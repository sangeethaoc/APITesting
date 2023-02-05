package week3day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteIssue {

	@Test
	public void issueDeletion()
	{
		// Requirement API document

				// Add Endpoint
				RestAssured.baseURI = "https://restapitesting2023.atlassian.net/rest/api/2";

				// Construct Request(Headers, Authentication and Request Body)

				// Add Authentication
				RestAssured.authentication = RestAssured.preemptive().basic("qaautomationarchitect@gmail.com", "nPhwywyjw15PFbyulc3Y670B");

				// Construct request body
				RequestSpecification requestSpecification = RestAssured.given();
				
				// Send Request
				Response response = requestSpecification.delete("/issue/TS-9");

				// Print Response Code
				System.out.println("Status Code : " + response.getStatusCode());

				// Validate Response code
				ValidatableResponse statusCode = response.then().assertThat().statusCode(204);

				// Print Response
				response.prettyPrint();

	}
}
