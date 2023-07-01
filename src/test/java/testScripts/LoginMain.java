package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import homepagePOMs.LoginPOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginMain{

		
		WebDriver driver;
		LoginPOM pom_obj;
		
		private String browser;
		private String url;

		public static Properties properties;
		private static String configPath = "configuration/configsetting.properties";
		@BeforeSuite
		public void invoke() throws IOException {
			
			// Load the configuration settings from the properties file
	       
	        try {
	            InputStream file_Input_Stream = new FileInputStream(configPath);
	            properties.load(file_Input_Stream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        

	        // Retrieve the configuration values
	        browser = properties.getProperty("BrowserType");
	        url = properties.getProperty("Environment");
		}
			if(browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("Edge")) {
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else{
				System.err.println("Ooops! Browser Not Found. Try to open on another browser(Chrome,Edge or FireFox)");
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
		}
		
		@Test
		public void userName() {
			pom_obj = new LoginPOM(driver);
			pom_obj.username("standard_user");
		}
		
		
		
		
		
		
		
		
		
		

	}

