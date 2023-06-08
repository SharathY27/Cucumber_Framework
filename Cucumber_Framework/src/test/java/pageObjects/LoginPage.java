package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

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
		CommonUtils.getInstance().highlightingElement(Username);
		return Username;
	}

	public WebElement getPassword() {
		CommonUtils.getInstance().highlightingElement(Password);
		return Password;
	}

	public WebElement getLogin_Button() {
		CommonUtils.getInstance().highlightingElement(Login_Button);
		return Login_Button;
	}

}
