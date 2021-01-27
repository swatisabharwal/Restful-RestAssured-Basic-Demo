package test_RestFulAPI_Package;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class Test1_Restful_API_Test {

	@Test
	public void test_Case1 () {
		Response response = get("https://reqres.in/api/users?page=2");
				
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getBody().asPrettyString());
		
		int status_code = response.getStatusCode();
		Assert.assertEquals(status_code, 200);
		
	}
	
	@Test
	public void test_Case2() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			log().all();
			
	}
}
