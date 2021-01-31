package com.scrolltest.restAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scrolltest.api.helpers.PersonServiceHelper;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TestDELETEPerson {
	
	public PersonServiceHelper personServiceHelper;
	
	
	@BeforeClass
	public void init() {
		
		personServiceHelper = new PersonServiceHelper();
		personServiceHelper.GenerateToken();
		
	}
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify to delete resources")
	public void testDeletePerson() {
		
		String id = personServiceHelper.deletePerson("3").jsonPath().getString("id");
		Assert.assertNull(id,"id should be null");
		
	}

}
