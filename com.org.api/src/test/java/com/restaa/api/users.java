package com.restaa.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class users {
	
	@Test
	public void getUsers() {
		Response res = when()
				.get("http://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test
	public void getUser() {
		Response res = given().param("user", 2).when()
				.get("http://reqres.in/api/users");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test
	public void getInvalidUser() {
		given().
		param("user", 2300).
		when().
		get("http://reqres.in/api/users").
		then().
		assertThat().statusCode(200);
		}
	
	@Test
	public void getListOfUsers() {
		Response res =	given().
		when().
		get("https://reqres.in/api/unknown");
		
		
	}
	

}
