package com.qa.Hotel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Hotel_Tests {
	JSONParser parser = new JSONParser();
	static Response  response=null;
	
	@Test
	public void runGetTest() {
		RequestSpecification request = RestAssured.given();
		response = request.get(Constants.webSource);
		ValidatableResponse JSON = response.then().statusCode(200);
	}
	@Test
	public void runPostTest() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type", "application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("city", "lon");
		requestParams.put("description", "Don");
		requestParams.put( "id", 5);
		requestParams.put( "name", "h1");
		requestParams.put( "rating", 2);
		request.body(requestParams);
		Response response = request.post(Constants.webSource);
		ValidatableResponse JSON = response.then().statusCode(201);
	}
	
	@Test
	public void runDeleteTest() {
		RequestSpecification request = RestAssured.given();
		request.header("Accept", "application/json");
		JSONObject requestParams = new JSONObject();
		request.body(requestParams);
		Response response = request.delete(Constants.webSource+"/2");
		ValidatableResponse JSON = response.then().statusCode(204);
	}
	
	@Test
	public void runGetIDTest() {
		RequestSpecification request = RestAssured.given();
		response = request.get(Constants.webSource+"/4");
		ValidatableResponse JSON = response.then().statusCode(200);
	}
	
	@Test
	public void runPutTest() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type", "application/json");
		request.header("Accept", "application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("city", "Hello");
		requestParams.put("description", "My");
		requestParams.put( "id", 3);
		requestParams.put( "name", "Fr");
		requestParams.put( "rating", 2);
		request.body(requestParams);
		Response response = request.put(Constants.webSource+"/3");
		ValidatableResponse JSON = response.then().statusCode(204);
	}
}
