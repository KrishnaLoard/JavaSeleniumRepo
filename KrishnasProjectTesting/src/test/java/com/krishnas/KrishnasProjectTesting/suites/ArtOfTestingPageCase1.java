package com.krishnas.KrishnasProjectTesting.suites;

import org.openqa.selenium.By;
import org.testng.Assert;
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

		try {
			
			CollectionVariables.LOGGER.info("Starting Test Case --> " + this.getClass().getCanonicalName());
			CollectionVariables.LOGGER.info("STEP: 1 --> Loading the Art Page");
			driver.get(CollectionVariables.configurationEnv.getCase1Url());

			CollectionVariables.LOGGER.info("STEP: 2 --> Checking the Link on the page");
			boolean linkVisble = artofTestingPage.CheckifElementPresent(artofTestingPage.lnkWithText("This is a link"));

			CollectionVariables.LOGGER.info("Expected OutPut --> Checking This is Link Avaiable");
			assert linkVisble == true : "This is Link is not Availe on the ArtofTesting Page";

			CollectionVariables.LOGGER.info("STEP: 3 --> Checking Email Text box is Visble");
			boolean inptEmailvisble = artofTestingPage.CheckifElementPresent(artofTestingPage.txtbxWithid("email"));

			CollectionVariables.LOGGER.info("Expected OutPut --> Checking Email Text Box");
			Assert.assertFalse(inptEmailvisble, "Email Box is Visble.");

			CollectionVariables.LOGGER.info("STEP: 4 --> Checking Double Click Button");
			boolean btndoubleClick = artofTestingPage
					.CheckifElementPresentWithScroll(artofTestingPage.btnWithId("dblClkBtn"));

			CollectionVariables.LOGGER.info("Expected OutPut --> Checking if Double Click Button is Avaibale");
			Assert.assertTrue(btndoubleClick, "Double Click Button is not Visible");

			CollectionVariables.LOGGER.info("STEP: 5 --> Checking Male Radio Button");
			boolean radioMaleButton = artofTestingPage.CheckifElementPresent(artofTestingPage.txtbxWithid("male"));

			CollectionVariables.LOGGER.info("Expected OutPut --> Checking if Double Click Button is Avaibale");
			Assert.assertTrue(radioMaleButton, "Radio Button Male is not Avalible");

			CollectionVariables.LOGGER.info("STEP: 6 --> Checking Female Radio Button");
			boolean radiofemaleButton = artofTestingPage.CheckifElementPresent(artofTestingPage.txtbxWithid("male"));

			CollectionVariables.LOGGER.info("Expected OutPut --> Checking Female button");
			Assert.assertTrue(radiofemaleButton, "Radio Button Female is not Avalible");

			CollectionVariables.LOGGER.info("STEP: 7 --> Doing Scroll Test");
			boolean scrollFlag = artofTestingPage.ScrollSingle(2);
			
			CollectionVariables.LOGGER.info("Expected OutPut --> Scroll Test Method");
			Assert.assertTrue(scrollFlag, "Failed Scroll Test");
			
			CollectionVariables.LOGGER.info("STEP: 8 --> Check Box Testing");
			boolean chkBoxAutomationTesting = driver.findElement(By.xpath("//input[@class='Automation']")).isDisplayed();
			
			CollectionVariables.LOGGER.info("Expected OutPut --> Check Box Testing");
			Assert.assertTrue(chkBoxAutomationTesting, "Check Box Automation Testing not Found");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
