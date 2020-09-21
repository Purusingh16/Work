package com.cg.api;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cg.test.UtilClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDataDriven {
	
	RequestSpecification request;
    Response response;
    JsonPath jsonpath;
    JSONObject jsonObject;
    
    @BeforeSuite
    public void init()
    {
        request=RestAssured.given();
        request.baseUri("https://reqres.in");
        jsonObject=new JSONObject();
        
    }
    
    @Test(dataProvider="getData")
    public void checkPostResponseStatus(String Emp_name,String role)
    {
        jsonObject.put("name", Emp_name);
        jsonObject.put("job",role);
        request.body(jsonObject.toJSONString());
        System.out.println("Json String :"+jsonObject.toJSONString());
        response=request.post("/api/users");
        Assert.assertEquals(response.getStatusCode(),201);
    }
    
    @DataProvider
    public Object[][] getData()
    {
        Object obj[][]=UtilClass.getData();
        return obj;
    }
}
 


