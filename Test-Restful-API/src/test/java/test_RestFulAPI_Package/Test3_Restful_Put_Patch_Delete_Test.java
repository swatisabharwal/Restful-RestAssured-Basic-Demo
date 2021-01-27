package test_RestFulAPI_Package;

import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test3_Restful_Put_Patch_Delete_Test {
	
	@Test
	public void Test1_put_Update_User() {
		
		JSONObject jsonrequest = new JSONObject();
		jsonrequest.put("name", "Swati");
		jsonrequest.put("Job", "leader");
		
		System.out.println(jsonrequest.toJSONString());
		
		baseURI= "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			body(jsonrequest.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
			
		
	}
	
	@Test
	public void Test2_patch_Update_User() {
		
		JSONObject jsonrequest = new JSONObject();
		jsonrequest.put("name", "Blob");
		jsonrequest.put("Job", "Blobber");
		
		System.out.println(jsonrequest.toJSONString());
		
		baseURI= "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			body(jsonrequest.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
			
		
	}
	
	@Test
	public void Test3_delete_Update_User() {
			
		baseURI= "https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
			
		
	}
	
	
}
