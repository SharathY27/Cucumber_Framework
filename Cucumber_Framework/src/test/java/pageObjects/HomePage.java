package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private static HomePage homeInstance;
	
	private HomePage() {
		
	}
	
	public static HomePage getInstance() {
		
		if(homeInstance==null) {
			homeInstance = new HomePage();
		}
		return homeInstance;
	}
	
	@FindBy(linkText = "Directory")
	private WebElement directory;

	public WebElement getDirectory() {
		return directory;
	}
	
	

}
