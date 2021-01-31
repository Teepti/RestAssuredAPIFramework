package com.scrolltest.restAssured;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.PersonServiceHelper;
import com.scrolltest.api.model.Person;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class TestIntegration {
	
public PersonServiceHelper personServiceHelper;
	
	@BeforeClass
	public void init() {
		
		personServiceHelper = new PersonServiceHelper();
		personServiceHelper.GenerateToken();
		
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify to test multiple http methods in one go")
	public void testAllCrudMethods() {
		
		Response response = personServiceHelper.deletePerson("3");
		System.out.println(response.asString());
		Response responseGet = personServiceHelper.getAllPersons();
		System.out.println(responseGet.asString());
		Response response1 = personServiceHelper.createPerson();
		System.out.println(response1.asString());
		responseGet = personServiceHelper.getAllPersons();
		System.out.println(responseGet.asString());
		Response response2 = personServiceHelper.updatePerson("3");
		System.out.println(response2.asString());
		responseGet = personServiceHelper.getAllPersons();
		System.out.println(responseGet.asString());
		
 }
	}
