package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dynamic_Table_StepDefinition {
	
	@Given("open new tab and close")
	public void open_new_tab_and_close() {
			JavascriptExecutor js =((JavascriptExecutor) DriverManager.getDriver());
			js.executeScript("window.open()");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
			DriverManager.getDriver().switchTo().window(tabs.get(1));
			DriverManager.getDriver().get("https://www.google.com");
			DriverManager.getDriver().close();
			DriverManager.getDriver().switchTo().window(tabs.get(0));
	}

	@Given("user is successfully logged in")
	public void user_is_successfully_logged_in() {
	    
	    
	}

	@When("user navigate to dynamic table webpage")
	public void user_navigate_to_dynamic_table_webpage() {
		DriverManager.getDriver().get("http://www.uitestingplayground.com/dynamictable");
	    
	}

	@Then("get Network  and Memory of Chrome Browser")
	public void get_network_and_memory_of_chrome_browser() {
		
		WebDriver driver = DriverManager.getDriver();
		Map<String,Integer> map = new HashMap<String,Integer>();
		int count=1;
		for(WebElement i :  driver.findElements(By.xpath("//div[@role='table']/div[2]/div//span"))){
			map.put(i.getText(), count);
			count++;
		}
		int noOfRows = driver.findElements(By.xpath("//div[@role='table']/div[3]/div")).size();
		
		int indexValueOfName = map.get("Name");
		int indexValueOfCPUColumn = map.get("CPU");
		int indexValueOfMemoryColumn = map.get("Memory");
		
		for(int i=1;i<=noOfRows;i++) {
			if(driver.findElement(By.xpath("//div[@role='table']/div[3]//div["+i+"]/span["+indexValueOfName+"]")).getText().equalsIgnoreCase("Chrome")) {
				String cpu = driver.findElement(By.xpath("//div[@role='table']/div[3]//div["+i+"]//span["+indexValueOfCPUColumn+"]")).getText();
				String memory = driver.findElement(By.xpath("//div[@role='table']/div[3]//div["+i+"]//span["+indexValueOfMemoryColumn+"]")).getText();
				System.out.println(cpu + " , "+ memory);
			}
		}
	    
	    
	}

}
