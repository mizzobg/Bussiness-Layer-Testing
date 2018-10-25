package com.qa.Hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class StepExecution {
	
	static Response  response=null;
	static int workId=0;
	
	@Given("^all a new entry is made$")
	public void all_a_new_entry_is_made() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type", "application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("city", "test");
		requestParams.put("description", "Don");
		requestParams.put( "id", 8);
		requestParams.put( "name", "h1");
		requestParams.put( "rating", 2);
		request.body(requestParams);
		Response response = request.post(Constants.webSource);
		ValidatableResponse JSON = response.then().statusCode(201);
	}

	@When("^we get the id from post$")
	public void we_get_the_id_from_post() throws ParseException  {
		JSONParser parser = new JSONParser();
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		response = request.get(Constants.webSource+"?page=0&size=100");
		String idString=response.asString();
		
		JSONObject asd =(JSONObject) parser.parse(idString);
		JSONArray basd =(JSONArray) asd.get("content");
		for(int i=0; i<basd.size(); i++){
		    if(city.city == "test") ;
		}
//		String count =asd.get("totalElements").toString();
//		workId = Integer.parseInt(count)+1;
//		JSONArray jsonArray = (JSONArray) parser.parse(idString);
//		for (Object object : jsonArray) { //array is made up of objects
//			JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
//		
//		}	
//		String idString=JsonPath.from(response).get("elements");
//		JSONObject jsonObject = new JSONObject();
		
//		JSONArray myResponse = asd.getJSONArray("elements");
		

		
		System.out.println(basd);
		
    }
	

	@When("^preform a put on the id$")
	public void preform_a_put_on_the_id() throws Throwable {
	   
	}

	@When("^we get the id from post and delet that item$")
	public void we_get_the_id_from_post_and_delet_that_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify the code$")
	public void verify_the_code() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^check that the id is not in the database$")
	public void check_that_the_id_is_not_in_the_database() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
