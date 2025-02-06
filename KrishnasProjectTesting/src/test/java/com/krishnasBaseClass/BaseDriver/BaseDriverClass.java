package com.krishnasBaseClass.BaseDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.krishnas.KrishnasProjectTesting.pages.GooglePageBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriverClass {
	
	public WebDriver driver;
	public GooglePageBase googleBasePage;

	public BaseDriverClass() {
		// TODO Auto-generated constructor stub
		//System.setProperty("webdriver.chrome.driver", "/Users/kishanbheemajiyani/Eclipse/ChromeDriver/chromedriver-mac-arm64/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		googleBasePage = new GooglePageBase(driver);
		driver.get("https://www.google.com");

        // Verify the page title
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        assert title.contains("Google") : "Title does not match!";
	}
	
	public void testGooglePage() {
		try {
			
			System.out.print("Working Method of the Test Chrome");
			Thread.sleep(5000);
			driver.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void CheckMethod() {
		if(googleBasePage.islnkWithTextVisible("Gmail")) 
		{
			System.out.println("Gmail Link is Visibke Dont Worry");
		}
	}
	
	public static void main(String[] args) {
		//BaseDriverClass baseDriverClass = new BaseDriverClass();		
		//baseDriverClass.CheckMethod();
		//baseDriverClass.testGooglePage();
		System.out.println("Working Directory --> " + System.getProperty("user.dir"));
	}
}
