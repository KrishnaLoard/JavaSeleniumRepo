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
		CollectionVariables.LOGGER.info("STEP: 1 --> Loading the Art Page");
		driver.get("https://artoftesting.com/samplesiteforselenium");
		
		CollectionVariables.LOGGER.info("STEP: 2 --> Checking the Link on the page");
		boolean linkVisble = artofTestingPage.CheckifElementPresent(artofTestingPage.lnkWithText("This is a link"));
		
		CollectionVariables.LOGGER.info("Expected OutPut --> Checking This is Link Avaiable");
		assert linkVisble == true : "This is Link is not Availe on the ArtofTesting Page";
		
		CollectionVariables.LOGGER.info("Killing Driver Instance");
		testGooglePage();
	}
}
