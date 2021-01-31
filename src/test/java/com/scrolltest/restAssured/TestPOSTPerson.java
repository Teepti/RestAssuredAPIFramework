package com.scrolltest.restAssured;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.PersonServiceHelper;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class TestPOSTPerson {
	
	private PersonServiceHelper personServiceHelper;
	static Logger logger = Logger.getLogger(TestPOSTPerson.class);
	
	@BeforeClass
	public void init() {
		
		personServiceHelper = new PersonServiceHelper();
		personServiceHelper.GenerateToken();
		
	}
	
	@Test
	@Severity(SeverityLevel.MINOR)
	@Description("Verify to create new resources")
	public void createNewPerson() {
		
		logger.debug("Test is started to create new person");
		Response response = personServiceHelper.createPerson();
		System.out.println(response.asString());
		logger.debug("Test is ended to create new person");
		
	}

}
