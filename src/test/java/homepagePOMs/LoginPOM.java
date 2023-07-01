package homepagePOMs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPOM {
	
	WebDriver driver;
	public LoginPOM(WebDriver driver){
		this.driver = driver;
	}
	
	/****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  
	 Storing the web_elements in separate variables using By Class from Selenium WebDriver library.
	 **** ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****/
	
	private By username_field = By.name("user-name");
	private By password_field = By.name("password");
	private By login_button = By.xpath("//*[@id=\"login-button\"]");
	

	/****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  
	 Implementing and initializing the core actions of each element. The functions will clear input fields before inserting the data
	 **** ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****  ****/
	
	public void username(String username) {
		WebElement username_input = driver.findElement(username_field);
		username_input.clear();
		username_input.sendKeys(username); 
	}
	
	public void password(String password) {
		WebElement password_input = driver.findElement(password_field);
		password_input.clear();
		password_input.sendKeys(password); 
	}
	
	public void loginButton() {
		WebElement loginButton = driver.findElement(login_button);
		loginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	

}
