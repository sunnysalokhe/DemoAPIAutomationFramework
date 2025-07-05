package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.models.response.LoginResponse;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter  {

	private static final Logger looger = LogManager.getLogger(LoggingFilter.class);
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec); // request is going to execute
		logResponse(response);;
		return response; //test for assertion
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		looger.info("BASE URI:" +requestSpec.getBaseUri());
		looger.info("Request Header" +requestSpec.getHeaders());
		looger.info("Request Payload:"+requestSpec.getBody());	
	}
	
	public void logResponse(Response response) {
		looger.info("STATUS CODE:" +response.getStatusCode());
		looger.info("Response Body" +response.getBody().prettyPrint());
		looger.info("Response Header:"+response.headers());	
		
	}
	
}