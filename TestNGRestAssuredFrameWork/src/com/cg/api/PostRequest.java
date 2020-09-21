package com.cg.api;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	RequestSpecification request;
	Response response;
	JSONObject jsonObject;
	
	@BeforeSuite
	public void init()
	{
		request=RestAssured.given();
		request.baseUri("https://reqres.in/");
		jsonObject=new JSONObject();
	}
	
	@Test
	public void checkPostResposeStatus()
	{
		jsonObject.put("name", "Purusingh");
		jsonObject.put("job", "Automation");
		
		request.body(jsonObject.toJSONString());
		System.out.println("JSON string :"+ jsonObject.toJSONString());
		response=request.post("/api/users");
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
