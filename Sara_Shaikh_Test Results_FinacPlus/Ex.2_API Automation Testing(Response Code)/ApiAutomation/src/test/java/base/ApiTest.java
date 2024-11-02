package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void testGetRequest() {
        // Set the base URL
        RestAssured.baseURI = "https://reqres.in";

        // Send a GET request to the endpoint and store the response
        Response response = RestAssured.get("/api/users/2");

        // Print the response for debugging
        System.out.println("Response Body: " + response.getBody().asString());

        // Validate that the status code is 200
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        // Optionally, validate the content-type
        String contentType = response.getHeader("Content-Type");
        System.out.println("Content Type: " + contentType);
        Assert.assertTrue(contentType.contains("application/json"), "Content-Type is not JSON");
    }
}
