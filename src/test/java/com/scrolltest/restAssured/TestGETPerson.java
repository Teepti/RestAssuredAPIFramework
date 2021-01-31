package com.scrolltest.restAssured;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.PersonServiceHelper;
import com.scrolltest.api.model.Person;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class TestGETPerson {
	
	public PersonServiceHelper personServiceHelper;
	static Logger logger = Logger.getLogger(TestGETPerson.class);
	
	@BeforeClass
	public void init() {
		
		personServiceHelper = new PersonServiceHelper();
		personServiceHelper.GenerateToken();
		
	}
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify to get list of all the persons")
	public void testGetAllPerson() {
		
		logger.info("This test is started to get the list of all persons");
		Response response = personServiceHelper.getAllPersons();
		System.out.println(response.asString());
		Assert.assertNotNull(response,"response is not empty");
		logger.info("This test is ended to get the list of all persons");
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify to get list of single person using id parameter")
	public void testGetSinglePerson() {
		logger.info("This test is started to get single person");
		Response response = personServiceHelper.getSinglePerson("3");
		System.out.println(response.asString());
		logger.info("This test is ended to get single person");
	}
	
	@Test
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Verify to get list of all the persons using name")
	public void testGetPersonUsingParameter() {
		logger.info("This test is started to get a person by name");
		String Parameter = "first name";
		String Value = "Teepti";
		Response response = personServiceHelper.getPersonByName(Parameter, Value);
		System.out.println(response.asString());
		logger.info("This test is ended to get a person by name");
	}

}
