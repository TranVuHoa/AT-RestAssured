package tests;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIExamples extends DataForTest{

	@Test(enabled = true)
	public void testGet() {
		
		baseURI = "https://reqres.in/api";

		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George","Rachel"));
	
	}
	
	@Test(enabled = true, dataProvider = "DataForPost")
	public void testPost(String name, String job) {
		
		JSONObject request = new JSONObject();
		request.put("name", name);
		request.put("job", job);
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString())
		.when().
			post("/user").
		then().
			statusCode(201).log().all();
	
	}
	
	@Test(enabled = true)
	public void testPut() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200)
			.log().all();
	
	}
	
	@Test(enabled = true)
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/api/users/2").
		then().
			statusCode(200)
			.log().all();
	
	}
	
	@Test(enabled = true)
	public void testDelete() {
		
		baseURI = "https://reqres.in";
	
		when().
			delete("/api/users/2").
		then().
			statusCode(204)
			.log().all();
	
		}
	
}
