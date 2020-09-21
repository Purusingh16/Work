package com.cg.api;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cg.test.UtilClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDataDriven {
	    RequestSpecification request;
	    Response response;
	    JsonPath path;
	    int count;
	    static int index=0;
	    @BeforeSuite
	    public void init()
	    {
	        request=RestAssured.given();
	        request.baseUri("https://reqres.in");//base uri
	        request.queryParam("page","2");//query
	        response=request.get("/api/users");//Resource or path para
	        path=new JsonPath(response.asString());
	        count=path.getInt("data.size()");
	    }
	    
	    @Test(dataProvider="getData")
	    public void checkData(String fname,String lname)
	    {
	        
	        Assert.assertEquals(path.getString("data["+index+"].first_name"), fname);
	        Assert.assertEquals(path.getString("data["+index+"].last_name"), lname);
	        index++;//1
	    }
	    
	    @DataProvider
	    public Object[][] getData()
	    {
	        Object obj[][]=UtilClass.getData();
	        return obj;
	    }
	}
	 







	


