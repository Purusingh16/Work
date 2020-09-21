package com.cg.api;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleData {

	RequestSpecification request;
	Response response;
	JsonPath jsonpath;

	@BeforeSuite
	public void init() {
		request = RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.queryParam("id", 2);
		response = request.get("/api/users");
		jsonpath = new JsonPath(response.asString());

	}

	@Test(description = "Check if status code is 200 or Not")
	public void statusCheck() 
	{
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(description = "Check entire data is present or not")
	public void checkData() 
	{
		Assert.assertNotNull(jsonpath.getInt("data.id"));
		Assert.assertEquals(jsonpath.getString("data.first_name"), "Janet");
		Assert.assertTrue(jsonpath.getString("data.last_name").equalsIgnoreCase("Weaver"));
		Assert.assertTrue(jsonpath.get("data.email").equals("janet.weaver@reqres.in"));

	}

}
