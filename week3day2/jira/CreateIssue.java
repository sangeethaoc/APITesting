package week3day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateIssue {
	@Test
	public void issueCreation() {
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
						+ "        \"project\": {\r\n"
						+ "            \"key\": \"TS\"\r\n"
						+ "        },\r\n"
						+ "        \"summary\": \"Create issue in RA project\",\r\n"
						+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
						+ "        \"issuetype\": {\r\n"
						+ "            \"name\": \"Bug\"\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "}");
		// Send Request
		Response response = requestSpecification.post("/issue");

		// Print Response Code
		System.out.println("Status Code : " + response.getStatusCode());

		// Validate Response code
		ValidatableResponse statusCode = response.then().assertThat().statusCode(201);

		// Print Response
		response.prettyPrint();

	}
}
