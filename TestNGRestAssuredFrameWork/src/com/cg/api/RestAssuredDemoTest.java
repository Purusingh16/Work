package com.cg.api;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredDemoTest {

	RequestSpecification request;
	Response response;
	JsonPath path;

	@BeforeSuite
	public void init() 
	{
		request = RestAssured.given();
		request.baseUri("https://reqres.in");// base uri
		request.queryParam("page", "2");// query
		response = request.get("/api/users");// Resource or path para
		path = new JsonPath(response.asString());
	}

	@Test
	public void checkRequestStatusCode()
	{
		Assert.assertEquals(response.getStatusCode(), 200);
		// System.out.println(response.getStatusCode());
		// System.out.println(response.getStatusLine());
		// System.out.println(response.getTime());
		// System.out.println(response.getContentType());
	}

	@Test
	public void checkStatusLine()
	{
		Assert.assertTrue(response.getStatusLine().contains("OK"));
	}

	@Test
	public void checkResponseTime()
	{
		Assert.assertTrue(response.getTime() < 3000);
	}

	@Test
	public void checkContentType() 
	{
		Assert.assertTrue(response.getContentType().contains("json"));
	}

	@Test
	public void checkName()
	{
		String str = path.get("data[2].first_name");
		Assert.assertEquals(str, "Tobias");
	}

	// check email id of 4th element
	// check first name and last name of ID=8
	@Test
	public void checkName1()
	{
		String str = path.get("data[1].first_name");
		// Assert.assertEquals(str, "Tobias");
		System.out.println("First_Name:" + str);
	}

	@Test
	public void getSUMID() 
	{
		int sum = 0;

	}

	/*
	 * @Test public void checkGetRequest() { Response
	 * response=RestAssured.get("https://reqres.in/api/users?page=2");
	 * //System.out.println(response.asString());
	 * System.out.println(response.getStatusCode()); }
	 */

}
