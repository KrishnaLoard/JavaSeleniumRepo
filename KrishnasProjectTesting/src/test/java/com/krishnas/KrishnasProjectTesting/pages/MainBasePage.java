package com.krishnas.KrishnasProjectTesting.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainBasePage {
	
	WebDriver driver;
	WebDriverWait driverWait;

	public MainBasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public By lnkWithText(String linktxt) {
		return By.xpath(String.format("//a[text()='%s']", linktxt));
	}
	
	public By txtbxWithid(String id) {
		return By.xpath(String.format("//input[@id='%s']", id));
	}

}
