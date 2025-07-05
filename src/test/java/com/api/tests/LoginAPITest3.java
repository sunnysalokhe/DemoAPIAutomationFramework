package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest3 {
	
	@Test(description="Verify if login API is working")
	public void loginTest() {
		
		LoginRequest loginrequest = new LoginRequest("Sunny", "Selenium4@#");
		AuthService authservice = new AuthService();
		Response response = authservice.login(loginrequest);
		//System.out.println(response.asPrettyString());
		LoginResponse loginresponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println("Token is : " +loginresponse.getToken());
		System.out.println("Username is : " +loginresponse.getUsername());
		System.out.println("Email is : " +loginresponse.getEmail());
		System.out.println("ID is : " +loginresponse.getId());
		System.out.println("Type is : " +loginresponse.getType());
		
		Assert.assertTrue(loginresponse.getToken() != null);
		Assert.assertEquals(loginresponse.getUsername(), "sunny");
		Assert.assertEquals(loginresponse.getEmail(), "sunnysalokhe567@yahoo.com");
		Assert.assertEquals(loginresponse.getId(), 1897);
		Assert.assertEquals(loginresponse.getType(), "Bearer");
		
		
	}

}