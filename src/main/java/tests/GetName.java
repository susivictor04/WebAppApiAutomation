package tests;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;


public class GetName{
	
	

	@Test()
	public void login() {
		
		RestAssured.baseURI = "http://localhost:9002/api";
		Response response = RestAssured.get("/Babu");
		
		Assert.assertEquals(true, response.getStatusCode() == 200);
		Assert.assertEquals(true, response.getContentType().contains("text"));
		
		
		
	}
	
	
}
