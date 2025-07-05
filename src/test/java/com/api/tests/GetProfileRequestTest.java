package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test(description = " To verify Get profile request test API working fine")
	public void getProfileInfoTest() {
		
		//This is for authentication
		AuthService authservice = new AuthService();
		Response response = authservice.login(new LoginRequest("sunny", "Selenium4@#"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println("This is required AUTH token: " +loginResponse.getToken());
		
		//this is for user details
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		//System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		
		
	}
	
	
	

}
