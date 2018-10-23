package com.qa.OMDB;

import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class stepExecution {
	JSONParser parser = new JSONParser();
	static Response  response=null;
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() {
		RequestSpecification request = RestAssured.given();
	
	}

	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() {
		RequestSpecification request = RestAssured.given();
		response = request.get(Constants.webSource+Constants.apiKey+"&t=Guardians of the Galaxy vol");

	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) {
		ValidatableResponse JSON = response.then().statusCode(arg1);
		
	}

	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() {
		RequestSpecification request = RestAssured.given();
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() {
		RequestSpecification request = RestAssured.given();
		response = request.get(Constants.webSource+Constants.apiKey+"&t=IT");
	}

	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() throws ParseException {
		String rating=response.asString();
		JSONObject asd =(JSONObject) parser.parse(rating);
		assertEquals(true,asd.get("Rated").equals("R"));
		
	}
	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) {
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		response = request.get(Constants.webSource+Constants.apiKey+"&t="+arg1);
	}

	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) {
		RequestSpecification request = RestAssured.given();
		response = request.get(Constants.webSource+Constants.apiKey+"&t="+arg1);
	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) throws Throwable {
		String rating=response.asString();
		JSONObject asd =(JSONObject) parser.parse(rating);
		assertEquals(true,asd.get("Rated").equals(arg1));
	}
}
