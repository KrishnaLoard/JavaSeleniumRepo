package com.krishnasBaseClass.BaseDriver;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.krishnas.KrishnasProjectTesting.pages.ArtofTestingPage;
import com.krishnas.KrishnasProjectTesting.pages.GooglePageBase;
import com.krishnas.KrishnasProjectTesting.pages.MainBasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriverClass {

	public WebDriver driver;
	
	//Pages Initialization 
	public MainBasePage  basePage;
	public GooglePageBase googleBasePage;
	public ArtofTestingPage artofTestingPage;
	
	@BeforeTest
	public void BeforeTestMethod() {
		
	}

	public BaseDriverClass() throws Exception {
		// TODO Auto-generated constructor stub
		CollectionVariables.environmentConfiguration = new Gson();
		FileReader configReader = ReadFileConfig(System.getProperty("user.dir") + "/SeleniumConfigFile.json");

		Type typeConvert = new TypeToken<Map<String, Object>>() {

			private static final long serialVersionUID = 1L;
		}.getType();

		// Map Configuration
		Map<String, Object> configEnv = CollectionVariables.environmentConfiguration.fromJson(configReader,
				typeConvert);
		System.out.println("Environment Configuration File --> " + configEnv);

		// Convert The TestSettings into the Object
		CollectionVariables.configurationEnv = CollectionVariables.environmentConfiguration
				.fromJson(configEnv.get("TestSettings").toString(), ConfigurationEnv.class);
		
		// IF Browser is Google Chrome
		if (CollectionVariables.configurationEnv.getBrowserType().endsWith("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (CollectionVariables.configurationEnv.getBrowserType().endsWith("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		}
		driver.manage().window().maximize();
		basePage = new MainBasePage(driver);
		googleBasePage = new GooglePageBase(driver);
		artofTestingPage = new ArtofTestingPage(driver);
		
		//driver.get("https://" + CollectionVariables.configurationEnv.getBaseUrl());
		driver.get(CollectionVariables.configurationEnv.getBaseUrl());

		// Verify the page title
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		assert title.contains("Google") : "Title does not match!";
	}

	public FileReader ReadFileConfig(String FilePath) {
		try {

			return new FileReader(FilePath);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@AfterTest
	public void AfterTestMethod() {
		try {

			System.out.print("Working Method of the Test Chrome");
			CollectionVariables.LOGGER.info("This is Sample Logger Test");
			CollectionVariables.LOGGER.warn("This Is Warning Message Testing");
			CollectionVariables.LOGGER.error("This Is Error Message Testing");
			Thread.sleep(5000);
			CollectionVariables.LOGGER.info("Killing Driver Instance");
			driver.quit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void CheckMethod() {
		if (googleBasePage.islnkWithTextVisible("Gmail")) {
			System.out.println("Gmail Link is Visibke Dont Worry");
		}
	}
}