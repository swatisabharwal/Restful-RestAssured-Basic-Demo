package test_RestFulAPI_Package;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test2_RestFul_Get_And_Post_Test {
	
	@Test
	public void get_User_List() {
		baseURI= "https://reqres.in/api";
		when()
		 .get("/users?page=2").
		then()
		 .statusCode(200)
		 .body("data[4].first_name", equalTo("George"))
		 .body("data.first_name",hasItems("George", "Michael") )
		 .log().all();
		
		
	}
	
	@Test
	public void post_Create_User() {
		
		JSONObject jsonrequest = new JSONObject();
		jsonrequest.put("name", "Swati");
		jsonrequest.put("Job", "leader");
		
		System.out.println(jsonrequest.toJSONString());
		
		baseURI= "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			body(jsonrequest.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
			
		
	}

}


