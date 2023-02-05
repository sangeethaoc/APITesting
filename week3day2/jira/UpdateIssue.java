package week3day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateIssue {
	@Test
public void issueUpdation()
{
		// Requirement API document

				// Add Endpoint
				RestAssured.baseURI = "https://restapitesting2023.atlassian.net/rest/api/2";

				// Construct Request(Headers, Authentication and Request Body)

				// Add Authentication
				RestAssured.authentication = RestAssured.preemptive().basic("qaautomationarchitect@gmail.com", "nPhwywyjw15PFbyulc3Y670B");

				// Construct request body
				RequestSpecification requestSpecification = RestAssured.given()
						.contentType("application/json")
						.when()
						.body("{\r\n"
								+ "    \"fields\": {\r\n"
								+ "        \"description\": \"Bug creation Using REST API for testing\"\r\n"
								+ "    }\r\n"
								+ "}");
				// Send Request
				Response response = requestSpecification.put("/issue/TS-9");

				// Print Response Code
				System.out.println("Status Code : " + response.getStatusCode());

				// Validate Response code
				ValidatableResponse statusCode = response.then().assertThat().statusCode(204);

				// Print Response
				response.prettyPrint();

}
}
