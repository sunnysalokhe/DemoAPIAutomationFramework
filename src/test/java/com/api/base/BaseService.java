package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	// BASE URI
	// CREATING THE REQUEST
	// HANDLING THE RESPONSE
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestspecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		requestspecification = given().baseUri(BASE_URL);
		
	}
	
	protected Response putRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	// To attach authentication token
	protected void setAuthToken(String token) {
		requestspecification.header("Authorization", "Bearer " +token);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestspecification.get(endpoint);
	}
	
	
	protected Response postRequest(String baseurl, Object payload, String endpoint) {
		return requestspecification.baseUri(baseurl).contentType(ContentType.JSON).body(payload).post(endpoint);
	}

}
