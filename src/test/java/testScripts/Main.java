package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import homepagePOMs.LoginPOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static WebDriver driver;
	LoginPOM pom_obj;
	public static Properties property;
	private static String configPath = "configuration\\configsetting.properties";
	
	
	@BeforeClass
	public void setUp() throws IOException {
	
		property = new Properties();
		InputStream in_istrm = new FileInputStream(configPath);
		property.load(in_istrm);
		
		String my_browser = property.getProperty("BrowserType");
		String my_url = property.getProperty("Environment");
		
		if(my_browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(my_browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else if(my_browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			
		}
	
		driver.get(my_url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Parameters("username")
	@Test(priority = 1)
	public void userName(String username) throws InterruptedException {
	    pom_obj = new LoginPOM(driver);
		pom_obj.username(username);
		Thread.sleep(2000);
	}


	@Parameters("password")
	@Test(priority = 2)
	public void passWord(String password) throws InterruptedException {
	    pom_obj = new LoginPOM(driver);
		pom_obj.password(password);
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void loginButton() throws InterruptedException {
	    pom_obj = new LoginPOM(driver);
		pom_obj.loginButton();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void teardown() {
		
		driver.close();
	}

}
