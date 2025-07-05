package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description = "Verify if forgot password API is working")
	public void forgotPasswordTest() {
		
		AuthService authservice = new AuthService();
		Response response= authservice.forgotPassword("sunnysalokhe567@yahoo.com");
		System.out.println(response.asPrettyString());
		
	}

}