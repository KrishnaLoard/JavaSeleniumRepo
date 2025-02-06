package com.krishnas.KrishnasProjectTesting.suites;

import org.testng.annotations.Test;

import com.krishnasBaseClass.BaseDriver.BaseDriverClass;
import com.krishnasBaseClass.BaseDriver.CollectionVariables;

public class ArtOfTestingPageCase1 extends BaseDriverClass {

	public ArtOfTestingPageCase1() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Test
	public void ElementPresetTest() {
		CollectionVariables.LOGGER.info("Starting Test Case --> " + this.getClass().getCanonicalName());
	}

	public static void main(String[] args) {
		try {
			ArtOfTestingPageCase1 Test1 = new ArtOfTestingPageCase1();
			System.out.println(Test1.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			CollectionVariables.LOGGER.error("Error into the Test Case --> " + e.getMessage());
		}
	}
}
