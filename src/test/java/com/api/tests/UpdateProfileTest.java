package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test(description = "To check update profile API working fine")
	public void updateProfileTest() {
		
		AuthService authservice = new AuthService();
		Response response = authservice.login(new LoginRequest("Sunny", "Selenium4@#"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("--------------------------------------------------------");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "sunny");
		
		System.out.println("--------------------------------------------------------");
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Sunny")
				.lastName("Salokhe")
				.email("sunnys123@gmail.com")
				.mobileNumber("7856341290")
				.build();
		
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
		
	}

}
