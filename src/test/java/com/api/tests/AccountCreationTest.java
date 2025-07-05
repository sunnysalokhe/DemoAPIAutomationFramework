package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify Account creation API is working")
	public void createAccountTest() {
		
		SignUpRequest signuprequest = new SignUpRequest.Builder()
		.userName("Rohit4646")
		.email("Rohit@yahoo.com")
		.firstName("Rohit")
		.lastName("Kumar")
		.mobileNumber("8956344343")
		.password("Rohit4646")
		.build();
		
		AuthService authservice = new AuthService();
		Response response = authservice.signup(signuprequest);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		
		
	}
	

}
