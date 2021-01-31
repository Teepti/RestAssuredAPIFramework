package com.scrolltest.api.helpers;







import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


import com.fasterxml.jackson.core.type.TypeReference;
import com.scrolltest.api.constants.Endpoints;
import com.scrolltest.api.model.*;
import com.scrolltest.api.utils.*;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PersonServiceHelper {
	
	static Logger logger = Logger.getLogger(PersonServiceHelper.class);
	
	private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
	private static final String Email = ConfigManager.getInstance().getString("email");
	private static final String Password = ConfigManager.getInstance().getString("password");
	private static final String ProxyIP = ConfigManager.getInstance().getString("proxyIp");
	private static final int Port = Integer.parseInt(ConfigManager.getInstance().getString("port"));
	private static String accessToken;
	
	
	
	public PersonServiceHelper() {
		
		DOMConfigurator.configure("log4j.xml");
		logger.debug("Default settings set in RestAssured object");
		RestAssured.baseURI = BASE_URL;
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	@Step("verify to fetch the list of all resources")
	public Response getAllPersons(){
		
		logger.debug("list of get all persons requested");
		Response response = RestAssured.given().proxy(ProxyIP, Port).auth().oauth2(accessToken)
				            .contentType(ContentType.JSON)
				            .get(Endpoints.GET_ALL_PERSONS)
				            .andReturn();
		
		//Type type = new TypeReference<List<Person>>(){}.getType();
		//List<Person> personList = response.as(type);
		
		logger.debug("list of get all persons returned");
		return response;
	}
	
	@Step("Verify access token is generated or not")
	public String GenerateToken() {
		
		logger.debug("access token is requested");
	    PostToken postToken = new PostToken(BASE_URL);
	    postToken.setContentType("text/plain");
	    postToken.addBodyParam("email", Email);
	    postToken.addBodyParam("password",Password);
	    postToken.setExpectedStatusCode(200);
	    postToken.perform();
	    accessToken = postToken.getAccessToken();
	    
	    logger.debug("access token is generated and returned");
	    return accessToken;
	    
		}
	@Step("Verify new resource is created or not")
	public Response createPerson() {
		
		logger.debug("New person object is created");
		
		Person person = new Person();
		person.setId(3);
		person.setFirstName("Priya");
		person.setLastName("Kumari");
		person.setAge(20);
		person.setGender("Female");
		person.setAddress("shwdfj djfg jsgh jsg");
				
		logger.debug("New person request is initiated");
		Response response = RestAssured.given().proxy(ProxyIP,Port).auth().oauth2(accessToken).contentType(ContentType.JSON)
				            .body(person).when().post(Endpoints.CREATE_PERSON).andReturn();
	    
		logger.debug("New person response is returned");
		return response;
	}
	
	@Step("Verify resource is updated or not using id {0} ")
	public Response updatePerson(String id) {
		
		logger.debug("Person is updated with id" + id);
		
		Person person = new Person();
		person.setFirstName("Teepti");
		person.setLastName("Nath");
		person.setAge(25);
		person.setGender("Male");
		person.setAddress("shwdfj shgfj nsf sjh");
				
		logger.debug("request is created for update person with id"+ id);
		Response response = RestAssured.given().proxy(ProxyIP, Port).auth().oauth2(accessToken).contentType(ContentType.JSON)
				            .pathParam("id", id)
				            .body(person).when().put(Endpoints.UPDATE_PERSON).andReturn();
		
		//assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
		logger.debug("response of updated person is returned");
	    return response;
	}
	
	@Step("Verify resource is deleted or not using id {0} ")
	public Response deletePerson(String id) {
		
		logger.debug("request is created for person id" + id);

		Response response = RestAssured.given().proxy(ProxyIP, Port).auth().oauth2(accessToken).contentType(ContentType.JSON)
				            .pathParam("id", id)
				            .when().delete(Endpoints.DELETE_PERSON).andReturn();
		
		//assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
		
		logger.debug("response is returned for person id" + id);
	    return response;
	}
	
	@Step("Verify single resource is fetched or not using id {0} ")
	public Response getSinglePerson(String id){
		
		logger.debug("request is created for get a single person with id" + id);
		
		Response response = RestAssured.given().proxy(ProxyIP, Port).auth().oauth2(accessToken).pathParam("id", id)
				            .contentType(ContentType.JSON)
				            .get(Endpoints.GET_SINGLE_PERSON)
				            .andReturn();
		logger.debug("response is returned for get a single person with id" + id);
	    return response;
	}
	
	@Step("Verify resource is fetched using query parameter {0} and Value {1} ")
	public Response getPersonByName(String Parameter, String Value ) {
		
		logger.debug("request is created for a person by name" + Value);
		
		Response response = RestAssured.given().proxy(ProxyIP, Port).auth().oauth2(accessToken).param(Parameter, Value)
				           .contentType(ContentType.JSON).get(Endpoints.GET_ALL_PERSONS).andReturn();
		logger.debug("response is returned for a person by name" + Value);
		return response;
		
	}
	
	@Step("Verify proxy is handled or not ") 
	public Response ProxyExample(){
		
		logger.debug("request is created for handling proxy server");
	       
		Response response = RestAssured.given().proxy(ProxyIP, Port).auth().oauth2(accessToken).contentType(ContentType.JSON)
	                        .when().get(Endpoints.GET_ALL_PERSONS).andReturn();
		logger.debug("response is generated for handling proxy server");
		return response;   
	
	}

	

}
