package com.krishnas.KrishnasProjectTesting.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.krishnasBaseClass.BaseDriver.CollectionVariables;

public class MainBasePage {

	WebDriver driver;
	WebDriverWait driverWait;

	public MainBasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		driverWait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(CollectionVariables.configurationEnv.getTimeOut())));
	}

	public By lnkWithText(String linktxt) {
		return By.xpath(String.format("//a[text()='%s']", linktxt));
	}

	public By txtbxWithid(String id) {
		return By.xpath(String.format("//input[@id='%s']", id));
	}

	public By btnWithId(String btnId) {
		return By.xpath(String.format("//button[@id='%s']", btnId));
	}

	public boolean CheckifElementPresent(By locatorPath) {
		try {

			driverWait.until(ExpectedConditions.presenceOfElementLocated(locatorPath));
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}