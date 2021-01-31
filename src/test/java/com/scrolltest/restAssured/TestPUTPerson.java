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

public class TestPUTPerson {
	
private PersonServiceHelper personServiceHelper;
static Logger logger = Logger.getLogger(TestPUTPerson.class);
	
	@BeforeClass
	public void init() {
		
		personServiceHelper = new PersonServiceHelper();
		personServiceHelper.GenerateToken();
		
	}
	
	@Test
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Verify to update resources")
	public void testPutPerson() {
		
		logger.debug("Test is started to update person");
		Response response = personServiceHelper.updatePerson("3");
		System.out.println(response.asString());
		logger.debug("Test is ended to update person");
		
		
	}

}
