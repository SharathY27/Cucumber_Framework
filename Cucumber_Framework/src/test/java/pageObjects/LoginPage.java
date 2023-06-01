package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private static LoginPage loginInstance;
	
	private LoginPage(){}
	
	public static  LoginPage getInstance() {
		
		if(loginInstance==null) {
			loginInstance = new LoginPage();
		}
		
		return loginInstance;
	}
	
	
	@FindBy(name = "username")
	private WebElement Username;
	@FindBy(name = "password")
	private WebElement Password;
	@FindBy(xpath = "//button[normalize-space(text()='Login')]")
	private WebElement Login_Button;

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogin_Button() {
		return Login_Button;
	}

}
