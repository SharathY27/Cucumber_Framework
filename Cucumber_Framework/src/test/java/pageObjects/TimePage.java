package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

public class TimePage {

	@FindBy(xpath = "//ul/li//span[text()='Time']")
	private WebElement TimeButton;

	@FindBy(xpath = "//form//button[text()[normalize-space()='View']]")
	private WebElement ViewButton;

	private static TimePage timeInstance;

	private TimePage() {

	}

	public static TimePage getInstance() {

		if (timeInstance == null) {
			timeInstance = new TimePage();
		}

		return timeInstance;
	}

	public WebElement getTimeButton() {
		CommonUtils.getInstance().highlightingElement(TimeButton);
		return TimeButton;
	}

	public WebElement getViewButton() {
		CommonUtils.getInstance().highlightingElement(ViewButton);
		return ViewButton;
	}

}
